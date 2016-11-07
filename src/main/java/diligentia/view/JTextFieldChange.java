package diligentia.view;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.text.NumberFormat;

public class JTextFieldChange extends JFormattedTextField {

	public JTextFieldChange(NumberFormat format) {
		super(format);
		initialize();
	}

	private void initialize() {
		getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				update(e);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				update(e);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				update(e);
			}
		});
	}

	private void update(DocumentEvent e) {
//		if (null == originator) {
//			originator = e.getDocument();
//			String text = "";
//			try {
//				text = originator.getText(0, originator.getLength());
//			} catch (final Exception ex) {
//				ex.printStackTrace();
//			}
//
//			if (!text.isEmpty()) {
//				final int p = Integer.parseInt(text);
//				if (originator.equals(field.getDocument())) {
//					final int i = (p + 1);
//					final String s = String.valueOf(i);
//					field1.setText(s);
//				} else {
//					final int i = (p - 1);
//					final String s = String.valueOf(i);
//					field.setText(s);
//				}
//			} else {
//				field.setText(text);
//				field1.setText(text);
//			}
//
//			originator = null;
//		}

	}
}
