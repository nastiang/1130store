package ru.store.store1130.Converters;

import org.springframework.stereotype.Component;
import ru.store.store1130.db.model.*;
import ru.store.store1130.service.dto.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConverterDomainToDto {
    public SalesOrder convertToDomain(SalesOrderDto orderDto){
        SalesOrder order = new SalesOrder();
        order.setId(orderDto.getId());
        order.setDate(orderDto.getDate());
        order.setOrderCategory(orderDto.getOrderCategory());
        order.setProductList(orderDto.getProductList());
        order.setStatus(orderDto.getStatus());
        order.setSum(orderDto.getSum());
        order.setUser(orderDto.getUser());

        return order;
    }

    public SalesOrderDto convertToDto(SalesOrder order){
        SalesOrderDto orderDto = new SalesOrderDto();
        orderDto.setId(order.getId());
        orderDto.setDate(order.getDate());
        orderDto.setOrderCategory(order.getOrderCategory());
        orderDto.setProductList(order.getProductList());
        orderDto.setStatus(order.getStatus());
        orderDto.setSum(order.getSum());
        orderDto.setUser(order.getUser());

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

    public OrderStatus convertToDomain(OrderStatusDto orderStatusDto){
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setId(orderStatusDto.getId());
        orderStatus.setNameOfStatus(orderStatusDto.getNameOfStatus());

        return orderStatus;
    }

    public OrderStatusDto convertToDto(OrderStatus orderStatus){
        OrderStatusDto orderStatusDto = new OrderStatusDto();
        orderStatusDto.setId(orderStatus.getId());
        orderStatusDto.setNameOfStatus(orderStatus.getNameOfStatus());

        return orderStatusDto;
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
