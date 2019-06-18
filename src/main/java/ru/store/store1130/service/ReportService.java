package ru.store.store1130.service;

import ru.store.store1130.service.dto.ProductReportDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReportService {
    Page<ProductReportDto> getAllProductReport(Pageable pageable);
}
