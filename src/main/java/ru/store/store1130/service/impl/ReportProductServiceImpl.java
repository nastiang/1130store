package ru.store.store1130.service.impl;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.store.store1130.Converters.ConverterDomainToDto;
import ru.store.store1130.db.repository.ReportProductRepository;
import ru.store.store1130.service.ReportProductService;
import ru.store.store1130.service.dto.ProductDto;
import ru.store.store1130.utils.ReportServicePdfDocument;

import java.io.IOException;

@Service
public class ReportProductServiceImpl implements ReportProductService {
    @Autowired
    private ReportProductRepository reportProductRepository;

    @Autowired
    private ConverterDomainToDto converterDomainToDto;

    @Autowired
    private ReportServicePdfDocument reportServicePdfDocument;

    @Override
    public void getAllProductForReport(Pageable pageable){
        try {
            reportServicePdfDocument.createReportServicePdfDocument(
                converterDomainToDto.convertToDto(reportProductRepository.findAll(pageable)));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
