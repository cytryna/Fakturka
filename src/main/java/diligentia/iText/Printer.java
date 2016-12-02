package diligentia.iText;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import diligentia.model.InvoiceModel;
import diligentia.model.Item;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Printer {

	/** Path to the resulting PDF file. */
	//TODO-rwichrowski Wynieść do jakiś propertisów path foldera na faktury
	private static final String RESULT = System.getProperty("user.home") + File.separator
		+ "fakturka/hello.pdf";
	private InvoiceModel model;
	private Font times9;
	private Font times12;
	private Font times14;
	private Font times14Bold;
	private BaseFont times;
	private DecimalFormat precision = new DecimalFormat("#0.00");

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
		initFonts();
		print();
		openFile(RESULT);
	}

	private void initFonts() {
		try {
			times = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, true);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		times9 = new Font(times, 9);
		times12 = new Font(times, 12);
		times14 = new Font(times, 14);
		times14Bold = new Font(times, 14, Font.BOLD);
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
			dodaj paddin do liniki z sprzedawcą
			Phrase customer = new Phrase("NABYWCA\nDiligentia Radosław Wichrowski\n04-113 Warszawa\nul. Łukowska 1 m 156\nNIP: 971-060-22-10");

			// PdfPCell emptyCell = new PdfPCell(salesman);
			PdfPCell emptyCell = new PdfPCell();
			emptyCell.setBorder(Rectangle.NO_BORDER);
			table.addCell(createCellDateAndCity("Wystawiono dnia " + model.getDate() + ", " + model.getCity(), times9));
			table.addCell(emptyCell);
			table.addCell(emptyCell);
			table.addCell(new Phrase("Faktura VAT nr "+model.getNumber(), times14Bold));
			table.addCell(emptyCell);
			table.addCell(new Phrase("Data sprzedaży "+model.getDate(), times12));//TODO-rwichrowski dodać date sprzadaży
			table.addCell(emptyCell);
			table.addCell(new Phrase("Termin płatności "+model.getDate(), times12));//TODO-rwichrowski dodać termin płatności
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


			String line = "POZYCJE FAKTURY:";
			document.add(new Paragraph(line, times14));
			document.add(createProductTable());

			long iPart;
			Double fractional;
			iPart = model.getGlobalGrossValue().longValue();
			fractional = model.getGlobalGrossValue() - iPart;
			document.add(new Paragraph("Słownie: " + model.getGlobalGrossValueText() + " " + precision.format(fractional), times14));

			// step 5
			document.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// TODO-rwichrowski Dodać bibliotekę log4J do logowania bugów
	}

	private PdfPCell createCellDateAndCity(String string, Font times9) {
		PdfPCell pdfPCell = new PdfPCell(new Phrase(string, times9));
		pdfPCell.setBorder(Rectangle.NO_BORDER);
		pdfPCell.setPaddingBottom(40);
		return pdfPCell;
	}

	private Element createProductTable() {

		PdfPTable productTabe = new PdfPTable(8);
		productTabe.setWidthPercentage(100);
		PdfPCell cellTable = new PdfPCell();
		cellTable.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cellTable.setPhrase(new Phrase("Lp", times9));
		productTabe.addCell(cellTable);
		cellTable.setPhrase(new Phrase("Nazwa towaru", times9));
		productTabe.addCell(cellTable);
		cellTable.setPhrase(new Phrase("Cena jednostkowa", times9));
		productTabe.addCell(cellTable);
		cellTable.setPhrase(new Phrase("Ilość", times9));
		productTabe.addCell(cellTable);
		cellTable.setPhrase(new Phrase("Wartość netto", times9));
		productTabe.addCell(cellTable);
		cellTable.setPhrase(new Phrase("Stavka Vat", times9));
		productTabe.addCell(cellTable);
		cellTable.setPhrase(new Phrase("Kwota Vat", times9));
		productTabe.addCell(cellTable);
		cellTable.setPhrase(new Phrase("Wartość brutto", times9));
		productTabe.addCell(cellTable);

		cellTable.setBackgroundColor(null);
		for (Item item : model.getItems()) {
			if (item.getAmount() == 0) {
				break;
			}
			cellTable.setPhrase(new Phrase(String.valueOf(item.getOrdinal()), times9));
			productTabe.addCell(cellTable);
			cellTable.setPhrase(new Phrase(item.getName(), times9));
			productTabe.addCell(cellTable);
			cellTable.setPhrase(new Phrase(String.valueOf(item.getPrice()), times9));
			productTabe.addCell(cellTable);
			cellTable.setPhrase(new Phrase(String.valueOf(item.getAmount()), times9));
			productTabe.addCell(cellTable);
			cellTable.setPhrase(new Phrase(String.valueOf(item.getNetValue()), times9));
			productTabe.addCell(cellTable);
			cellTable.setPhrase(new Phrase(String.valueOf(item.getTax()), times9));
			productTabe.addCell(cellTable);
			cellTable.setPhrase(new Phrase(String.valueOf(item.getTaxValue()), times9));
			productTabe.addCell(cellTable);
			cellTable.setPhrase(new Phrase(String.valueOf(item.getGrossValue()), times9));
			productTabe.addCell(cellTable);
		}
		PdfPCell emptyCell = new PdfPCell();
		emptyCell.setBorder(0);
		productTabe.addCell(emptyCell);
		productTabe.addCell(emptyCell);
		productTabe.addCell(emptyCell);
		productTabe.addCell(emptyCell);
		cellTable.setPhrase(new Phrase(String.valueOf(model.getGlobalNetValue()), times14));
		productTabe.addCell(cellTable);
		cellTable.setPhrase(new Phrase(Item.getTaxString(), times14));
		productTabe.addCell(cellTable);
		cellTable.setPhrase(new Phrase(String.valueOf(model.getGlobalTaxValue()), times14));
		productTabe.addCell(cellTable);
		cellTable.setPhrase(new Phrase(String.valueOf(model.getGlobalGrossValue()), times14));
		productTabe.addCell(cellTable);

		return productTabe;
	}

	public void setModel(InvoiceModel model) {
		this.model = model;
	}

}
