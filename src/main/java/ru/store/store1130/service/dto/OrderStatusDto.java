package ru.store.store1130.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class OrderStatusDto {
    private Long id;
    private String nameOfStatus;

}
