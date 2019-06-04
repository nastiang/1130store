package ru.store.store1130.service.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.store.store1130.db.model.OrderStatus;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.db.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class OrderDto {
    private Long id;
    private LocalDateTime date;
    private BigDecimal sum;
    private User user;
    private Product product;
    private OrderStatus status;

}
