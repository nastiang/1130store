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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Page<ProductDto> getAllProduct(Pageable p, String sortBy, String filter, String filterParam) {
        if (sortBy == null || sortBy.equals("")) {
            return getPageProductDtos(p, filter, filterParam);
        } else {
            return getPageProductDtos(getPageRequest(sortBy), filter, filterParam);
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

    private Page<ProductDto> getPageProductDtos(Pageable p, String  filter, String filterParam) {
        List<ProductDto> productDtos = new ArrayList<>();
        Page<Product> products = productRepository.findAll(p);

        if (filter == null) {
            for (Product product : products) {
                productDtos.add(productMapper.productCategoryToDto(product));
            }

            return new PageImpl<>(productDtos);
        } else {
            List<Product> collect = null;

            switch (filter) {
                case "productCategory":
                    //Фильтр по категориям продуктов
                    collect = products
                        .getContent()
                        .stream()
                        .filter(item -> item.getProductCategory().getNameOfProductCategory().equals(filterParam))
                        .collect(Collectors.toList());
                    break;

                case "price":
                case "cost":
                    //Фильтр по цене или себестоимости
                    collect = getProductsByCostOrPriceFilter(filter, filterParam, products, collect);
                    break;

            }

            for (Product product : collect) {
                productDtos.add(productMapper.productCategoryToDto(product));
            }
            return new PageImpl<>(productDtos);
        }
    }

    //Получение фильтрованной(по price или cost) List<Product> collect
    private List<Product> getProductsByCostOrPriceFilter(String filter, String filterParam, Page<Product> products, List<Product> collect) {
        String action = filterParam.replaceAll("\\d+", "");
        String substring = filterParam.substring(action.length());
        BigDecimal number = new BigDecimal(substring);

        switch (action) {
            case ">":
                collect = products.getContent().stream()
                        .filter(item -> {
                            if (filter.equals("cost")) {
                                return item.getCost().compareTo(number) == 1;
                            } else {
                                return item.getPrice().compareTo(number) == 1;
                            }
                        })
                        .collect(Collectors.toList());

                break;

            case "<":
                collect = products.getContent().stream()
                        .filter(item -> {
                            if (filter.equals("cost")) {
                                return item.getCost().compareTo(number) == -1;
                            } else {
                                return item.getPrice().compareTo(number) == -1;
                            }
                        }).collect(Collectors.toList());

                break;

            case "=":
                collect = products.getContent().stream()
                        .filter(item -> {
                            if (filter.equals("cost")) {
                                return item.getCost().compareTo(number) == 0;
                            } else {
                                return item.getPrice().compareTo(number) == 0;
                            }
                        }).collect(Collectors.toList());

                break;
        }
        return collect;
    }

    //Сортировка по параметру из RequestParam
    private PageRequest getPageRequest(String sortBy) {
        Sort sort = Sort.by(Sort.Direction.ASC, sortBy);
        return PageRequest.of(0, 20, sort);
    }
}
