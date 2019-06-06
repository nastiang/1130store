package ru.store.store1130.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.service.ProductService;
import ru.store.store1130.service.dto.ProductDto;

import java.util.List;


@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProduct() {
        return productService.getAllProduct();
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
