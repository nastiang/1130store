package ru.store.store1130.service;

import org.springframework.data.domain.Page;
import ru.store.store1130.db.model.User;
import ru.store.store1130.service.dto.UserDto;

import java.awt.print.Pageable;

public interface UserService {

    UserDto getOneUser(String email, String password);
    UserDto addUser(UserDto userDto);
    UserDto updateUser(User userFromDB, UserDto userDto);
    void deleteUser(User user);

}
