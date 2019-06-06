package ru.store.store1130.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.db.model.ProductCategory;
import ru.store.store1130.service.impl.ProductServiceImpl;
import ru.store.store1130.service.dto.ProductDto;

import java.util.List;


@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping
    public Page<ProductDto> getAllProduct(
            @PageableDefault(size = 20, sort = { "nameOfProduct" }, direction = Sort.Direction.ASC) Pageable p,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "filter", required = false)String filter,
            @RequestParam(value = "filterParam", required = false)String filterParam
    ) {
        return productService.getAllProduct(p, sortBy, filter, filterParam);
    }

    @GetMapping("{id}")
    public ProductDto getOneProduct(@PathVariable("id") Product product){
        return productService.getOneProduct(product.getId());
    }

    @PostMapping("add")
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }

    @PutMapping("{id}")
    public ProductDto updateProduct(@PathVariable("id") Product productFromDB, @RequestBody ProductDto productDto) {
        return productService.updateProduct(productFromDB, productDto);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Product product) {
        productService.deleteProduct(product);
    }

}
