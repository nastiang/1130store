package ru.store.store1130.mapper;

import org.mapstruct.Mapper;
import ru.store.store1130.db.model.ProductCategory;
import ru.store.store1130.service.dto.ProductCategoryDto;

@Mapper
public interface ProductCategoryMapper {
    ProductCategoryDto productCategoryToDto(ProductCategory productCategory);
    ProductCategory productCategoryDtoToEntity(ProductCategoryDto productCategoryDto);
}
