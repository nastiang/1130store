package ru.store.store1130.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.store.store1130.db.model.ProductCategory;
import ru.store.store1130.service.ProductCategoryService;

import java.util.List;

@RestController
@RequestMapping("product/category")
public class ProductController {
    private final ProductCategoryService productCategoryService;

    @Autowired
    public ProductController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping
    public List<ProductCategory> getAllCategory() {
        return productCategoryService.findAllCategory();
    }

    @GetMapping("{id}")
    public ProductCategory getOneCategory(@PathVariable("id") ProductCategory productCategory) {
        return productCategoryService.findByIdCategory(productCategory.getId());
    }

    @PostMapping("add")
    public ProductCategory createProductCategory(@RequestBody ProductCategory productCategory) {
        return productCategoryService.createCategory(productCategory);
    }

    @PutMapping("{id}")
    public ProductCategory updateProductCategory(
            @PathVariable("id") ProductCategory categoryFromDB, @RequestParam("nameOfProductCategory") String productCategory
    ){
        return productCategoryService.updateCategory(categoryFromDB, productCategory);
    }

    @DeleteMapping("{id}")
    public void deleteProductCategory(@PathVariable("id") ProductCategory productCategory) {
        productCategoryService.deleteCategory(productCategory);
    }
}
