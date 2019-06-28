package ru.store.store1130.mapper;

import org.mapstruct.Mapper;
import ru.store.store1130.db.model.User;
import ru.store.store1130.service.dto.UserDto;

@Mapper
public interface UserMapper {

    UserDto userToDto(User user);
    User userDtoToEntity(UserDto userDto);

}
