/*package ru.store.store1130.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.store.store1130.Converters.ConverterDomainToDto;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.db.model.SalesOrder;
import ru.store.store1130.service.ReportService;
import ru.store.store1130.service.SalesOrderService;
import ru.store.store1130.service.dto.ProductReportDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private SalesOrderServiceImpl salesOrderService;

    @Autowired
    private ConverterDomainToDto converter;

    @Override
    public Page<ProductReportDto> getAllProductReport(Pageable pageable) {
        Page<SalesOrder> allOrders = salesOrderService.findAll(pageable);
        List<ProductReportDto> allProductReports = new ArrayList<>();

        for (SalesOrder order : allOrders.getContent()) {
            ProductReportDto dto = converter.convertToDomain(order);

            dto.setProfit(getProfit(dto.getSum(), dto.getProducts()));

            allProductReports.add(dto);
        }

        return new PageImpl<>(allProductReports);
    }

    private BigDecimal getProfit(BigDecimal sum, List<Product> products) {
        BigDecimal profit = BigDecimal.ZERO;
        for (Product product : products) {
            profit = profit.add(product.getCost());
        }

        profit = sum.subtract(profit);

        return profit;
    }
}
*/