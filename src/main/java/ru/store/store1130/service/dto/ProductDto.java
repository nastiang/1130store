package ru.store.store1130.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.experimental.Accessors;
import ru.store.store1130.db.model.ProductCategory;

import java.math.BigDecimal;

@Accessors(chain = true)
@Data
@NoArgsConstructor

public class ProductDto {
    private Long id;
    private String nameOfProduct;
    private BigDecimal price;
    private BigDecimal cost;
    private int count;
    private ProductCategory productCategory;
}
