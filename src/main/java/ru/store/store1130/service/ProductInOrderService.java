package ru.store.store1130.service;

import ru.store.store1130.service.dto.ProductInOrderDto;

public interface ProductInOrderService {
    ProductInOrderDto saveOrUpdate(ProductInOrderDto productInOrdertDto);
    void delete(ProductInOrderDto productInOrderDto);
}
