package diligentia.view;

import static diligentia.util.GridBagConstraintsBuilder.bothConstraint;
import static diligentia.util.GridBagConstraintsBuilder.constraints;
import static diligentia.util.GridBagConstraintsBuilder.fillDefaults;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import diligentia.entity.Company;

public class CompanyView extends JPanel {

	private static final int DEFAULT_INSET = 10;
	private CompanyTableModel model;

	public CompanyView() {
		init();
	}

	private void init() {
		setLayout(new GridBagLayout());
		add(new JButton("Dodaj nową firmę"), constraints().withInsets(DEFAULT_INSET, DEFAULT_INSET, DEFAULT_INSET,
				DEFAULT_INSET).withPosition(0, 0).build());
		add(createEntryTable(),
                fillDefaults().withPosition(0, 1).withGridWidth(2).build());
		add(Box.createVerticalGlue(),
				bothConstraint().withPosition(0, 2).build());
	}

    private Component createEntryTable() {
		//TODO-rwichrowski Dodać scrolle do tabeli
		JTable table = new JTable();
		model = new CompanyTableModel();
		table.setModel(model);
		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setPreferredSize(new Dimension(700, 182));
		return tableScrollPane;
    }

	public void reload(List<Company> companies) {
		model.reload(companies);
	}
}
