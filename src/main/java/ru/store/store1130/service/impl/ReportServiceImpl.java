package ru.store.store1130.service.impl;

import ru.store.store1130.Converters.ConverterDomainToDto;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.db.model.SalesOrder;
import ru.store.store1130.service.ReportService;
import ru.store.store1130.service.SalesOrderService;
import ru.store.store1130.service.dto.ProductReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private SalesOrderService salesOrderService;

    @Autowired
    private ConverterDomainToDto converter;

    @Override
    public Page<ProductReportDto> getAllProductReport(Pageable pageable) {
        Page<SalesOrder> allOrders = salesOrderService.findAll(pageable);
        List<ProductReportDto> allProductReports = new ArrayList<>();

        for (SalesOrder order : allOrders) {
            ProductReportDto dto = converter.convertToDomain(order);

            dto.setProfit(getProfit(dto.getSum(), dto.getProducts()));

            allProductReports.add(dto);
        }

        Page<ProductReportDto> pages = new PageImpl<>(allProductReports);

        /*return new ProductReportPagesDto(
                pages.getContent(),
                pageable.getPageNumber(),
                pages.getTotalPages()
        );*/
        return pages;
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
