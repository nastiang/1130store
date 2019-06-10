package ru.store.store1130.db.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.store.store1130.db.model.SalesOrder;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface SalesOrderReposirory extends JpaRepository<SalesOrder, Long>, Pageable {
    SalesOrder findOne(Long id);
    SalesOrder delete(Long id);
    List<SalesOrder> findByDate(LocalDate date);
    List<SalesOrder> findByOrderCategory(Long id);
    List<SalesOrder> findByOrderStatus(Long id);
    List<SalesOrder> findByProduct(Long id);
    List<SalesOrder> findByProductCategory(Long id);
}
