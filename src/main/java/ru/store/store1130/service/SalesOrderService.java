package ru.store.store1130.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.store.store1130.db.model.OrderCategory;
import ru.store.store1130.db.model.SalesOrder;
import ru.store.store1130.db.model.SalesOrderStatus;
import ru.store.store1130.service.dto.SalesOrderDto;

import java.time.LocalDateTime;
import java.util.List;

public interface SalesOrderService {
    Page<SalesOrderDto> getAllOrder(Pageable pageable, String sortBy, String filter, String filterParam);
    SalesOrderDto getOne(Long id);
    void create(SalesOrderDto salesOrderDto);
    SalesOrderDto update(SalesOrderDto salesOrderDto);
    void delete(Long id);
    Page<SalesOrderDto> findByOrderCategory(Pageable pageable, OrderCategory OrderCategory);
    Page<SalesOrderDto> findByStatus(Pageable pageable, SalesOrderStatus salesOrderStatus);
   // Page<SalesOrderDto> findByProductId(Pageable pageable, Long productId);
    Page<SalesOrderDto> findByDate(Pageable pageable, LocalDateTime date);
    SalesOrderDto addToBucket(SalesOrderDto salesOrderDto, Long productId, int value);
    SalesOrderDto deleteFromBucket(SalesOrderDto salesOrderDto, Long productId);

    Page<SalesOrder> findAll(Pageable pageable);

}
