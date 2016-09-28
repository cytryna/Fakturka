package diligentia.view;

import diligentia.model.Company;
import diligentia.util.GridBagConstraintsBuilder;

import javax.swing.*;
import java.awt.*;

import static diligentia.util.GridBagConstraintsBuilder.constraints;
import static diligentia.util.GridBagConstraintsBuilder.fillDefaults;

public class IssueInvoiceView extends JPanel {

	public IssueInvoiceView() {

		init();
		setBorder(BorderFactory.createLineBorder(Color.magenta));
	}

	private void init() {
		Company sellerCompany = new Company();
		sellerCompany.setTaxIdentificationNumber("NIP 775-000-78-54");
		sellerCompany.setName("wich-mot edward Wichrowski");
		sellerCompany.setPostCode("09-500");
		sellerCompany.setCity("Gostynin");
		sellerCompany.setStreet("ul. Chopina 4");

		Company customerCompany = new Company();
		customerCompany.setTaxIdentificationNumber("NIP 465-884-55-22");
		customerCompany.setName("Firma krzak");
		customerCompany.setPostCode("88-888");
		customerCompany.setCity("Kopydłów");
		customerCompany.setStreet("ul. Zagrobelna 4423");

		setLayout(new GridBagLayout());
		add(new JTextField("Faktura Vat"), constraints().withPosition(0, 0).build());
		add(new JTextField("15/2016"), constraints().withPosition(0, 1).build());
		add(new JTextField("Warszawa 2015-12-29"), constraints().withPosition(0, 2).build());
		add(createCompanyPanel("Sprzedwaca", sellerCompany),
			fillDefaults().withPosition(0, 3).build());
		add(createCompanyPanel("Nabywca", customerCompany),
			fillDefaults().withPosition(1, 3).build());


        add(createArticleTable(),
                fillDefaults().withPosition(0, 4).build());

	}

    private Component createArticleTable() {
        return new JLabel("tabelka artykułów");
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

	// https://examples.javacodegeeks.com/core-java/java-swing-mvc-example/
	// lub inne
	// https://www.google.pl/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=java+swing+mvc+example+code+
	// w java2s jest kiepski przykłąd
}
