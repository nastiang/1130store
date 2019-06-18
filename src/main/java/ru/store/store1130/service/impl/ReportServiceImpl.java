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
import ru.store.store1130.service.dto.ProductReportPagesDto;

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
    public ProductReportPagesDto getAllProductReport(Pageable pageable) {
        Page<SalesOrder> allOrders = salesOrderService.findAll(pageable);
        List<ProductReportDto> allProductReports = new ArrayList<>();

        for (SalesOrder order : allOrders) {
            ProductReportDto dto = converter.convertToDomain(order);

            dto.setOrderType(order.getOrderType().getText());
            dto.setSum(getSum(dto.getOrderType(), order.getProducts()));
            dto.setProfit(getProfit(dto.getOrderType(), dto.getSum(), dto.getProducts()));

            allProductReports.add(dto);
        }


        Page<ProductReportDto> pages = new PageImpl<>(allProductReports);

        return new ProductReportPagesDto(
                pages.getContent(),
                pageable.getPageNumber(),
                pages.getTotalPages(),
                fillTotalSum(allProductReports),
                fillTotalProfit(allProductReports)
        );
    }

    private BigDecimal fillTotalProfit(List<ProductReportDto> allProductReports) {
        BigDecimal totalProfit = BigDecimal.ZERO;

        for (ProductReportDto productReport : allProductReports) {
            totalProfit = totalProfit.add(productReport.getProfit());
        }

        return totalProfit;
    }

    private BigDecimal fillTotalSum(List<ProductReportDto> allProductReports) {
        BigDecimal totalSum = BigDecimal.ZERO;

        for (ProductReportDto productReport : allProductReports) {
            totalSum = totalSum.add(productReport.getSum());
        }

        return totalSum;
    }

    private BigDecimal getSum(String orderType, List<Product> products) {
        BigDecimal sum = BigDecimal.ZERO;

        for (Product product : products) {
            if (orderType.equals("покупка"))
                sum = sum.add(product.getPrice());
            else
                sum = sum.subtract(product.getPrice());
        }

        return sum;
    }

    private BigDecimal getProfit(String orderType, BigDecimal sum, List<Product> products) {
        BigDecimal profit = BigDecimal.ZERO;
        for (Product product : products) {
            if (orderType.equals("покупка"))
                profit = profit.add(product.getCost());
            else
                profit = profit.subtract(product.getCost());
        }

        profit = sum.subtract(profit);

        return profit;
    }
}
