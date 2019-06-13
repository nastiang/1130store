package ru.store.store1130.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.store.store1130.db.model.OrderStatus;
import ru.store.store1130.db.model.SalesOrder;
import ru.store.store1130.service.dto.SalesOrderDto;

import java.time.LocalDate;
import java.util.List;

public interface SalesOrderService {
    Page<SalesOrderDto> getAllOrder(Pageable pageable, String sortBy, String filter, String filterParam);
    SalesOrderDto getOne(Long id);
    void create(SalesOrderDto salesOrderDto);
    SalesOrderDto update(SalesOrderDto salesOrderDto, OrderStatus orderStatus);
    void delete(Long id);
    List<SalesOrderDto> findByOrderCategory(Long orderCategoryId);
    List<SalesOrderDto> findByOrderStatus(Long orderStatusId);
    List<SalesOrderDto> findByProduct(Long productStatusId);
    List<SalesOrderDto> findByProductCategory(Long productCategoryId);
    List<SalesOrderDto> findByDate(LocalDate date);
    SalesOrderDto addToBucket(SalesOrderDto salesOrderDto, Long productId, int value);
    SalesOrderDto deleteFromBucket(SalesOrderDto salesOrderDto, Long productId);

}
