package ru.store.store1130.service.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OrderStatusDto {
    private Long id;
    private String nameOfStatus;

}
