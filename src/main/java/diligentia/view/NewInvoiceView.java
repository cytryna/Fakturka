package diligentia.view;

import com.itextpdf.text.DocumentException;
import diligentia.iText.Printer;
import diligentia.model.Article;
import diligentia.model.Company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import java.util.List;

import static diligentia.util.GridBagConstraintsBuilder.constraints;
import static diligentia.util.GridBagConstraintsBuilder.fillDefaults;

public class NewInvoiceView extends JPanel {

	private ArticleTableModel model;

	public NewInvoiceView() {
		init();
	}

	private void init() {
		Company sellerCompany = new Company();
		// Wynieść to do jakiegoś wspolnego modelu gdzieś na początku i postaraj się go zapisać i o
		// dczytać z bazy danych
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

		JButton refresh = new JButton("Odśwież");
		refresh.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Article> articles = new ArrayList<>();
				articles.add(new Article(3, "Koło", "opis", 3, 3.0, 2));
				articles.add(new Article(4, "szyba", "opis", 4, 4.0, 4));
				reload(articles);
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


		add(createArticleTable(),
                fillDefaults().withPosition(0, 5).withGridWidth(2).build());

	}

	private void drukuj() {
		Printer printer = new Printer();
		try {
			printer.print();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

    private Component createArticleTable() {
		JTable table = new JTable();
		model = new ArticleTableModel();
		table.setModel(model);
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

	public void reload(List<Article> articles) {
		model.reload(articles);

	}

	//TODO-rwichrowski  liczby na słowa
	// http://www.algorytm.org/inne/zamiana-liczby-na-slowa-z-polska-gramatyka/zlns-gramatyka-j.html

	// https://examples.javacodegeeks.com/core-java/java-swing-mvc-example/
	// lub inne
	// https://www.google.pl/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=java+swing+mvc+example+code+
	// w java2s jest kiepski przykłąd
}
