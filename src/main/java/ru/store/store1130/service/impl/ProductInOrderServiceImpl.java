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
import ru.store.store1130.service.dto.SalesOrderDto;

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
    public void delete(ProductInOrderDto productInOrderDto, int value) {
        int resultValue = productInOrderDto.getQuantity() - value;
        if (resultValue > 0){
            productInOrderDto.setQuantity(resultValue);
            saveOrUpdate(productInOrderDto);
        }
        else productInOrderRepository.delete(converterDomainToDto.convertToDomain(productInOrderDto));
    }

    @Override
    public ProductInOrderDto findOne(SalesOrderDto salesOrderDto) {
        ProductInOrderDto productInOrderDto = converterDomainToDto.convertToDto
                (productInOrderRepository.findBySalesOrder(converterDomainToDto.convertToDomain(salesOrderDto)));
        return productInOrderDto;
    }
}
