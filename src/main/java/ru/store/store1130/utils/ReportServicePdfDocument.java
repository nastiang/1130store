package ru.store.store1130.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import ru.store.store1130.service.dto.ProductDto;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class ReportServicePdfDocument {

    private static final String DEST = "C:\\Users\\Admin\\Desktop\\forTestingPdf\\ReportService.pdf";

    public void createReportServicePdfDocument(Page<ProductDto> products) throws IOException, DocumentException {
        BaseFont bf = BaseFont.createFont("C:\\Windows\\Fonts\\ARIAL.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

        Document document = new Document(PageSize.A4.rotate(), 50, 50, 50 ,50);

        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(DEST));
        document.open();
        Paragraph paragraph = new Paragraph("Отчет:", new Font(bf, 17));
        Chapter chapter = new Chapter(paragraph, 1);
        chapter.setNumberDepth(0);
        Paragraph title = new Paragraph("Отчет по категориям товаров", new Font(bf, 16));
        Section section = chapter.addSection(title);
        PdfPTable table = new PdfPTable(8);

        // Задаем ширину таблицы равной ширине листа формата А4
        table.setTotalWidth(PageSize.A4.rotate().getWidth()-10);
        table.setLockedWidth(true);

        addTableHeader(table, bf);
        addRows(table, products, bf);
        float[] columnWidths = new float[]{10f, 40f, 50f, 15f, 20f, 15f, 20f, 15f};
        table.setWidths(columnWidths);

        document.add(chapter);
//        document.add( Chunk.NEWLINE );
        document.add(new Phrase("\n"));
        document.add(table);



        document.close();

    }

    private void addTableHeader(PdfPTable table, BaseFont bf) {
        Stream.of("№ поз.", "Категория товара", "Наименование товара",
                "Количество, шт.", "Себестоимость ед., руб",
                "Цена ед., руб.", "Себестоимость, руб.", "Цена, руб.")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBorderWidth(2);
                    Phrase phrase = new Phrase(columnTitle, new Font(bf, 14));
                    header.setPhrase(phrase);
                    header.setHorizontalAlignment(Element.ALIGN_CENTER);
                    header.setVerticalAlignment(Element.ALIGN_CENTER);
                    table.addCell(header);
                });

    }

    private void addRows(PdfPTable table, Page<ProductDto> products, BaseFont bf) {
        final List<Integer> counter = new ArrayList<>();
        products.forEach(product ->{
            counter.add(1);

            PdfPCell cellNumberOfRow = new PdfPCell();
            Phrase phraseNumberOfRow = new Phrase(String.valueOf(counter.size()), new Font(bf, 14));
            cellNumberOfRow.setPhrase(phraseNumberOfRow);
            cellNumberOfRow.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellNumberOfRow.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cellNumberOfRow);

            PdfPCell cellNameOfCategory = new PdfPCell();
            Phrase phraseNameOfCategory = new Phrase(product.getProductCategory().getNameOfProductCategory(), new Font(bf, 14));
            cellNameOfCategory.setPhrase(phraseNameOfCategory);
            cellNameOfCategory.setVerticalAlignment(Element.ALIGN_CENTER);
            cellNameOfCategory.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cellNameOfCategory);

            PdfPCell cellNameOfProduct = new PdfPCell();
            Phrase phraseNameOfProduct = new Phrase(product.getNameOfProduct(), new Font(bf, 14));
            cellNameOfProduct.setPhrase(phraseNameOfProduct);
            cellNameOfProduct.setHorizontalAlignment(Element.ALIGN_LEFT);
            cellNameOfProduct.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cellNameOfProduct);

            PdfPCell cellOfCount = new PdfPCell();
            int count = product.getCount();
            Phrase phraseOfCount = new Phrase(String.valueOf(count), new Font(bf, 14));
            cellOfCount.setPhrase(phraseOfCount);
            cellOfCount.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellOfCount.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cellOfCount);

            PdfPCell cellOfSingleCost = new PdfPCell();
            Phrase phraseOfSingleCost = new Phrase(String.valueOf(getBigDecimalRounder(product.getCost())), new Font(bf, 14));
            cellOfSingleCost.setPhrase(phraseOfSingleCost);
            cellOfSingleCost.setVerticalAlignment(Element.ALIGN_CENTER);
            cellOfSingleCost.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cellOfSingleCost);

            PdfPCell cellOfSinglePrice = new PdfPCell();
            Phrase phraseOfSinglePrice = new Phrase(String.valueOf(getBigDecimalRounder(product.getPrice())), new Font(bf, 14));
            cellOfSinglePrice.setPhrase(phraseOfSinglePrice);
            cellOfSinglePrice.setVerticalAlignment(Element.ALIGN_CENTER);
            cellOfSinglePrice.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cellOfSinglePrice);

            PdfPCell cellOfCost = new PdfPCell();
            Phrase phraseOfCost = new Phrase(String.valueOf(
                    getBigDecimalRounder(product.getCost().multiply(new BigDecimal(count)))), new Font(bf, 14));
            cellOfCost.setPhrase(phraseOfCost);
            cellOfCost.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellOfCost.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cellOfCost);

            PdfPCell cellOfPrice = new PdfPCell();
            Phrase phraseOfPrice = new Phrase(String.valueOf(getBigDecimalRounder(product.getPrice().multiply(new BigDecimal(count)))), new Font(bf, 14));
            cellOfPrice.setPhrase(phraseOfPrice);
            cellOfPrice.setVerticalAlignment(Element.ALIGN_CENTER);
            cellOfPrice.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cellOfPrice);
        });
    }

    private BigDecimal getBigDecimalRounder(BigDecimal bigDecimal) {
        if(bigDecimal.setScale(0, RoundingMode.HALF_UP).compareTo(bigDecimal) == 0)
        return bigDecimal;
        else return bigDecimal.setScale(2, BigDecimal.ROUND_CEILING);
    }
}
