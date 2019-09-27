package ru.store.store1130.service;

import ru.store.store1130.db.model.User;
import ru.store.store1130.service.dto.UserDto;

import java.util.List;

public interface UserService {
    User register(UserDto userDto);

    User findById(Long id);

    User findByEmail(String email);

    List<User> getAll();

    void delete(Long id);

}
