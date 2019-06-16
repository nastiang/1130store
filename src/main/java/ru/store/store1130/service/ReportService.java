package ru.store.store1130.service;

import org.springframework.stereotype.Service;
import ru.store.store1130.db.model.SalesOrder;
import ru.store.store1130.db.repository.ExCustomRepository;
import ru.store.store1130.service.dto.ProductReportDto;

import java.util.List;

@Service
public interface ReportService  {
    List<ProductReportDto> getAllProductReport();
}
