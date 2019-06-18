package ru.store.store1130.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.store.store1130.db.model.User;

public interface UserService extends UserDetailsService{
    User findUserByEmail(String email);
}
