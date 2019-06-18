package ru.store.store1130.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import lombok.experimental.Accessors;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.db.model.SalesOrder;
@Accessors(chain = true)
@Data

public class ProductInOrderDto {
    private Long id;
    private Product product;
    private SalesOrder salesOrder;
    private int quantity;

}
