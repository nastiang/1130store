package ru.store.store1130.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.store.store1130.db.model.OrderCategory;
import ru.store.store1130.db.model.SalesOrderStatus;
import ru.store.store1130.service.dto.SalesOrderDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface SalesOrderService {
    Page<SalesOrderDto> getAllOrder(Pageable pageable, String sortBy, String filter, String filterParam);
    SalesOrderDto getOne(Long id);
    void create(SalesOrderDto salesOrderDto);
    SalesOrderDto update(SalesOrderDto salesOrderDto, SalesOrderStatus salesOrderStatus);
    void delete(Long id);
    Page<SalesOrderDto> findByOrderCategory(Pageable pageable, OrderCategory OrderCategory);
    Page<SalesOrderDto> findByStatus(Pageable pageable, SalesOrderStatus salesOrderStatus);
    Page<SalesOrderDto> findByProduct(Long productStatusId);
    Page<SalesOrderDto> findByProductCategory(Long productCategoryId);
    Page<SalesOrderDto> findByDate(Pageable pageable, LocalDateTime date);
    SalesOrderDto addToBucket(SalesOrderDto salesOrderDto, Long productId, int value);
    SalesOrderDto deleteFromBucket(SalesOrderDto salesOrderDto, Long productId);

}
