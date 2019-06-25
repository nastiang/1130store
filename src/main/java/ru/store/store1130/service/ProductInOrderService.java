package ru.store.store1130.service;

import ru.store.store1130.db.model.ProductInOrder;
import ru.store.store1130.service.dto.ProductInOrderDto;
import ru.store.store1130.service.dto.SalesOrderDto;

public interface ProductInOrderService {
    void saveOrUpdate(ProductInOrderDto productInOrderDto);
    void delete(ProductInOrderDto productInOrderDto, int value);
    ProductInOrderDto findOne(SalesOrderDto salesOrderDto);
}
