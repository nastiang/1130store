package ru.store.store1130.db.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.store.store1130.db.model.OrderCategory;

import java.util.List;
import java.util.Optional;

public interface OrderCategoryRepository extends JpaRepository<OrderCategory, Long>{
    Page<OrderCategory> findAll(Pageable pageable);
    Optional<OrderCategory> findById(Long id);
}
