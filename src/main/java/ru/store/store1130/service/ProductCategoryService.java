package ru.store.store1130.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.store.store1130.db.model.ProductCategory;
import ru.store.store1130.service.dto.ProductCategoryDto;



public interface ProductCategoryService {
    Page<ProductCategoryDto> getAllCategory(Pageable p);
    ProductCategoryDto createCategory(ProductCategoryDto productCategoryDto);
    ProductCategoryDto updateCategory(ProductCategory categoryFromDB, String productCategory);
    void deleteCategory(ProductCategory productCategory);
    ProductCategoryDto findByIdCategory(Long id);
}
