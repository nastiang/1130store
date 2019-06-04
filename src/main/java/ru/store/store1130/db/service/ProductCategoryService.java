package ru.store.store1130.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.store.store1130.db.model.ProductCategory;
import ru.store.store1130.db.repository.ProductCategoryRepository;

import java.util.List;

@Service
public class ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public List<ProductCategory> findAllCategory() {
        return productCategoryRepository.findAll();
    }

    public ProductCategory createCategory(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    public ProductCategory updateCategory(ProductCategory categoryFromDB, String productCategory) {
        categoryFromDB.setNameOfProductCategory(productCategory);

        return productCategoryRepository.save(categoryFromDB);
    }

    public void deleteCategory(ProductCategory productCategory) {
        productCategoryRepository.delete(productCategory);
    }

    public ProductCategory findByIdCategory(Long id) {
        return productCategoryRepository.findById(id).get();
    }
}
