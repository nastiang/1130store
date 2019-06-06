package ru.store.store1130.db.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.store.store1130.db.model.ProductCategory;

import java.util.Optional;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    Page<ProductCategory> findAll(Pageable pageable);
    Optional<ProductCategory> findById(Long id);
}
