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

import static diligentia.util.GridBagConstraintsBuilder.bothConstraint;
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

//	TODO-rwichrowski	1. Pracuj nad wyglądem formatki do wprowadzania danych
//	TODO-rwichrowski	2. Zacznij drukować dane z formatki

        setLayout(new GridBagLayout());
        int i = 0;
        add(createIssuedOn(), constraints().withPosition(0, i++).withAnchor(GridBagConstraints.WEST).withInsetsLeft(20).build());


        add(new JTextField("Faktura Vat"), constraints().withPosition(0, i++).build());
        add(new JTextField("15/2016"), constraints().withPosition(0, i++).build());
        add(new JTextField("Warszawa 2015-12-29"), constraints().withPosition(0, i++).build());
        add(createCompanyPanel("Sprzedwaca", invoiceModel.getSalesman()),
                fillDefaults().withPosition(0, i++).build());
        add(createCompanyPanel("Nabywca", invoiceModel.getCustomer()),
                fillDefaults().withPosition(1, i).build());

        JButton refresh = new JButton("Dodaj nowy artykuł");
        refresh.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productTableModel.addNewProduct();
            }
        });
        add(refresh, constraints().withPosition(0, i++).build());

        JButton printButton = new JButton("Drukuj");
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drukuj();
            }
        });
        add(printButton, constraints().withPosition(1, i).build());


        add(createProductTable(),
                fillDefaults().withPosition(0, i++).withGridWidth(2).build());


        add(Box.createVerticalGlue(),
                bothConstraint().withPosition(0, i++).withGridWidth(2).build());

    }

    private JComponent createIssuedOn() {
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("Miejscowość:"));
        JTextField cityTextField = new JTextField(invoiceModel.getCity());
        Dimension dimension = new Dimension(150, 21);
        cityTextField.setPreferredSize(dimension);
        jPanel.add(cityTextField);
        jPanel.add(new JLabel(", dnia:"));
        JTextField dateTextField = new JTextField(""+invoiceModel.getDate());
        dimension = new Dimension(80, 21);
        dateTextField.setPreferredSize(dimension);
        jPanel.add(dateTextField);
        return jPanel;
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
