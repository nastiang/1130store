package ru.store.store1130.service;

import org.springframework.data.domain.Pageable;
import ru.store.store1130.service.dto.ProductReportPagesDto;

public interface ReportService {
    ProductReportPagesDto getAllProductReport(Pageable pageable);
}
