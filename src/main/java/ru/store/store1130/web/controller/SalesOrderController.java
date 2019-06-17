package ru.store.store1130.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.store.store1130.db.model.SalesOrder;
import ru.store.store1130.db.model.SalesOrderStatus;
import ru.store.store1130.service.dto.SalesOrderDto;
import ru.store.store1130.service.impl.SalesOrderServiceImpl;

@RestController
@RequestMapping("order")
public class SalesOrderController {
    @Autowired
    SalesOrderServiceImpl salesOrderService;

    @GetMapping("{id}")
    public SalesOrderDto getOneSalesOrder(@PathVariable("id")SalesOrder salesOrder){
        return salesOrderService.getOne(salesOrder.getId());
    }

    @PutMapping("{id}")
    public SalesOrderDto updateSalesOrder(@PathVariable("id") @RequestBody SalesOrderDto salesOrderDto, SalesOrderStatus status){
        return salesOrderService.update(salesOrderDto, status);
    }



}
