package ru.store.store1130.db.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.db.model.Views;
import ru.store.store1130.db.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("{id}")
    public Product getOneProduct(@PathVariable("id") Product product){
        return productService.getOneProduct(product.getId());
    }

    @PostMapping("add")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("{id}")
    public Product updateProduct(@PathVariable("id") Product productFromDB, @RequestBody Product product) {
        return productService.updateProduct(productFromDB, product);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Product product) {
        productService.deleteProduct(product);
    }
}
