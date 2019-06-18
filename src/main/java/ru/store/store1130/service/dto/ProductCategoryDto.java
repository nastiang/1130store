package ru.store.store1130.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@NoArgsConstructor

public class ProductCategoryDto {
    private Long id;
    private String nameOfProductCategory;

}
