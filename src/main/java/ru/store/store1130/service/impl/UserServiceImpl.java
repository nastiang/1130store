package ru.store.store1130.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.store.store1130.db.model.User;
import ru.store.store1130.service.UserService;
import ru.store.store1130.service.dto.UserDto;
import ru.store.store1130.web.ConverterDomainToDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ConverterDomainToDto converter;

    @Override
    public UserDto getOneUser(Long id) {
        return null;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto updateUser(User userFromDB, UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUser(User user) {

    }
}
