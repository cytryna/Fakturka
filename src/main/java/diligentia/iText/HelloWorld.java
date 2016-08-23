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
        table.setWidthPercentage(100);
        Phrase p = new Phrase(
                "Dr. iText or: How I Learned to Stop Worrying " +
                        "and Love the Portable Document Format.");
        PdfPCell cell = new PdfPCell(p);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell("Faktura VAT");
        table.addCell(cell);
        table.addCell("15/12/0049");
        cell.setLeading(20f, 0f);
        table.addCell(cell);
        table.addCell("Oryginał");//TODO-rwichrowski Polskie znaki
        cell.setLeading(3f, 1.2f);
        table.addCell(cell);
        table.addCell("Warszawa 2015-12-29");
        cell.setLeading(0f, 1.2f);
        table.addCell(cell);
        table.addCell("no leading at all");
        cell.setLeading(0f, 0f);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(
                "Dr. iText or: How I Learned to Stop Worrying and Love PDF"));
        table.addCell("padding 10");
        cell.setPadding(10);
        table.addCell(cell);
        table.addCell("padding 0");
        cell.setPadding(0);
        table.addCell(cell);
        table.addCell("different padding for left, right, top and bottom");
        cell.setPaddingLeft(20);
        cell.setPaddingRight(50);
        cell.setPaddingTop(0);
        cell.setPaddingBottom(5);
        table.addCell(cell);
//        p = new Phrase("iText in Action Second Edition");
//        table.getDefaultCell().setPadding(2);
//        table.getDefaultCell().setUseAscender(false);
//        table.getDefaultCell().setUseDescender(false);
//        table.addCell("padding 2; no ascender, no descender");
//        table.addCell(p);
//        table.getDefaultCell().setUseAscender(true);
//        table.getDefaultCell().setUseDescender(false);
//        table.addCell("padding 2; ascender, no descender");
//        table.addCell(p);
//        table.getDefaultCell().setUseAscender(false);
//        table.getDefaultCell().setUseDescender(true);
//        table.addCell("padding 2; descender, no ascender");
//        table.addCell(p);
//        table.getDefaultCell().setUseAscender(true);
//        table.getDefaultCell().setUseDescender(true);
//        table.addCell("padding 2; ascender and descender");
        cell.setPadding(2);
        cell.setUseAscender(true);
        cell.setUseDescender(true);
        table.addCell(p);
        document.add(table);
        // step 5
        document.close();
    }
}