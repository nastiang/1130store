package ru.store.store1130.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.db.model.User;
import ru.store.store1130.db.model.Views;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonView(Views.NoOrders.class)
public class ProductReportDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
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
