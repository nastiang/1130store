package ru.store.store1130.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.store.store1130.service.dto.ProductDto;
import ru.store.store1130.service.impl.ReportProductServiceImpl;

@RestController
@RequestMapping("reportProducts")
public class ReportProductController {
    @Autowired
    private ReportProductServiceImpl reportProductService;

    @GetMapping()
    public void getProductsByCategory(
            @PageableDefault(size = 20, sort = { "nameOfProduct" }, direction = Sort.Direction.ASC) Pageable pageable
    ){
        reportProductService.getAllProductForReport(pageable);
    }
}
