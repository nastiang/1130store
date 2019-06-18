package ru.store.store1130.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.store.store1130.db.model.Views;
import ru.store.store1130.service.ReportService;
import ru.store.store1130.service.dto.ProductReportPagesDto;

@RestController
@RequestMapping("reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping
    @JsonView(Views.ShortReport.class)
    public ProductReportPagesDto getAllProductReports(
            @PageableDefault(size = 20, sort = { "date" }, direction = Sort.Direction.ASC) Pageable p
    ) {
        return reportService.getAllProductReport(p);
    }
}
