package ru.store.store1130.service.impl;

import com.itextpdf.text.DocumentException;
import ru.store.store1130.Converters.ConverterDomainToDto;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.db.model.SalesOrder;
import ru.store.store1130.db.model.User;
import ru.store.store1130.service.ReportService;
import ru.store.store1130.service.SalesOrderService;
import ru.store.store1130.service.dto.ProductReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.store.store1130.service.dto.ProductReportPagesDto;
import ru.store.store1130.utils.CreatePDF;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private SalesOrderService salesOrderService;

    @Autowired
    private ConverterDomainToDto converter;

    private ProductReportPagesDto productReportPagesDto;

    @Override
    public ProductReportPagesDto getAllProductReport(Pageable pageable, User user) {
        Page<SalesOrder> allOrders = salesOrderService.findAll(pageable);
        List<ProductReportDto> allProductReports = new ArrayList<>();

        for (SalesOrder order : allOrders) {
            ProductReportDto dto = converter.convertToDomain(order);

            dto.setSum(getSum(dto.getOrderType(), order.getProducts()));
            dto.setProfit(getProfit(dto.getOrderType(), dto.getSum(), dto.getProducts()));

            allProductReports.add(dto);
        }


        Page<ProductReportDto> pages = new PageImpl<>(allProductReports);

        productReportPagesDto = new ProductReportPagesDto(
                pages.getContent(),
                pageable.getPageNumber(),
                pages.getTotalPages(),
                fillTotalSum(allProductReports),
                fillTotalProfit(allProductReports)
        );

        return productReportPagesDto;
    }

    @Override
    public void downloadPDF() throws DocumentException, IOException, URISyntaxException {
        CreatePDF.getPDF(productReportPagesDto);
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
            if (orderType.equalsIgnoreCase("покупка"))
                sum = sum.add(product.getPrice());
            else
                sum = sum.subtract(product.getPrice());
        }

        return sum;
    }

    private BigDecimal getProfit(String orderType, BigDecimal sum, List<Product> products) {
        BigDecimal profit = BigDecimal.ZERO;
        for (Product product : products) {
            if (orderType.equalsIgnoreCase("покупка"))
                profit = profit.add(product.getCost());
            else
                profit = profit.subtract(product.getCost());
        }

        profit = sum.subtract(profit);

        return profit;
    }
}
