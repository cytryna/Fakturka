package diligentia.util;

import diligentia.model.InvoiceModel;

import java.io.*;

public class SerializableUtils {

	public static void writeOnDisc(InvoiceModel invoiceModel) {
		try (
			OutputStream file = new FileOutputStream("invoiceModel.ser");
			OutputStream buffer = new BufferedOutputStream(file);
			ObjectOutput output = new ObjectOutputStream(buffer);) {
			output.writeObject(invoiceModel);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static InvoiceModel readFromDisc() {
		// deserialize the quarks.ser file
		try (
			InputStream file = new FileInputStream("invoiceModel.ser");
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream(buffer);) {
			// deserialize the List
			InvoiceModel invoiceModel = (InvoiceModel) input.readObject();
			return invoiceModel;

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
