package diligentia.view;

import diligentia.entity.Product;
import diligentia.entity.Company;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

@Component
public class MainFrame extends JFrame {

    private static final String COMPANY_CARD = "companyCard";
    private static final String INVOICE_CARD = "invoiceCard";
    private JPanel mainPanel = new JPanel();
//    private JPanel menuPanel;
    private JPanel contentPanel = new JPanel();
    private NewInvoiceView newInvoiceView;
    private CardLayout cardLayout;
    private CompanyView companyView;

    public MainFrame() {
        init();
    }

    @PostConstruct
    private void init() {
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVisible(true);
        add(scrollPane, BorderLayout.CENTER);

        contentPanel.setVisible(true);
        contentPanel.setBorder(BorderFactory.createTitledBorder("Content Panel"));
        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);

//        menuPanel = new MenuPanel(contentPanel);
//        menuPanel = new JPanel();
//        menuPanel.setVisible(true);

        mainPanel.setVisible(true);
        mainPanel.setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.add(new JLabel(""));
        headerPanel.setPreferredSize(new Dimension(getWidth(), 150));
        headerPanel.setBorder(BorderFactory.createTitledBorder("Header Panel"));
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        JPanel leftPanel = createLeftPanel();
        mainPanel.add(leftPanel, BorderLayout.WEST);

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        newInvoiceView = new NewInvoiceView();
        newInvoiceView.setVisible(false);
        companyView = new CompanyView();
        companyView.setVisible(false);
        contentPanel.add(companyView, COMPANY_CARD);
        contentPanel.add(newInvoiceView, INVOICE_CARD);

//        createButton("First");
//        createButton("Second");
    }

    private JPanel createLeftPanel() {
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));

        leftPanel.setPreferredSize(new Dimension(250, getHeight()));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Left Panel"));
        JButton firmyButton = new LeftJButton("Firmy", COMPANY_CARD);
        leftPanel.add(firmyButton);
        JButton invoiceButton = new LeftJButton("Nowa faktura", INVOICE_CARD);
        leftPanel.add(invoiceButton);
        return leftPanel;
    }


    public void createButton(String buttonName)
    {
        JButton jButton = new JButton(buttonName);
        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swichPanel(new JLabel("d"));
                revalidate();
            }
        });
//        contentPanel.add(new JLabel(buttonName));
//        menuPanel.add(jButton);
    }


    private void swichPanel(JComponent component) {
        contentPanel.add(component);
    }

    public void refreshTable(List<Product> entries) {
        newInvoiceView.reload(entries);
    }

    public void refreshCompanyTable(List<Company> all) {
        companyView.reload(all);
    }

    private class LeftJButton extends JButton {

        public LeftJButton(String labelText, String cardID) {
            super(labelText);
            addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(contentPanel, cardID);
                }
            });
        }
    }
}
