package diligentia.iText;

import diligentia.model.InvoiceModel;
import diligentia.util.SerializableUtils;

public class HelloWorld {

	private static Printer printer = new Printer();
	private static InvoiceModel model;

	public static void main(String[] args) {

		printer.setModel(SerializableUtils.readFromDisc());
		printer.printAndOpen();
	}
}