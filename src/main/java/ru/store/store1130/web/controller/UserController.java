package ru.store.store1130.web.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.store.store1130.db.model.User;
import ru.store.store1130.db.repository.UserRepository;
import ru.store.store1130.mapper.UserMapper;
import ru.store.store1130.service.UserService;
import ru.store.store1130.service.dto.UserDto;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Data
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")

    public List<UserDto> getUsers() {

        return userRepository.findAll().
                stream().
                map(userMapper::userToDto).
                collect(toList());

    }

    @GetMapping("{email}/{password}")
    public UserDto getOne(@PathVariable String email, @PathVariable String password) {

        return userService.getOneUser(email, password);

    }

    @PostMapping("/add")
    public UserDto createUser(@RequestBody UserDto userDto) {

        return userService.addUser(userDto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable("id") User user) {

        userService.deleteUser(user);

    }

    @PutMapping("{id}")
    public UserDto updateUser(@PathVariable("id") User userFromDB, @RequestBody UserDto userDto) {
        return userService.updateUser(userFromDB, userDto);
    }
}
