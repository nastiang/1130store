package ru.store.store1130.mapper.impl;

import org.springframework.stereotype.Component;
import ru.store.store1130.db.model.OrderCategory;
import ru.store.store1130.db.model.ProductCategory;
import ru.store.store1130.mapper.OrderCategoryMapper;
import ru.store.store1130.mapper.ProductCategoryMapper;
import ru.store.store1130.service.dto.OrderCategoryDto;
import ru.store.store1130.service.dto.ProductCategoryDto;

@Component
public class OrderCategoryMapperImpl implements OrderCategoryMapper {

    @Override
    public OrderCategoryDto orderCategoryToDto(OrderCategory orderCategory) {
        OrderCategoryDto orderCategoryDto = new OrderCategoryDto();

        orderCategoryDto.setId(orderCategory.getId());
        orderCategoryDto.setNameOfCategory(orderCategory.getNameOfCategory());

        return orderCategoryDto;
    }

    @Override
    public OrderCategory orderCategoryDtoToEntity(OrderCategoryDto orderCategoryDto) {
        OrderCategory orderCategory = new OrderCategory();

        orderCategory.setId(orderCategoryDto.getId());
        orderCategory.setNameOfCategory(orderCategoryDto.getNameOfCategory());

        return orderCategory;
    }
}
