package ru.store.store1130.db.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.store.store1130.db.model.OrderCategory;
import ru.store.store1130.db.model.SalesOrder;
import ru.store.store1130.db.model.SalesOrderStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SalesOrderReposirory extends JpaRepository<SalesOrder, Long> {
    Page<SalesOrder> findAll(Pageable pageable);
    Optional<SalesOrder> findById(Long id);
    Page<SalesOrder> findByDate(Pageable pageable, LocalDateTime date);
    Page<SalesOrder> findByOrderCategory(Pageable pageable, OrderCategory orderCategory);
    Page<SalesOrder> findByStatus(Pageable pageable, SalesOrderStatus salesOrderStatus);
   // Page<SalesOrder> findByProductId(Pageable pageable, Long id);
}
