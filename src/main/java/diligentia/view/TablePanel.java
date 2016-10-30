package diligentia.view;

import static diligentia.util.GridBagConstraintsBuilder.bothConstraint;

import java.awt.*;
import javax.swing.*;
import diligentia.model.InvoiceModel;
import diligentia.model.Item;

public class TablePanel extends JPanel {

	float[] columnWidthPercentage = { 64.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f };
	private final InvoiceModel invoiceModel;

	public TablePanel(InvoiceModel invoiceModel) {
		this.invoiceModel = invoiceModel;
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		initialize();
	}

	private String[] colNomes = { "Nazwa towaru", "Cena jednostkowa netto", "Ilość",
		"Wartość netto", "Stawka Vat", "Kwota Vat", "Wartość brutto" };

	private void initialize() {
		setLayout(new GridBagLayout());
		int i = 0;

		invoiceModel.getItem().add(new Item());
		invoiceModel.getItem().add(new Item());
		invoiceModel.getItem().add(new Item());
		invoiceModel.getItem().add(new Item());
		invoiceModel.getItem().add(new Item());
		add(new JLabel(colNomes[0]), bothConstraint().withPosition(0, i).build());
		add(new JLabel(colNomes[1]), bothConstraint().withPosition(1, i).build());
		add(new JLabel(colNomes[2]), bothConstraint().withPosition(2, i).build());
		add(new JLabel(colNomes[3]), bothConstraint().withPosition(3, i).build());
		add(new JLabel(colNomes[4]), bothConstraint().withPosition(4, i).build());
		add(new JLabel(colNomes[5]), bothConstraint().withPosition(5, i).build());
		add(new JLabel(colNomes[6]), bothConstraint().withPosition(6, i).build());

		for (Item item : invoiceModel.getItem()) {
			InvoiceTableRow tableRow = new InvoiceTableRow(invoiceModel.getItem().get(i));
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
	}

}
