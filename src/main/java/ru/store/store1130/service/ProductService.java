package ru.store.store1130.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.service.dto.ProductDto;

public interface ProductService {
    Page<ProductDto> getAllProduct(Pageable p, String sortBy, String filter);
    ProductDto getOneProduct(Long id);
    ProductDto addProduct(ProductDto productDto);
    ProductDto updateProduct(Product productFromDB, ProductDto productDto);
    void deleteProduct(Product product);
}
