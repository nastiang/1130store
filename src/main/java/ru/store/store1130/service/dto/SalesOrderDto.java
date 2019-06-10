package ru.store.store1130.service.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.store.store1130.db.model.OrderCategory;
import ru.store.store1130.db.model.OrderStatus;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.db.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
public class SalesOrderDto {
    private Long id;
    private LocalDateTime date;
    private BigDecimal sum;
    private User user;
    private List<Product> productList;
    ;
    private OrderStatus status;
    private OrderCategory orderCategory;

}
