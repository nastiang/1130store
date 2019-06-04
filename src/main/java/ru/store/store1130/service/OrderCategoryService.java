package ru.store.store1130.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.store.store1130.db.model.OrderCategory;
import ru.store.store1130.db.repository.OrderCategoryRepository;

import java.util.List;

@Service
public class OrderCategoryService {

    @Autowired
    private OrderCategoryRepository orderCategoryRepository;


    public List<OrderCategory> findAllCategory() {
        return orderCategoryRepository.findAll();
    }

    public OrderCategory findByIdCategory(Long id) {
        return orderCategoryRepository.findById(id).get();
    }

    public OrderCategory createCategory(OrderCategory orderCategory) {
        return orderCategoryRepository.save(orderCategory);
    }

    public OrderCategory updateCategory(OrderCategory categoryFromDB, String orderCategory) {
        categoryFromDB.setNameOfCategory(orderCategory);
        return orderCategoryRepository.save(categoryFromDB);
    }

    public void deleteCategory(OrderCategory orderCategory) {
        orderCategoryRepository.delete(orderCategory);
    }
}
