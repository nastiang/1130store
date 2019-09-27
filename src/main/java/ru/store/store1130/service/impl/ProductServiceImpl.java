package ru.store.store1130.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import ru.store.store1130.Converters.ConverterDomainToDto;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.db.repository.ProductRepository;
import ru.store.store1130.mapper.ProductMapper;
import ru.store.store1130.service.ProductService;
import ru.store.store1130.service.dto.ProductDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired ProductRepository productRepository;
    @Autowired ProductMapper productMapper;
    @Autowired
    ConverterDomainToDto converterDomainToDto;

    public Page<ProductDto> getAllProduct(Pageable p, String sortBy, String filter, String filterParam) {
        return null;  // по ходу и тут все эти поля на вход лишние
    }

    public ProductDto getOneProduct(Long id) {
        return productMapper.productCategoryToDto(productRepository.findById(id).get());
    }

    public ProductDto addProduct(ProductDto productDto) {
        Product product = productMapper.productCategoryDtoToEntity(productDto);
        Product save = productRepository.save(product);

        return productMapper.productCategoryToDto(save);
    }

    public ProductDto updateProduct(Product productFromDB, ProductDto productDto) {  //не понимаю зачем брать сразу домен и дто?
        Long id = productFromDB.getId();  //дичь
        BeanUtils.copyProperties(productDto, productFromDB);
        productFromDB.setId(id);

        Product save = productRepository.save(productFromDB);

        return productMapper.productCategoryToDto(save);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }


    public Page<ProductDto> getProductDtoByCategory(Pageable pageable){
        Page<Product> productList = productRepository.findByProductCategory(pageable);
        return converterDomainToDto.convertToDto(productList);
    }
}
