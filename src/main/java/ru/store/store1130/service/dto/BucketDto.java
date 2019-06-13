package ru.store.store1130.service.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.store.store1130.db.model.Product;

@Data
@Accessors(chain = true)
public class BucketDto {
    private Long id;
    private Product product;
    private Integer value;

}
