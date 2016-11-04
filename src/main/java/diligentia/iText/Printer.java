package diligentia.iText;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import diligentia.model.Company;
import diligentia.model.InvoiceModel;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Printer {

	/** Path to the resulting PDF file. */
	//TODO-rwichrowski Wynieść do jakiś propertisów path foldera na faktury
	public static final String RESULT = System.getProperty("user.home") + File.separator
		+ "fakturka/hello.pdf";
	private InvoiceModel model;


	public void openFile(String path) {
		if (Desktop.isDesktopSupported()) {
			try {
				File myFile = new File(path);
				Desktop.getDesktop().open(myFile);
			} catch (IOException ex) {
				// no application registered for PDFs
			}
		}
	}


	public void printAndOpen() {
		print();
		openFile(RESULT);
	}

	private void print() {
		// step 1
		try {
			Document document = new Document();
			// step 2
			PdfWriter.getInstance(document, new FileOutputStream(RESULT));
			// step 3
			document.open();
			// step 4
			PdfPTable table = new PdfPTable(2);
			table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
			table.setWidthPercentage(100);
			Phrase salesman = new Phrase("SPRZEADWACA:\nWich-mot Edward Wichrowski\n09-500 Goostynin\nul. Szopena 4\n");
			Phrase customer = new Phrase("NABYWCA\nDiligentia Radosław Wichrowski\n04-113 Warszawa\nul. Łukowska 1 m 156\nNIP: 971-060-22-10");

			// PdfPCell emptyCell = new PdfPCell(salesman);
			PdfPCell emptyCell = new PdfPCell();
			emptyCell.setBorder(Rectangle.NO_BORDER);
			table.addCell("Wystawiono dnia "+model.getDate()+", "+model.getCity());
			table.addCell(emptyCell);
			table.addCell(emptyCell);
			table.addCell("Faktura VAT nr "+model.getNumber());
			table.addCell(emptyCell);
			table.addCell("data sprzedaży "+model.getDate());//TODO-rwichrowski dodać date sprzadaży
			table.addCell(emptyCell);
			table.addCell("termin płatności "+model.getDate());//TODO-rwichrowski dodać termin płatności
//			emptyCell.setLeading(20f, 0f);
			table.addCell(emptyCell);
			// emptyCell.setLeading(3f, 1.2f);
			table.addCell(emptyCell);

			// emptyCell.setLeading(0f, 1.2f);
			table.addCell(salesman);
			table.addCell(customer);

//			emptyCell = new PdfPCell(new Phrase("1"));
//			emptyCell.setPadding(10);
//			table.addCell(emptyCell);
//			table.addCell(emptyCell);
//			table.addCell("padding 0");
//			emptyCell.setPadding(0);
//			table.addCell(emptyCell);
//			table.addCell("2");
			// emptyCell.setPaddingLeft(20);
			// emptyCell.setPaddingRight(50);
			// emptyCell.setPaddingTop(0);
			// emptyCell.setPaddingBottom(5);
//			table.addCell(emptyCell);
			// salesman = new Phrase("iText in Action Second Edition");
			// table.getDefaultCell().setPadding(2);
			// table.getDefaultCell().setUseAscender(false);
			// table.getDefaultCell().setUseDescender(false);
			// table.addCell("padding 2; no ascender, no descender");
			// table.addCell(salesman);
			// table.getDefaultCell().setUseAscender(true);
			// table.getDefaultCell().setUseDescender(false);
			// table.addCell("padding 2; ascender, no descender");
			// table.addCell(salesman);
			// table.getDefaultCell().setUseAscender(false);
			// table.getDefaultCell().setUseDescender(true);
			// table.addCell("padding 2; descender, no ascender");
			// table.addCell(salesman);
			// table.getDefaultCell().setUseAscender(true);
			// table.getDefaultCell().setUseDescender(true);
			// table.addCell("padding 2; ascender and descender");
			// emptyCell.setPadding(2);
			// emptyCell.setUseAscender(true);
			// emptyCell.setUseDescender(true);
			// table.addCell(salesman);
			document.add(table);

			BaseFont times = null;

			times = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, true);

			Font t9 = new Font(times, 14);
			String line = "POZYCJE FAKTURY:";
			document.add(new Paragraph(line, t9));

			PdfPTable productTabe = new PdfPTable(2);
			PdfPCell cellLp = new PdfPCell(new Phrase("Lp"));
			cellLp.setBackgroundColor(BaseColor.LIGHT_GRAY);
			productTabe.addCell(cellLp);
			cellLp.setPhrase(new Phrase("Nazwa artykółu", t9));
			productTabe.addCell(cellLp);

			document.add(productTabe);

			document.add(new Paragraph("artykółu Odkud jste?"));
			document.add(new Paragraph("Uvidíme se za chvilku. Měj se."));
			document.add(new Paragraph("Dovolte, abych se představil."));
			document.add(new Paragraph("To je studentka."));
			document.add(new Paragraph("Všechno v pořádku?"));
			document.add(new Paragraph("On je inženýr. Ona je lékař."));
			document.add(new Paragraph("Toto je okno."));
			document.add(new Paragraph("Zopakujte to prosím."));

			// step 5
			document.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// TODO-rwichrowski Dodać bibliotekę log4J do logowania bugów
	}

	public void setModel(InvoiceModel model) {
		this.model = model;
	}

}
