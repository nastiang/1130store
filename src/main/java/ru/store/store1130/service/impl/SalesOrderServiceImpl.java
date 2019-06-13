package ru.store.store1130.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.store.store1130.db.model.OrderStatus;
import ru.store.store1130.db.model.SalesOrder;
import ru.store.store1130.db.repository.SalesOrderReposirory;
import ru.store.store1130.service.SalesOrderService;
import ru.store.store1130.service.dto.SalesOrderDto;
import ru.store.store1130.Converters.ConverterDomainToDto;

import java.time.LocalDate;
import java.util.List;

@Service
public class SalesOrderServiceImpl implements SalesOrderService {

    @Autowired
    SalesOrderReposirory salesOrderReposirory;
    @Autowired
    ConverterDomainToDto converterDomainToDto;

    @Override
    public Page<SalesOrderDto> getAllOrder(Pageable pageable, String sortBy, String filter, String filterParam) {
        return null;
    }

    @Override
    public SalesOrderDto getOne(Long id) {
        return converterDomainToDto.convertToDto(salesOrderReposirory.getOne(id));
    }

    @Override
    public void create(SalesOrderDto salesOrderDto) {
        salesOrderReposirory.save(converterDomainToDto.convertToDomain(salesOrderDto));
    }

    @Override
    public SalesOrderDto update(SalesOrderDto salesOrderDto, OrderStatus orderStatus) {
        SalesOrder salesOrder = converterDomainToDto.convertToDomain(salesOrderDto);

      return converterDomainToDto.convertToDto(salesOrderReposirory.save(salesOrder));
    }

    @Override
    public void delete(Long id) {
        SalesOrder salesOrder = salesOrderReposirory.findOne(id);
        if (salesOrder == null){
            return;
        }
        salesOrderReposirory.delete(id);
    }

    @Override
    public List<SalesOrderDto> findByOrderCategory(Long orderCategoryId) {
        return
        converterDomainToDto.convertToDto(salesOrderReposirory.findByOrderCategory(orderCategoryId));

    }

    @Override
    public List<SalesOrderDto> findByOrderStatus(Long orderStatusId) {
        return converterDomainToDto.convertToDto(salesOrderReposirory.findByOrderStatus(orderStatusId));
    }

    @Override
    public List<SalesOrderDto> findByProduct(Long productStatusId) {
        return converterDomainToDto.convertToDto(salesOrderReposirory.findByProduct(productStatusId));
    }

    @Override
    public List<SalesOrderDto> findByProductCategory(Long productCategoryId) {
        return converterDomainToDto.convertToDto(salesOrderReposirory.findByProductCategory(productCategoryId));
    }

    @Override
    public List<SalesOrderDto> findByDate(LocalDate date) {
        return converterDomainToDto.convertToDto(salesOrderReposirory.findByDate(date));
    }

}
