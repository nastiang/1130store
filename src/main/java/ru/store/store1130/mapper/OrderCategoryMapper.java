package ru.store.store1130.mapper;

import org.mapstruct.Mapper;
import ru.store.store1130.db.model.OrderCategory;
import ru.store.store1130.service.dto.OrderCategoryDto;

@Mapper
public interface OrderCategoryMapper {
    OrderCategoryDto orderCategoryToDto(OrderCategory orderCategory);
    OrderCategory orderCategoryDtoToEntity(OrderCategoryDto orderCategoryDto);
}
