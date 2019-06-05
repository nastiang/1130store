package ru.store.store1130.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.store.store1130.db.model.ProductCategory;
import ru.store.store1130.db.repository.ProductCategoryRepository;
import ru.store.store1130.mapper.ProductCategoryMapper;
import ru.store.store1130.service.dto.ProductCategoryDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public List<ProductCategoryDto> getAllCategory() {
        List<ProductCategoryDto> productCategoryDtos = new ArrayList<>();
        List<ProductCategory> productCategories = productCategoryRepository.findAll();

        for (ProductCategory productCategory : productCategories) {
            productCategoryDtos.add(productCategoryMapper.productCategoryToDto(productCategory));
        }

        return productCategoryDtos;
    }

    public ProductCategoryDto createCategory(ProductCategoryDto productCategoryDto) {
        ProductCategory productCategory = productCategoryMapper.productCategoryDtoToEntity(productCategoryDto);
        ProductCategory save = productCategoryRepository.save(productCategory);

        return productCategoryMapper.productCategoryToDto(save);
    }

    public ProductCategoryDto updateCategory(ProductCategory categoryFromDB, String productCategory) {
        categoryFromDB.setNameOfProductCategory(productCategory);
        ProductCategory save = productCategoryRepository.save(categoryFromDB);

        return productCategoryMapper.productCategoryToDto(save);
    }

    public void deleteCategory(ProductCategory productCategory) {
        productCategoryRepository.delete(productCategory);
    }

    public ProductCategoryDto findByIdCategory(Long id) {
        return productCategoryMapper.productCategoryToDto(productCategoryRepository.findById(id).get());
    }
}
