package ru.store.store1130.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.store.store1130.db.model.ProductCategory;
import ru.store.store1130.service.dto.ProductCategoryDto;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    /*@Query("select new ru.store.store1130.service.dto.ProductCategoryDto(p) from ProductCategory p")
    List<ProductCategoryDto> findAllProduct();

    @Query("select new ru.store.store1130.service.dto.ProductCategoryDto(p) from ProductCategory p where id=:id")
    ProductCategoryDto findByProductId(@Param("id") Long id);*/

    List<ProductCategory> findAll();
    Optional<ProductCategory> findById(Long id);
}
