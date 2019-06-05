package ru.store.store1130.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.db.repository.ProductRepository;
import ru.store.store1130.mapper.ProductMapper;
import ru.store.store1130.service.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService  {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDto> getAllProduct() {
        List<ProductDto> productDtos = new ArrayList<>();
        List<Product> products = productRepository.findAll();

        for (Product product : products) {
            productDtos.add(productMapper.productCategoryToDto(product));
        }

        return productDtos;
    }

    public ProductDto getOneProduct(Long id) {
        return productMapper.productCategoryToDto(productRepository.findById(id).get());
    }

    public ProductDto addProduct(ProductDto productDto) {
        Product product = productMapper.productCategoryDtoToEntity(productDto);
        Product save = productRepository.save(product);

        return productMapper.productCategoryToDto(save);
    }

    public ProductDto updateProduct(Product productFromDB, ProductDto productDto) {
        Long id = productFromDB.getId();
        BeanUtils.copyProperties(productDto, productFromDB);
        productFromDB.setId(id);

        Product save = productRepository.save(productFromDB);

        return productMapper.productCategoryToDto(save);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
