package diligentia.iText;


import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class HelloWorld {

    /** Path to the resulting PDF file. */
    public static final String RESULT
            = "/home/rwichrowski/fakturka/hello.pdf";

    public static void main(String[] args)
            throws DocumentException, IOException {
        new HelloWorld().createPdf(RESULT);
    }

    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(8);
        for(int aw = 0; aw < 16; aw++){
            table.addCell("hi");
        }
        document.add(table);
        document.close();
    }
}