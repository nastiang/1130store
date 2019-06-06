package ru.store.store1130.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.store.store1130.db.model.OrderCategory;
import ru.store.store1130.service.dto.OrderCategoryDto;

public interface OrderCategoryService {
    Page<OrderCategoryDto> getAllCategory(Pageable p);
    OrderCategoryDto findByIdCategory(Long id);
    OrderCategoryDto createCategory(OrderCategoryDto orderCategoryDto);
    OrderCategoryDto updateCategory(OrderCategory categoryFromDB, String orderCategory);
    void deleteCategory(OrderCategory orderCategory);
}
