package ru.store.store1130.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicateBuilder;
import org.springframework.stereotype.Service;
import ru.store.store1130.db.model.SalesOrder;
import ru.store.store1130.service.ReportService;
import ru.store.store1130.service.SalesOrderService;
import ru.store.store1130.service.dto.ProductReportDto;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private SalesOrderService salesOrderService;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<ProductReportDto> getAllProductReport() {
        List<SalesOrder> allOrders = salesOrderService.findAll();
        List<ProductReportDto> allProductReports = new ArrayList<>();

        QuerydslPredicateBuilder query = new QuerydslPredicateBuilder();

        for (SalesOrder order : allOrders) {
        }

        return null;
    }
}
