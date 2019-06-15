package ru.store.store1130.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class UserRoleDto {
    private Long id;
    private String nameOfRole;

}
