package ru.store.store1130.mapper.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import ru.store.store1130.db.model.User;
import ru.store.store1130.mapper.UserMapper;
import ru.store.store1130.service.dto.UserDto;

@Component
public class UserMapperImpl implements UserMapper {


    @Override
    public UserDto userToDto(User user) {
        UserDto userDto = new UserDto();

        BeanUtils.copyProperties(user, userDto);

        return userDto;

    }

    @Override
    public User userDtoToEntity(UserDto userDto) {
        User user = new User();

        BeanUtils.copyProperties(userDto, user);

        return user;
    }
}
