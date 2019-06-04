package ru.store.store1130.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.store.store1130.db.model.OrderCategory;
import ru.store.store1130.db.model.ProductCategory;
import ru.store.store1130.db.service.OrderCategoryService;

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
    public List<OrderCategory> getAllCategory() {
        return orderCategoryService.findAllCategory();
    }

    @GetMapping("{id}")
    public OrderCategory getOneCategory(@PathVariable("id") OrderCategory orderCategory) {
        return orderCategoryService.findByIdCategory(orderCategory.getId());
    }

    @PostMapping("add")
    public OrderCategory createOrderCategory(@RequestBody OrderCategory orderCategory) {
        return orderCategoryService.createCategory(orderCategory);
    }

    @PutMapping("{id}")
    public OrderCategory updateOrderCategory(
            @PathVariable("id") OrderCategory categoryFromDB, @RequestParam("nameOfCategory") String orderCategory
    ){
        return orderCategoryService.updateCategory(categoryFromDB, orderCategory);
    }

    @DeleteMapping("{id}")
    public void deleteOrderCategory(@PathVariable("id") OrderCategory orderCategory) {
        orderCategoryService.deleteCategory(orderCategory);
    }
}
