package diligentia.view;


import diligentia.iText.Printer;
import diligentia.model.Company;
import diligentia.model.InvoiceModel;
import diligentia.model.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static diligentia.util.GridBagConstraintsBuilder.constraints;
import static diligentia.util.GridBagConstraintsBuilder.fillDefaults;

	public class NewInvoiceView extends JPanel {

		private ProductTableModel productTableModel;
		private Printer printer = new Printer();
		private InvoiceModel invoiceModel = new InvoiceModel();

		public NewInvoiceView() {
			init();
		}

	private void init() {

		setLayout(new GridBagLayout());
		add(new JTextField("Faktura Vat"), constraints().withPosition(0, 0).build());
		add(new JTextField("15/2016"), constraints().withPosition(0, 1).build());
		add(new JTextField("Warszawa 2015-12-29"), constraints().withPosition(0, 2).build());
		add(createCompanyPanel("Sprzedwaca", invoiceModel.getSalesman()),
			fillDefaults().withPosition(0, 3).build());
		add(createCompanyPanel("Nabywca", invoiceModel.getCustomer()),
			fillDefaults().withPosition(1, 3).build());

		JButton refresh = new JButton("Dodaj nowy artykuł");
		refresh.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productTableModel.addNewProduct();
			}
		});
		add(refresh,constraints().withPosition(0, 4).build());

		JButton printButton = new JButton("Drukuj");
		printButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drukuj();
			}
		});
		add(printButton,constraints().withPosition(1, 4).build());


		add(createProductTable(),
                fillDefaults().withPosition(0, 5).withGridWidth(2).build());

	}

	private void drukuj() {
		printer.setModel(invoiceModel);
		printer.printAndOpen();


	}

    private Component createProductTable() {
		JTable table = new JTable();
		productTableModel = new ProductTableModel();
		table.setModel(productTableModel);
		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setPreferredSize(new Dimension(700, 182));

		return tableScrollPane;
    }

    private Component createCompanyPanel(String title, Company company) {
		JPanel jPanel = new JPanel(new GridBagLayout());
		jPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		int y = 0;
		jPanel.add(new JLabel(title),
			constraints().withPosition(0, y++).withAnchor(GridBagConstraints.WEST).build());
		jPanel.add(new JTextField(company.getTaxIdentificationNumber()),
			constraints().withPosition(0, y++).withAnchor(GridBagConstraints.WEST).build());
		jPanel.add(new JTextField(company.getName()),
			constraints().withPosition(0, y++).withAnchor(GridBagConstraints.WEST).build());
		jPanel.add(new JTextField(company.getPostCode() + " " + company.getCity()),
			constraints().withPosition(0, y++).withAnchor(GridBagConstraints.WEST).build());
		jPanel.add(new JTextField(company.getStreet()),
			constraints().withPosition(0, y++).withAnchor(GridBagConstraints.WEST).build());
		return jPanel;
	}

	public void reload(List<Item> entries) {
		productTableModel.reload(entries);

	}

	//TODO-rwichrowski  liczby na słowa
	// http://www.algorytm.org/inne/zamiana-liczby-na-slowa-z-polska-gramatyka/zlns-gramatyka-j.html

	// https://examples.javacodegeeks.com/core-java/java-swing-mvc-example/
	// lub inne
	// https://www.google.pl/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=java+swing+mvc+example+code+
	// w java2s jest kiepski przykłąd
}
