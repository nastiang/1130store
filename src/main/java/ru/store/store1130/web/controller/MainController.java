package ru.store.store1130.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.store.store1130.service.impl.OrderCategoryServiceImpl;
import ru.store.store1130.service.impl.ProductCategoryServiceImpl;


@Controller
@RequestMapping("/")
public class MainController {
    private final ProductCategoryServiceImpl productCategoryService;
    private final OrderCategoryServiceImpl orderCategoryService;

    @Autowired
    public MainController(ProductCategoryServiceImpl productCategoryService, OrderCategoryServiceImpl orderCategoryService) {
        this.productCategoryService = productCategoryService;
        this.orderCategoryService = orderCategoryService;
    }

    @GetMapping
    public String main(Model model) {
        /*model.addAttribute("allProductCategory", productCategoryService.getAllCategory());
        model.addAttribute("allOrderCategory", orderCategoryService.getAllCategory());*/

        return "index";
    }
}
