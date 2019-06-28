package ru.store.store1130.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.db.model.ProductInOrder;
import ru.store.store1130.db.model.SalesOrder;
@Repository
public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long>{
    ProductInOrder findBySalesOrder(SalesOrder salesOrder);

}
