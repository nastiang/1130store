package ru.store.store1130.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ProductCategoryDto {
    private Long id;
    private String nameOfProductCategory;

}
