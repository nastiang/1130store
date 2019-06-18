package ru.store.store1130.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.store.store1130.db.model.UserRole;

import java.util.Set;

@Data
@Accessors(chain = true)
public class UserDto {

    private Long id;
    private String email;
    private boolean enabled;
    private String password;
    private UserRole role;
}
