package ru.store.store1130.db.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.store.store1130.db.model.Product;

@Repository
public interface ReportProductRepository extends PagingAndSortingRepository<Product, Long> {

    @Query(value = "SELECT p FROM Product p JOIN p.productCategory c ORDER BY c.nameOfProductCategory, p.nameOfProduct")
    Page<Product> findAll(Pageable pageable);
}
