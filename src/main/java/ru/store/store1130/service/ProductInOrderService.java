package ru.store.store1130.service;

import ru.store.store1130.service.dto.ProductInOrderDto;

public interface ProductInOrderService {
    void saveOrUpdate(ProductInOrderDto productInOrderDto);
    void delete(ProductInOrderDto productInOrderDto);
}
