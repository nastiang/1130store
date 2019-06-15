package ru.store.store1130.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.store.store1130.db.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
@Accessors(chain = true)
@Data
public class SalesOrderDto {
    private Long id;
    private LocalDateTime date;
    private BigDecimal sum;
    private User user;
    private SalesOrderStatus status;
    private List<ProductInOrder> productInOrders;
    private OrderCategory orderCategory;

}
