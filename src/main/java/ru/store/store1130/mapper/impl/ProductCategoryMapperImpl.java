package ru.store.store1130.mapper.impl;

import org.springframework.stereotype.Component;
import ru.store.store1130.db.model.ProductCategory;
import ru.store.store1130.mapper.ProductCategoryMapper;
import ru.store.store1130.service.dto.ProductCategoryDto;

@Component
public class ProductCategoryMapperImpl implements ProductCategoryMapper {
    @Override
    public ProductCategoryDto productCategoryToDto(ProductCategory productCategory) {
        ProductCategoryDto productCategoryDto = new ProductCategoryDto();

        productCategoryDto.setId(productCategory.getId());
        productCategoryDto.setNameOfProductCategory(productCategory.getNameOfProductCategory());

        return productCategoryDto;
    }

    @Override
    public ProductCategory productCategoryDtoToEntity(ProductCategoryDto productCategoryDto) {
        ProductCategory productCategory = new ProductCategory();

        productCategory.setId(productCategoryDto.getId());
        productCategory.setNameOfProductCategory(productCategoryDto.getNameOfProductCategory());

        return productCategory;
    }
}
