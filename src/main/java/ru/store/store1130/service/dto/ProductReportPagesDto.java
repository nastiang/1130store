package ru.store.store1130.service.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.store.store1130.db.model.Views;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@JsonView(Views.ShortReport.class)
public class ProductReportPagesDto {
    private List<ProductReportDto> allProductReports;
    private Integer totalPages;
    private Integer currentPage;

    private BigDecimal totalSum = BigDecimal.ZERO;
    private BigDecimal totalProfit = BigDecimal.ZERO;
}
