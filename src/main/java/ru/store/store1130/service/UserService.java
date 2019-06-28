package ru.store.store1130.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.store.store1130.db.model.User;
import ru.store.store1130.service.dto.UserDto;


public interface UserService extends UserDetailsService {

    UserDto getOneUser(String email, String password);
    UserDto addUser(UserDto userDto);
    UserDto updateUser(User userFromDB, UserDto userDto);
    User findUserByEmail(String email);
    void deleteUser(User user);

}
