package diligentia.view;


import diligentia.iText.Printer;
import diligentia.model.Company;
import diligentia.model.InvoiceModel;
import diligentia.model.Item;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import static diligentia.util.GridBagConstraintsBuilder.*;
@Deprecated
public class NewInvoiceViewWithTable extends JPanel {
//
//	float[] columnWidthPercentage = {64.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f};
//	public static final int INSETS_BOTTOM = 3;
//	private ProductTableModel productTableModel;
//    private Printer printer = new Printer();
//    private InvoiceModel invoiceModel = new InvoiceModel();
//	private JTable table;
//
//	public NewInvoiceViewWithTable() {
//        init();
//
//		addComponentListener(new ComponentAdapter() {
//			@Override
//			public void componentResized(ComponentEvent e) {
//				resizeColumns();
//			}
//		});
//    }
//
//	private void resizeColumns() {
//		int tW = table.getWidth();
//		TableColumn column;
//		TableColumnModel jTableColumnModel = table.getColumnModel();
//		int cantCols = jTableColumnModel.getColumnCount();
//		for (int i = 0; i < cantCols; i++) {
//			column = jTableColumnModel.getColumn(i);
//			int pWidth = Math.round(columnWidthPercentage[i] * tW);
//			column.setPreferredWidth(pWidth);
//		}
//	}
//
//	private void init() {
//
////	TODO-rwichrowski	1. Pracuj nad wyglądem formatki do wprowadzania danych
////	TODO-rwichrowski	2. Zacznij drukować dane z formatki
//
//        setLayout(new GridBagLayout());
//        int i = 0;
//        add(createIssuedOn(), constraints().withPosition(0, i++).withAnchor(GridBagConstraints.WEST).withInsetsLeft(20).build());
//        add(createTitleWithNumber(), constraints().withPosition(1, i++).build());
//        add(createCompanyPanel("Sprzedawca", invoiceModel.getSalesman(), false),
//                horizontalConstraint().withPosition(0, i).withInsets(10,30,10,30).build());
//        add(createCompanyPanel("Nabywca", invoiceModel.getCustomer(), true),
//				horizontalConstraint().withPosition(1, i++).withInsets(10,30,10,30).build());
//
//        JButton refresh = new JButton("Dodaj nowy artykuł");
//        refresh.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                productTableModel.addNewProduct();
//            }
//        });
//        add(refresh, constraints().withPosition(0, i++).build());
//
//        JButton printButton = new JButton("Drukuj");
//        printButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                drukuj();
//            }
//        });
//        add(printButton, constraints().withPosition(1, i).build());
//
//
//        add(createProductTable(),
//                fillDefaults().withPosition(0, i++).withGridWidth(2).build());
//
//
//        add(Box.createVerticalGlue(),
//                bothConstraint().withPosition(0, i++).withGridWidth(2).build());
//
//    }
//
//    private JComponent createTitleWithNumber() {
//        JPanel jPanel = new JPanel();
//        jPanel.add(new JLabel("Faktura Vat"));
//        JTextField numberTextField = new JTextField(invoiceModel.getNumber());
//        Dimension dimension = new Dimension(70, 21);
//        numberTextField.setPreferredSize(dimension);
//        jPanel.add(numberTextField);
//        return jPanel;
//    }
//
//    private JComponent createIssuedOn() {
//        JPanel jPanel = new JPanel();
//        jPanel.add(new JLabel("Miejscowość:"));
//        JTextField cityTextField = new JTextField(invoiceModel.getCity());
//        Dimension dimension = new Dimension(150, 21);
//        cityTextField.setPreferredSize(dimension);
//        jPanel.add(cityTextField);
//        jPanel.add(new JLabel(", dnia:"));
//        JTextField dateTextField = new JTextField(""+invoiceModel.getDate());
//        dimension = new Dimension(80, 21);
//        dateTextField.setPreferredSize(dimension);
//        jPanel.add(dateTextField);
//        return jPanel;
//    }
//
//    private void drukuj() {
//        printer.setModel(invoiceModel);
//        printer.printAndOpen();
//
//
//    }
//
//    private Component createProductTable() {
//        table = new JTable();
//        productTableModel = new ProductTableModel();
//        table.setModel(productTableModel);
//        JScrollPane tableScrollPane = new JScrollPane(table);
//        tableScrollPane.setPreferredSize(new Dimension(700, 182));
//		resizeColumns();
//        return tableScrollPane;
//    }
//
//    private JComponent createCompanyPanel(String title, Company company, boolean editable) {
//        JPanel jPanel = new JPanel(new GridBagLayout());
//        jPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
//        int y = 0;
//        jPanel.add(new JLabel(title),
//                constraints().withPosition(0, y++).withAnchor(GridBagConstraints.WEST).build());
//        jPanel.add(new JLabel("NIP:"),
//                constraints().withPosition(0, y).withAnchor(GridBagConstraints.WEST).build());
//        JTextField taxField = new JTextField(company.getTaxIdentificationNumber());
//		taxField.setPreferredSize(new Dimension(100, 21));
//        taxField.setEditable(editable);
//		jPanel.add(taxField,
//                constraints().withPosition(1, y++).withAnchor(GridBagConstraints.WEST).withInsetsBottom(INSETS_BOTTOM).build());
//        jPanel.add(new JLabel("Nazwa:"),
//                constraints().withPosition(0, y).withAnchor(GridBagConstraints.WEST).build());
//		JTextField nameField = new JTextField(company.getName());
//		nameField.setEditable(editable);
//		Dimension preferredSize = new Dimension(350, 21);
//		nameField.setPreferredSize(preferredSize);
//		jPanel.add(nameField,
//				constraints().withPosition(1, y++).withAnchor(GridBagConstraints.WEST).withInsetsBottom(INSETS_BOTTOM).build());
//        jPanel.add(new JLabel("Adres"),
//                constraints().withPosition(0, y).withAnchor(GridBagConstraints.WEST).build());
//		JTextField adressLine1Field = new JTextField(company.getPostCode() + " " + company.getCity());
//		adressLine1Field.setEditable(editable);
//		adressLine1Field.setPreferredSize(preferredSize);
//		jPanel.add(adressLine1Field,
//                constraints().withPosition(1, y++).withAnchor(GridBagConstraints.WEST).withInsetsBottom(INSETS_BOTTOM).build());
//		JTextField adressLine2Field = new JTextField(company.getStreet());
//		adressLine2Field.setEditable(editable);
//		adressLine2Field.setPreferredSize(preferredSize);
//		jPanel.add(adressLine2Field,
//				constraints().withPosition(1, y++).withAnchor(GridBagConstraints.WEST).withInsetsBottom(INSETS_BOTTOM).build());
//        return jPanel;
//    }
//
//    public void reload(List<Item> entries) {
//        productTableModel.reload(entries);
//
//    }
//
//    //TODO-rwichrowski  liczby na słowa
//    // http://www.algorytm.org/inne/zamiana-liczby-na-slowa-z-polska-gramatyka/zlns-gramatyka-j.html
//
//    // https://examples.javacodegeeks.com/core-java/java-swing-mvc-example/
//    // lub inne
//    // https://www.google.pl/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=java+swing+mvc+example+code+
//    // w java2s jest kiepski przykłąd
}
