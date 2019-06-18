package ru.store.store1130.mapper;

import org.mapstruct.Mapper;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.service.dto.ProductDto;

@Mapper
public interface ProductMapper {
    ProductDto productCategoryToDto(Product product);
    Product productCategoryDtoToEntity(ProductDto productDto);
}
