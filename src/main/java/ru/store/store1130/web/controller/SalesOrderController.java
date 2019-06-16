package ru.store.store1130.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.store.store1130.service.impl.SalesOrderServiceImpl;

@RestController
@RequestMapping("order")
public class SalesOrderController {
    @Autowired
    SalesOrderServiceImpl salesOrderService;


}
