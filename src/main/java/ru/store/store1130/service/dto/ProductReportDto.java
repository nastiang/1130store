package ru.store.store1130.service.dto;

import lombok.Data;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.db.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductReportDto {
    private LocalDateTime data;
    private User user;
    private List<Product> products;
    private BigDecimal sum;
    private BigDecimal profit;
    private static BigDecimal totalSum;
    private static BigDecimal totalProfit;

    public void addTotalSum(BigDecimal sum) {
        totalSum.add(sum);
    }

    public void addTotalProfit(BigDecimal profit) {
        totalProfit.add(profit);
    }
}
