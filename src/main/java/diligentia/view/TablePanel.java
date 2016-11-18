package diligentia.view;

import static diligentia.util.GridBagConstraintsBuilder.bothConstraint;

import java.awt.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.*;
import diligentia.model.InvoiceModel;
import diligentia.model.Item;

public class TablePanel extends JPanel implements ViewObserver{

	float[] columnWidthPercentage = { 64.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f };
	private final InvoiceModel invoiceModel;
	private JFormattedTextField globalNetValueField;
	private JTextField globalTaxField;
	private JFormattedTextField globalTaxValueField;
	private JFormattedTextField globalGrossValueField;
	private List<InvoiceTableRow> invoiceTableRows = new ArrayList<>();
	private NumberFormat doubleFormat = NumberFormat.getNumberInstance();;

	public TablePanel(InvoiceModel invoiceModel) {
		this.invoiceModel = invoiceModel;
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		initComponents();
		createTable();
	}

	private String[] colNomes = { "Nazwa towaru", "Cena jednostkowa netto", "Ilość",
		"Wartość netto", "Stawka Vat", "Kwota Vat", "Wartość brutto" };

	private void initComponents() {
		globalNetValueField = new JFormattedTextField(doubleFormat);
		globalNetValueField.setEditable(false);
		globalTaxField = new JFormattedTextField(doubleFormat);
		globalTaxField.setEditable(false);
		globalTaxValueField = new JFormattedTextField(doubleFormat);
		globalTaxValueField.setEditable(false);
		globalGrossValueField = new JFormattedTextField(doubleFormat);
		globalGrossValueField.setEditable(false);
	}

	private void createTable() {
		setLayout(new GridBagLayout());
		int i = 0;

		invoiceModel.getItems().add(new Item());
		invoiceModel.getItems().add(new Item());
		invoiceModel.getItems().add(new Item());
		invoiceModel.getItems().add(new Item());
		invoiceModel.getItems().add(new Item());
		add(new JLabel(colNomes[0]), bothConstraint().withPosition(0, i).build());
		add(new JLabel(colNomes[1]), bothConstraint().withPosition(1, i).build());
		add(new JLabel(colNomes[2]), bothConstraint().withPosition(2, i).build());
		add(new JLabel(colNomes[3]), bothConstraint().withPosition(3, i).build());
		add(new JLabel(colNomes[4]), bothConstraint().withPosition(4, i).build());
		add(new JLabel(colNomes[5]), bothConstraint().withPosition(5, i).build());
		add(new JLabel(colNomes[6]), bothConstraint().withPosition(6, i).build());

		for (Item item : invoiceModel.getItems()) {
			InvoiceTableRow tableRow = new InvoiceTableRow(invoiceModel.getItems().get(i), this);
			invoiceTableRows.add(tableRow);
			add(tableRow.getNameField(), bothConstraint()
					.withPosition(0, i + 1).withWeightX(columnWidthPercentage[0]).build());
			add(tableRow.getPriceField(), bothConstraint()
					.withPosition(1, i + 1).withWeightX(columnWidthPercentage[1]).build());
			add(tableRow.getAmountField(), bothConstraint()
					.withPosition(2, i + 1).withWeightX(columnWidthPercentage[2]).build());
			add(tableRow.getNetValueField(), bothConstraint()
					.withPosition(3, i + 1).withWeightX(columnWidthPercentage[3]).build());
			add(tableRow.getTaxField(), bothConstraint()
					.withPosition(4, i + 1).withWeightX(columnWidthPercentage[4]).build());
			add(tableRow.getTaxValueField(), bothConstraint()
					.withPosition(5, i + 1).withWeightX(columnWidthPercentage[5]).build());
			add(tableRow.getGrossValueField(), bothConstraint()
					.withPosition(6, i + 1).withWeightX(columnWidthPercentage[6]).build());
			i++;
		}

		add(new JLabel("RAZEM: "), bothConstraint()
				.withPosition(2, i + 1).withWeightX(columnWidthPercentage[3]).withAnchor(GridBagConstraints.EAST).build());
		add(globalNetValueField, bothConstraint()
				.withPosition(3, i + 1).withWeightX(columnWidthPercentage[3]).build());
		add(globalTaxField, bothConstraint()
				.withPosition(4, i + 1).withWeightX(columnWidthPercentage[4]).build());
		add(globalTaxValueField, bothConstraint()
				.withPosition(5, i + 1).withWeightX(columnWidthPercentage[5]).build());
		add(globalGrossValueField, bothConstraint()
				.withPosition(6, i + 1).withWeightX(columnWidthPercentage[6]).build());
	}

	@Override
	public void refreshView() {
		globalNetValueField.setValue(invoiceModel.getGlobalNetValue());
		globalTaxField.setText(Item.getTaxString());
		globalTaxValueField.setValue(invoiceModel.getGlobalTaxValue());
		globalGrossValueField.setValue(invoiceModel.getGlobalGrossValue());
		invoiceModel.firePropertyChange();
	}

	public void refreshModel() {
		for (InvoiceTableRow invoiceTableRow : invoiceTableRows) {
			invoiceTableRow.refreshModel();
		}
	}
}
