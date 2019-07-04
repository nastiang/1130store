package ru.store.store1130.service;

import org.springframework.data.domain.Pageable;

public interface ReportProductService {
    void getAllProductForReport(Pageable pageable);
}
