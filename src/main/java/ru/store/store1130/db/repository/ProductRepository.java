package ru.store.store1130.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.store.store1130.db.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();
    Optional<Product> findById(Long id);
}
