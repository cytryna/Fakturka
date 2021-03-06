package diligentia.view;


import static diligentia.util.GridBagConstraintsBuilder.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import diligentia.util.SerializableUtils;
import org.apache.log4j.Logger;

import diligentia.iText.Printer;
import diligentia.model.Company;
import diligentia.model.InvoiceModel;
import diligentia.model.Item;
import diligentia.util.DateUtils;

public class NewInvoiceView extends JPanel implements ViewObserver {

    private static Logger LOGGER = Logger.getLogger(NewInvoiceView.class);
	public static final int INSETS_BOTTOM = 3;
//	private ProductTableModel productTableModel;
    private Printer printer = new Printer();
    private InvoiceModel invoiceModel = new InvoiceModel();
    private TablePanel tablePanel;
    private JTextField cityTextField;
    private JFormattedTextField dateTextField;
    private JLabel grossValueLiteralLabel = new JLabel("słownie");
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private JTextField numberTextField;

    public NewInvoiceView() {

        init();
    }

	private void init() {
        invoiceModel.addObservers(this);
//	TODO-rwichrowski	1. Pracuj nad wyglądem formatki do wprowadzania danych
//	TODO-rwichrowski	2. Zacznij drukować dane z formatki

        setLayout(new GridBagLayout());
        int i = 0;
        add(createIssuedOn(), constraints().withPosition(0, i).withAnchor(GridBagConstraints.WEST).withInsetsLeft(20).build());
        add(createTitleWithNumber(), constraints().withPosition(1, ++i).build());
        add(createCompanyPanel("Sprzedawca", invoiceModel.getSalesman(), false),
                horizontalConstraint().withPosition(0, ++i).withInsets(10,30,10,30).build());
        add(createCompanyPanel("Nabywca", invoiceModel.getCustomer(), true),
				horizontalConstraint().withPosition(1, i).withInsets(10,30,10,30).build());

        add(createProductTable(),
                fillDefaults().withPosition(0, ++i).withGridWidth(2).build());


        add(grossValueLiteralLabel, constraints().withPosition(0, ++i).withGridWidth(2).withAnchor(GridBagConstraints.WEST).build());

        JButton printButton = new JButton("Drukuj");
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                print();
            }
        });
        add(printButton, constraints().withPosition(1, ++i).build());

        add(Box.createVerticalGlue(),
                bothConstraint().withPosition(0, ++i).withGridWidth(2).build());

    }

    private JComponent createTitleWithNumber() {
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("Faktura Vat"));
        numberTextField = new JTextField(invoiceModel.getNumber());
        Dimension dimension = new Dimension(70, 21);
        numberTextField.setPreferredSize(dimension);
        jPanel.add(numberTextField);
        return jPanel;
    }

    private JComponent createIssuedOn() {
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("Miejscowość:"));
        cityTextField = new JTextField();
        Dimension dimension = new Dimension(150, 21);
        cityTextField.setPreferredSize(dimension);
        cityTextField.setText(invoiceModel.getCity());
        jPanel.add(cityTextField);
        jPanel.add(new JLabel(", dnia:"));

        dateTextField = new JFormattedTextField(format);
        try {
            MaskFormatter dateMask = new MaskFormatter("####-##-##");
            dateMask.install(dateTextField);
        } catch (ParseException ex) {
            LOGGER.error("Couldn't parse a date", ex);
        }
        dateTextField.setValue(DateUtils.asDate(invoiceModel.getDate()));

        dimension = new Dimension(80, 21);
        dateTextField.setPreferredSize(dimension);
        jPanel.add(dateTextField);
        return jPanel;
    }

    private void print() {
//        refreshView();

        refreshModel();
        SerializableUtils.writeOnDisc(invoiceModel);
        printer.setModel(invoiceModel);
        printer.printAndOpen();
    }



    private Component createProductTable() {
        tablePanel = new TablePanel(invoiceModel);

        JScrollPane tableScrollPane = new JScrollPane(tablePanel);
        tableScrollPane.setPreferredSize(new Dimension(700, 182));
        return tableScrollPane;
    }

    private JComponent createCompanyPanel(String title, Company company, boolean editable) {
        JPanel jPanel = new JPanel(new GridBagLayout());
        jPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        int y = 0;
        jPanel.add(new JLabel(title),
                constraints().withPosition(0, y++).withAnchor(GridBagConstraints.WEST).build());
        jPanel.add(new JLabel("NIP:"),
                constraints().withPosition(0, y).withAnchor(GridBagConstraints.WEST).build());
        JTextField taxField = new JTextField(company.getTaxIdentificationNumber());
		taxField.setPreferredSize(new Dimension(100, 21));
        taxField.setEditable(editable);
		jPanel.add(taxField,
                constraints().withPosition(1, y++).withAnchor(GridBagConstraints.WEST).withInsetsBottom(INSETS_BOTTOM).build());
        jPanel.add(new JLabel("Nazwa:"),
                constraints().withPosition(0, y).withAnchor(GridBagConstraints.WEST).build());
		JTextField nameField = new JTextField(company.getName());
		nameField.setEditable(editable);
		Dimension preferredSize = new Dimension(350, 21);
		nameField.setPreferredSize(preferredSize);
		jPanel.add(nameField,
				constraints().withPosition(1, y++).withAnchor(GridBagConstraints.WEST).withInsetsBottom(INSETS_BOTTOM).build());
        jPanel.add(new JLabel("Adres"),
                constraints().withPosition(0, y).withAnchor(GridBagConstraints.WEST).build());
		JTextField adressLine1Field = new JTextField(company.getPostCode() + " " + company.getCity());
		adressLine1Field.setEditable(editable);
		adressLine1Field.setPreferredSize(preferredSize);
		jPanel.add(adressLine1Field,
                constraints().withPosition(1, y++).withAnchor(GridBagConstraints.WEST).withInsetsBottom(INSETS_BOTTOM).build());
		JTextField adressLine2Field = new JTextField(company.getStreet());
		adressLine2Field.setEditable(editable);
		adressLine2Field.setPreferredSize(preferredSize);
		jPanel.add(adressLine2Field,
				constraints().withPosition(1, y++).withAnchor(GridBagConstraints.WEST).withInsetsBottom(INSETS_BOTTOM).build());
        return jPanel;
    }

    public void reload(List<Item> entries) {
//        productTableModel.reload(entries);
    }

    @Override
    public void refreshView() {
        grossValueLiteralLabel.setText(invoiceModel.getGlobalGrossValueText());
    }

    private void refreshModel() {
        invoiceModel.setNumber(numberTextField.getText());
        invoiceModel.setCity(cityTextField.getText());
        invoiceModel.setDate(DateUtils.asLocalDate((Date) dateTextField.getValue()));
        tablePanel.refreshModel();
    }


    // https://examples.javacodegeeks.com/core-java/java-swing-mvc-example/
    // lub inne
    // https://www.google.pl/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=java+swing+mvc+example+code+
    // w java2s jest kiepski przykłąd
}
