package diligentia.iText;


import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class HelloWorld {

    /** Path to the resulting PDF file. */
    public static final String RESULT
            = "/home/rwichrowski/fakturka/hello.pdf";

    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws DocumentException
     * @throws IOException
     */
    public static void main(String[] args)
            throws DocumentException, IOException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(RESULT));
        // step 3
        document.open();
        // step 4
        PdfPTable table = new PdfPTable(2);
        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        table.setWidthPercentage(100);
        Phrase salesman = new Phrase("Wich-mot Edward Wichrowski\n09-500 Goostynin\nul. Szopena 4\nNIP: 775-000-46-84");
        Phrase customer = new Phrase("Diligentia Radosław Wichrowski\n04-113 Warszawa\nul. Łukowska 1 m 156\nNIP: 971-060-22-10");

//        PdfPCell emptyCell = new PdfPCell(salesman);
        PdfPCell emptyCell = new PdfPCell();
        emptyCell.setBorder(Rectangle.NO_BORDER);
        table.addCell("Faktura VAT");
        table.addCell(emptyCell);
        table.addCell("15/12/0049");
//        emptyCell.setLeading(20f, 0f);
        table.addCell(emptyCell);
        table.addCell("Oryginał");//TODO-rwichrowski Polskie znaki
//        emptyCell.setLeading(3f, 1.2f);
        table.addCell(emptyCell);
        table.addCell("Warszawa 2015-12-29");
//        emptyCell.setLeading(0f, 1.2f);
        table.addCell(emptyCell);
        table.addCell(salesman);
        table.addCell(customer);
        emptyCell = new PdfPCell(new Phrase("1"));
        table.addCell("padding 10");
//        emptyCell.setPadding(10);
        table.addCell(emptyCell);
        table.addCell("padding 0");
//        emptyCell.setPadding(0);
        table.addCell(emptyCell);
        table.addCell("2");
//        emptyCell.setPaddingLeft(20);
//        emptyCell.setPaddingRight(50);
//        emptyCell.setPaddingTop(0);
//        emptyCell.setPaddingBottom(5);
        table.addCell(emptyCell);
//        salesman = new Phrase("iText in Action Second Edition");
//        table.getDefaultCell().setPadding(2);
//        table.getDefaultCell().setUseAscender(false);
//        table.getDefaultCell().setUseDescender(false);
//        table.addCell("padding 2; no ascender, no descender");
//        table.addCell(salesman);
//        table.getDefaultCell().setUseAscender(true);
//        table.getDefaultCell().setUseDescender(false);
//        table.addCell("padding 2; ascender, no descender");
//        table.addCell(salesman);
//        table.getDefaultCell().setUseAscender(false);
//        table.getDefaultCell().setUseDescender(true);
//        table.addCell("padding 2; descender, no ascender");
//        table.addCell(salesman);
//        table.getDefaultCell().setUseAscender(true);
//        table.getDefaultCell().setUseDescender(true);
//        table.addCell("padding 2; ascender and descender");
        emptyCell.setPadding(2);
        emptyCell.setUseAscender(true);
        emptyCell.setUseDescender(true);
        table.addCell(salesman);
        document.add(table);


        //TODO-rwichrowski Dodać drugą tabelkę z danymi


        // step 5
        document.close();
    }
}