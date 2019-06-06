package ru.store.store1130.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.db.repository.ProductRepository;
import ru.store.store1130.mapper.ProductMapper;
import ru.store.store1130.service.ProductService;
import ru.store.store1130.service.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Page<ProductDto> getAllProduct(Pageable p, String sortBy, String filter) {
        if (sortBy == null || sortBy.equals("")) {
            return getPageProductDtos(p, filter);
        } else {
            return getPageProductDtos(getPageRequest(sortBy), filter);
        }
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

    private Page<ProductDto> getPageProductDtos(Pageable p, String filter) {
        List<ProductDto> productDtos = new ArrayList<>();
        Page<Product> products = productRepository.findAll(p);

        for (Product product : products) {
            productDtos.add(productMapper.productCategoryToDto(product));
        }

        if (filter == null || filter.equals(""))
            return new PageImpl<>(productDtos);
        else {
            List<ProductDto> collectPage = null;
            switch (filter) {
                case "productCategory":
                    collectPage = productDtos
                            .stream()
                            .filter(productDto -> productDto.getProductCategory().getNameOfProductCategory().equals(filter))
                            .collect(Collectors.toList());
                    break;


                default:
                    break;
            }
            return new PageImpl<>(collectPage);
        }
    }

    private PageRequest getPageRequest(String sortBy) {
        Sort sort = Sort.by(Sort.Direction.ASC, sortBy);
        return PageRequest.of(0, 20, sort);
    }
}
