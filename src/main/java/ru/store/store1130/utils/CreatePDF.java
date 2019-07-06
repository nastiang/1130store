package ru.store.store1130.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import ru.store.store1130.db.model.Product;
import ru.store.store1130.service.dto.ProductReportDto;
import ru.store.store1130.service.dto.ProductReportPagesDto;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class CreatePDF {
    public static void getPDF(ProductReportPagesDto productReportPagesDto) throws IOException, DocumentException, URISyntaxException {
        Document document = new Document(PageSize.A4.rotate(), 50, 50, 50 ,50);

        PdfWriter.getInstance(document, new FileOutputStream("E:\\iText.pdf"));

        document.open();

        BaseFont bf = BaseFont.createFont("/font/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font = new Font(bf, 12);

        PdfPTable table = new PdfPTable(5);

        table.setTotalWidth(PageSize.A4.rotate().getWidth()-10);
        table.setLockedWidth(true);

        addTableHeader(table, font);
        addRows(table, productReportPagesDto.getAllProductReports(), font);

        document.add(table);

        document.close();
    }

    private static void addTableHeader(PdfPTable table, Font font) {
        Stream.of("Дата", "Пользователь", "Продукт", "Сумма", "Себестоимость")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle, font));
                    table.addCell(header);
                });
    }

    private static void addRows(PdfPTable table, List<ProductReportDto> allProductReports, Font font)  {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (ProductReportDto productReport : allProductReports) {
            table.addCell(productReport.getDate().format(formatter));
            table.addCell(productReport.getUser().getEmail());

            StringBuilder sb = new StringBuilder();
            Set<Product> products = new HashSet<>(productReport.getProducts());
            for (Product product : products) {
                if (sb.length() == 0)
                    sb.append(product.getNameOfProduct());
                else
                    sb.append(", ").append(product.getNameOfProduct());
            }
            table.addCell(new Phrase(sb.toString(), font));

            table.addCell(productReport.getSum().toString());
            table.addCell(productReport.getProfit().toString());
        }
    }

}
