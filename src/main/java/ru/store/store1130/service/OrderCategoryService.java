package ru.store.store1130.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.store.store1130.db.model.OrderCategory;
import ru.store.store1130.db.repository.OrderCategoryRepository;
import ru.store.store1130.mapper.OrderCategoryMapper;
import ru.store.store1130.service.dto.OrderCategoryDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderCategoryService {

    @Autowired
    private OrderCategoryRepository orderCategoryRepository;

    @Autowired
    private OrderCategoryMapper orderCategoryMapper;


    public List<OrderCategoryDto> getAllCategory() {
        List<OrderCategory> orderCategories = orderCategoryRepository.findAll();
        List<OrderCategoryDto> orderCategoryDtos = new ArrayList<>();

        for (OrderCategory orderCategory : orderCategories) {
            orderCategoryDtos.add(orderCategoryMapper.orderCategoryToDto(orderCategory));
        }

        return orderCategoryDtos;
    }

    public OrderCategoryDto findByIdCategory(Long id) {
        return orderCategoryMapper.orderCategoryToDto(orderCategoryRepository.findById(id).get());
    }

    public OrderCategoryDto createCategory(OrderCategoryDto orderCategoryDto) {
        OrderCategory orderCategory = orderCategoryMapper.orderCategoryDtoToEntity(orderCategoryDto);
        OrderCategory save = orderCategoryRepository.save(orderCategory);

        return orderCategoryMapper.orderCategoryToDto(save);
    }

    public OrderCategoryDto updateCategory(OrderCategory categoryFromDB, String orderCategory) {
        categoryFromDB.setNameOfCategory(orderCategory);
        OrderCategory save = orderCategoryRepository.save(categoryFromDB);

        return orderCategoryMapper.orderCategoryToDto(save);
    }

    public void deleteCategory(OrderCategory orderCategory) {
        orderCategoryRepository.delete(orderCategory);
    }
}
