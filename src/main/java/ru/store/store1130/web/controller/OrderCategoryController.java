package ru.store.store1130.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.store.store1130.db.model.OrderCategory;
import ru.store.store1130.mapper.OrderCategoryMapper;
import ru.store.store1130.service.OrderCategoryService;
import ru.store.store1130.service.dto.OrderCategoryDto;


import java.util.List;

@RestController
@RequestMapping("/order/category")
public class OrderCategoryController {
    private final OrderCategoryService orderCategoryService;

    @Autowired
    public OrderCategoryController(OrderCategoryService orderCategoryService) {
        this.orderCategoryService = orderCategoryService;
    }

    @GetMapping
    public List<OrderCategoryDto> getAllCategory() {
        return orderCategoryService.getAllCategory();
    }

    @GetMapping("{id}")
    public OrderCategoryDto getOneCategory(@PathVariable("id") OrderCategory orderCategory) {
        return orderCategoryService.findByIdCategory(orderCategory.getId());
    }

    @PostMapping("add")
    public OrderCategoryDto createOrderCategory(@RequestBody OrderCategoryDto orderCategoryDto) {
        return orderCategoryService.createCategory(orderCategoryDto);
    }

    @PutMapping("{id}")
    public OrderCategoryDto updateOrderCategory(
            @PathVariable("id") OrderCategory categoryFromDB, @RequestParam("nameOfCategory") String orderCategory
    ){
        return orderCategoryService.updateCategory(categoryFromDB, orderCategory);
    }

    @DeleteMapping("{id}")
    public void deleteOrderCategory(@PathVariable("id") OrderCategory orderCategory) {
        orderCategoryService.deleteCategory(orderCategory);
    }
}
