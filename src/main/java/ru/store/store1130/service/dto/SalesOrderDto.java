package ru.store.store1130.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.store.store1130.db.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
<<<<<<< HEAD:src/main/java/ru/store/store1130/service/dto/SalesOrderDto.java
import java.util.List;

@Data
@Accessors(chain = true)
=======
import java.util.LinkedHashMap;
import java.util.List;
@Accessors(chain = true)
@Data
>>>>>>> master:src/main/java/ru/store/store1130/service/dto/SalesOrderDto.java
public class SalesOrderDto {
    private Long id;
    private LocalDateTime date;
    private BigDecimal sum;
    private User user;
<<<<<<< HEAD:src/main/java/ru/store/store1130/service/dto/SalesOrderDto.java
    private List<Product> productList;
    ;
    private OrderStatus status;
=======
    private SalesOrderStatus status;
    private List<ProductInOrder> productInOrders;
>>>>>>> master:src/main/java/ru/store/store1130/service/dto/SalesOrderDto.java
    private OrderCategory orderCategory;

}
