package ru.store.store1130.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.db.model.ProductInOrder;
import ru.store.store1130.db.model.SalesOrder;
import ru.store.store1130.db.repository.ProductInOrderRepository;
import ru.store.store1130.db.repository.ProductRepository;
import ru.store.store1130.db.repository.SalesOrderReposirory;
import ru.store.store1130.service.ProductInOrderService;
import ru.store.store1130.service.dto.ProductInOrderDto;
import ru.store.store1130.Converters.ConverterDomainToDto;

@Service
public class ProductInOrderServiceImpl implements ProductInOrderService {
    @Autowired
    ProductInOrderRepository productInOrderRepository;
    @Autowired
    ConverterDomainToDto converterDomainToDto;

    @Override
    public void saveOrUpdate(ProductInOrderDto productInOrderDto) {
        productInOrderRepository.save(converterDomainToDto.convertToDomain(productInOrderDto));
    }

    @Override
    public void delete(ProductInOrderDto productInOrderDto) {

    }
}
