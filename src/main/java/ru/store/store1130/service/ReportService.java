package ru.store.store1130.service;

import com.itextpdf.text.DocumentException;
import org.springframework.data.domain.Pageable;
import ru.store.store1130.db.model.User;
import ru.store.store1130.service.dto.ProductReportPagesDto;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ReportService {
    ProductReportPagesDto getAllProductReport(Pageable pageable, User user);

    void downloadPDF() throws DocumentException, IOException, URISyntaxException;
}
