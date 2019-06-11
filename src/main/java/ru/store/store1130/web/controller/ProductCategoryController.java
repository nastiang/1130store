package ru.store.store1130.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import ru.store.store1130.db.model.ProductCategory;
import ru.store.store1130.service.ProductCategoryService;
import ru.store.store1130.service.dto.ProductCategoryDto;

import java.util.List;

@RestController
@RequestMapping("product/category")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping
    public Page<ProductCategoryDto> getAllCategory(@PageableDefault(size = 20, sort = { "nameOfProductCategory" }, direction = Sort.Direction.DESC) Pageable p) {
        return productCategoryService.getAllCategory(p);
    }

    @GetMapping("{id}")
    public ProductCategoryDto getOneCategory(@PathVariable("id") ProductCategory productCategory) {
        return productCategoryService.findByIdCategory(productCategory.getId());
    }

    @PostMapping("add")
    public ProductCategoryDto createProductCategory(@RequestBody ProductCategoryDto productCategoryDto) {
        return productCategoryService.createCategory(productCategoryDto);
    }

    @PutMapping("{id}")
    public ProductCategoryDto updateProductCategory(
            @PathVariable("id") ProductCategory categoryFromDB, @RequestParam("nameOfProductCategory") String productCategory
    ){
        return productCategoryService.updateCategory(categoryFromDB, productCategory);
    }

    @DeleteMapping("{id}")
    public void deleteProductCategory(@PathVariable("id") ProductCategory productCategory) {
        productCategoryService.deleteCategory(productCategory);
    }
}
