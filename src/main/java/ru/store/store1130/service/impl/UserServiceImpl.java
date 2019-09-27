package ru.store.store1130.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;

import ru.store.store1130.db.model.User;
import ru.store.store1130.db.model.UserRole;
import ru.store.store1130.db.repository.UserRepository;
import ru.store.store1130.db.repository.UserRoleRepository;
import ru.store.store1130.service.UserService;
import ru.store.store1130.service.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j

public class UserServiceImpl implements UserService {

    @Autowired UserRepository userRepository;

    @Autowired UserRoleRepository userRoleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public User register(UserDto userDto) {
        UserRole userRole = userRoleRepository.findByNameOfRole("ROLE_USER");
        List<UserRole> userRoles = new ArrayList<>();
        userRoles.add(userRole);

        User user = new User();
        user.setRoles(userDto.getRoles());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());

        User registerUser = userRepository.save(user);

        log.info("In register user{} succesfully regisrered ");
        return registerUser;
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            log.warn("IN findBYId user not found");
        }
        log.info("IN findById user{} found by id{}", user, id);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        log.info("IN findByName user{} found by name{}", user, email);

        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        log.info("IN getAll users{} found", users);

        return users;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("IN delete user{} deleted", id);
    }
}
