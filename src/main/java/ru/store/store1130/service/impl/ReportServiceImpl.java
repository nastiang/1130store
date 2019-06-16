package ru.store.store1130.service.impl;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicateBuilder;
import org.springframework.stereotype.Service;
import ru.store.store1130.db.model.SalesOrder;
import ru.store.store1130.db.model.Views;
import ru.store.store1130.service.ReportService;
import ru.store.store1130.service.SalesOrderService;
import ru.store.store1130.service.dto.ProductReportDto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
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

        for (SalesOrder order : allOrders) {
            ProductReportDto dto = new ProductReportDto();
            dto.setData(order.getDate());
            dto.setUser(order.getUser());
            dto.setProducts(order.getProducts());
            dto.setSum(order.getSum());
            dto.setProfit(new BigDecimal(123));

            allProductReports.add(dto);
        }

        return allProductReports;
    }
}
