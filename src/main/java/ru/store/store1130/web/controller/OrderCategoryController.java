package ru.store.store1130.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import ru.store.store1130.db.model.OrderCategory;
import ru.store.store1130.service.OrderCategoryService;
import ru.store.store1130.service.dto.OrderCategoryDto;

@RestController
@RequestMapping("/order/category")
public class OrderCategoryController {
    @Autowired
    OrderCategoryService orderCategoryService;

    @GetMapping
    public Page<OrderCategoryDto> getAllCategory(
            @PageableDefault(size = 20, sort = { "nameOfCategory" }, direction = Sort.Direction.DESC) Pageable p
    ) {
        return orderCategoryService.getAllCategory(p);
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
