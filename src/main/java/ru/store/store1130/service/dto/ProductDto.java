package ru.store.store1130.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.store.store1130.db.model.ProductCategory;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ProductDto {
    private Long id;
    private String nameOfProduct;
    private BigDecimal price;
    private BigDecimal cost;
    private ProductCategory productCategory;
}
