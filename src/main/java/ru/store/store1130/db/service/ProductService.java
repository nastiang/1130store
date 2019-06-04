package ru.store.store1130.db.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.db.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService  {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Product getOneProduct(Long id) {
        return productRepository.findById(id).get();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product productFromDB, Product product) {
        Long id = productFromDB.getId();
        BeanUtils.copyProperties(product, productFromDB);
        productFromDB.setId(id);

        return productRepository.save(productFromDB);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
