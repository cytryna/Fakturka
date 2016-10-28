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
		for (Item item : invoiceModel.getItem()) {
			add(new JTextField(invoiceModel.getItem().get(i).getName()), bothConstraint()
				.withPosition(0, i + 1).withWeightX(columnWidthPercentage[0]).build());
			add(new JTextField("" + invoiceModel.getItem().get(i).getPrice()), bothConstraint()
				.withPosition(1, i + 1).withWeightX(columnWidthPercentage[1]).build());
			add(new JTextField(invoiceModel.getItem().get(i).getAmount()), bothConstraint()
				.withPosition(2, i + 1).withWeightX(columnWidthPercentage[2]).build());
			add(new JTextField(invoiceModel.getItem().get(i).getTax()), bothConstraint()
				.withPosition(3, i + 1).withWeightX(columnWidthPercentage[3]).build());
			add(new JTextField("" + invoiceModel.getItem().get(i).getGrossValue()), bothConstraint()
				.withPosition(4, i + 1).withWeightX(columnWidthPercentage[4]).build());
			i++;
		}
	}
}
