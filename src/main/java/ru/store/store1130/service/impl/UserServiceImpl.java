package ru.store.store1130.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.store.store1130.db.model.User;
import ru.store.store1130.db.repository.UserRepository;
import ru.store.store1130.mapper.UserMapper;
import ru.store.store1130.service.UserService;
import ru.store.store1130.service.dto.UserDto;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto getOneUser(String email, String password) {
            return userMapper.userToDto(userRepository.findByEmailAndPassword(email, password).get());
    }

    @Override
    public UserDto addUser(UserDto userDto) {

        User user = userMapper.userDtoToEntity(userDto);
        User save = userRepository.save(user);

        return userMapper.userToDto(save);
    }

    @Override
    public UserDto updateUser(User userFromDB, UserDto userDto) {
        Long id = userFromDB.getId();
        BeanUtils.copyProperties(userDto, userFromDB);
        userFromDB.setId(id);

        User save = userRepository.save(userFromDB);

        return userMapper.userToDto(save);
    }

    @Override
    public User findUserByEmail(String email) {
        User user = userRepository.findByEmail(email);

        if (user == null)
            throw new UsernameNotFoundException("User not found");

        return user;
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return findUserByEmail(s);
    }
}
