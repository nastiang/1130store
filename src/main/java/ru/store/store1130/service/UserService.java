package ru.store.store1130.service;

import ru.store.store1130.db.model.Product;
import ru.store.store1130.db.model.User;
import ru.store.store1130.service.dto.ProductDto;
import ru.store.store1130.service.dto.UserDto;

public interface UserService {
    UserDto getOneUser(Long id);
    UserDto addUser(UserDto userDto);
    UserDto updateUser(User userFromDB, UserDto userDto);
    void deleteUser(User user);
}
