package ru.store.store1130.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.store.store1130.db.model.Views;
import ru.store.store1130.service.ReportService;
import ru.store.store1130.service.dto.ProductReportDto;

import java.util.List;

@RestController
@RequestMapping("reports")
public class ReportController {
    @Autowired
    ReportService reportService;

    @GetMapping
    @JsonView(Views.NoOrders.class)
    public List<ProductReportDto> getAllProductReports() {
        return reportService.getAllProductReport();
    }
}
