package ru.store.store1130.mapper.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.db.model.ProductCategory;
import ru.store.store1130.mapper.ProductCategoryMapper;
import ru.store.store1130.mapper.ProductMapper;
import ru.store.store1130.service.dto.ProductCategoryDto;
import ru.store.store1130.service.dto.ProductDto;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto productCategoryToDto(Product product) {
        ProductDto productDto = new ProductDto();

        BeanUtils.copyProperties(product, productDto);

        return productDto;
    }

    @Override
    public Product productCategoryDtoToEntity(ProductDto productDto) {
        Product product = new Product();

        BeanUtils.copyProperties(productDto, product);

        return product;
    }
}
