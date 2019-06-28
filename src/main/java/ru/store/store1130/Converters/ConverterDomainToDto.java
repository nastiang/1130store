package ru.store.store1130.Converters;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;
import ru.store.store1130.db.model.*;
import ru.store.store1130.service.dto.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class ConverterDomainToDto {
    public ProductReportDto convertToDomain(SalesOrder salesOrder) {
        ProductReportDto dto = new ProductReportDto();
        dto.setDate(salesOrder.getDate());
        dto.setUser(salesOrder.getUser());
        dto.setProducts(salesOrder.getProducts());
        dto.setOrderType(salesOrder.getOrderType().getText());

        return dto;
    }

    public SalesOrder convertToDomain(SalesOrderDto orderDto){
        SalesOrder order = new SalesOrder();
        order.setId(orderDto.getId());
        order.setDate(orderDto.getDate());
        order.setOrderCategory(orderDto.getOrderCategory());
        order.setProducts(orderDto.getProductList());
        order.setStatus(orderDto.getStatus());
        order.setSum(orderDto.getSum());
        order.setUser(orderDto.getUser());
        order.setOrderType(orderDto.getOrderType());
        return order;
    }

    public SalesOrderDto convertToDto(SalesOrder order){
        SalesOrderDto orderDto = new SalesOrderDto();
        orderDto.setId(order.getId());
        orderDto.setDate(order.getDate());
        orderDto.setOrderCategory(order.getOrderCategory());
        orderDto.setProductList(order.getProducts());
        orderDto.setStatus(order.getStatus());
        orderDto.setSum(order.getSum());
        orderDto.setUser(order.getUser());
        orderDto.setOrderType(order.getOrderType());
        return  orderDto;
    }

    public List<SalesOrder> convertToDomain(List<SalesOrderDto> orderDtos){
        List<SalesOrder> orderList = new ArrayList<>();
        ConverterDomainToDto converterDomainToDto = new ConverterDomainToDto();
        for (SalesOrderDto orderDto1 : orderDtos){
            orderList.add(converterDomainToDto.convertToDomain(orderDto1));
        }
        return orderList;
    }

    public List<SalesOrderDto> convertToDto(List<SalesOrder> orders){
       List<SalesOrderDto> orderDtoList = new ArrayList<>();
       ConverterDomainToDto converterDomainToDto = new ConverterDomainToDto();
        for (SalesOrder order1 : orders){
            orderDtoList.add(converterDomainToDto.convertToDto(order1));
        }
        return orderDtoList;
    }

    public LinkedHashMap<Long,Integer> convertToDomain(LinkedHashMap<Long,Integer> salesOrderDtoLinkedHashMap) {
        LinkedHashMap<Long, Integer> domainLinkedHashMap = (LinkedHashMap)salesOrderDtoLinkedHashMap.clone();
        return domainLinkedHashMap;
    }

    public LinkedHashMap<Long,Integer> convertToDto(LinkedHashMap<Long,Integer> salesOrderLinkedHashMap) {
        LinkedHashMap<Long, Integer> dtoLinkedHashMap = (LinkedHashMap)salesOrderLinkedHashMap.clone();
        return dtoLinkedHashMap;
    }

    public OrderCategory convertToDomain(OrderCategoryDto orderCategoryDto){
        OrderCategory orderCategory = new OrderCategory();
        orderCategory.setId(orderCategoryDto.getId());
        orderCategory.setNameOfCategory(orderCategoryDto.getNameOfCategory());

        return orderCategory;
    }

    public OrderCategoryDto convertToDto(OrderCategory orderCategory){
        OrderCategoryDto orderCategoryDto = new OrderCategoryDto();
        orderCategoryDto.setId(orderCategory.getId());
        orderCategoryDto.setNameOfCategory(orderCategory.getNameOfCategory());
        return orderCategoryDto;
    }

    public ProductInOrderDto convertToDto(ProductInOrder productInOrder){
        ProductInOrderDto productInOrderDto = new ProductInOrderDto();
        productInOrderDto.setId(productInOrder.getId());
        productInOrderDto.setProduct(productInOrder.getProduct());
        productInOrderDto.setSalesOrder(productInOrder.getSalesOrder());
        return productInOrderDto;
    }

    public ProductInOrder convertToDomain(ProductInOrderDto productInOrderDto){
        ProductInOrder productInOrder = new ProductInOrder();
        productInOrder.setId(productInOrderDto.getId());
        productInOrder.setProduct(productInOrderDto.getProduct());
        productInOrder.setSalesOrder(productInOrderDto.getSalesOrder());
        return productInOrder;
    }

    public Product convertToDomain(ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setNameOfProduct(productDto.getNameOfProduct());
        product.setPrice(productDto.getPrice());
        product.setCost(productDto.getCost());
        product.setProductCategory(productDto.getProductCategory());

        return product;
    }

    public ProductDto convertToDto(Product product){
        ProductDto productDto  = new ProductDto();
        productDto.setId(product.getId());
        productDto.setNameOfProduct(product.getNameOfProduct());
        productDto.setPrice(product.getPrice());
        productDto.setCost(product.getCost());
        productDto.setProductCategory(product.getProductCategory());

        return productDto;
    }

    public Page<ProductDto> convertToDto(Page<Product> products){
        List<ProductDto> productDtoList = new ArrayList<>();
        ConverterDomainToDto converterDomainToDto = new ConverterDomainToDto();
        for (Product product1 : products){
            productDtoList.add(converterDomainToDto.convertToDto(product1));
        }
        return new PageImpl<>(productDtoList);
    }

    public ProductCategory convertToDomain(ProductCategoryDto productCategoryDto){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(productCategoryDto.getId());
        productCategory.setNameOfProductCategory(productCategoryDto.getNameOfProductCategory());

        return productCategory;
    }

    public ProductCategoryDto convertToDto(ProductCategory productCategory){
        ProductCategoryDto productCategoryDto = new ProductCategoryDto();
        productCategoryDto.setId(productCategory.getId());
        productCategoryDto.setNameOfProductCategory(productCategory.getNameOfProductCategory());

        return productCategoryDto;
    }

    public User convertToDomain(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());

        return user;
    }

    public UserDto convertToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());

        return userDto;
    }

    public UserRole convertToDomain(UserRoleDto userRoleDto){
        UserRole userRole = new UserRole();
        userRole.setId(userRoleDto.getId());
        userRole.setNameOfRole(userRoleDto.getNameOfRole());

        return userRole;
    }

    public UserRoleDto convertToDto(UserRole userRole){
        UserRoleDto userRoleDto = new UserRoleDto();
        userRoleDto.setId(userRole.getId());
        userRoleDto.setNameOfRole(userRole.getNameOfRole());

        return userRoleDto;
    }

}
