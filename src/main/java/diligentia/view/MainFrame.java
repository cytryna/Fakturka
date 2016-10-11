package diligentia.view;

import diligentia.model.Article;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
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

    public MainFrame() {
        init();

    }

    @PostConstruct
    private void init() {
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVisible(true);
        add(scrollPane, BorderLayout.CENTER);

        contentPanel.setVisible(true);
        contentPanel.setBorder(BorderFactory.createTitledBorder("contentPanel"));
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
        JLabel aaa = new JLabel("firmy");
        aaa.setVisible(false);
        contentPanel.add(aaa, COMPANY_CARD);
        contentPanel.add(newInvoiceView, INVOICE_CARD);

//        createButton("First");
//        createButton("Second");
    }

    private JPanel createLeftPanel() {
        JPanel leftPanel = new JPanel();
        leftPanel.add(new JLabel(""));
        leftPanel.setPreferredSize(new Dimension(250, getHeight()));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Left Panel"));
        JButton firmyButton = new JButton("Firmy");
        firmyButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, COMPANY_CARD);
            }
        });

        leftPanel.add(firmyButton);
        JButton invoiceButton = new JButton("Nowa faktura");
        invoiceButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, INVOICE_CARD);
            }
        });
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

    public void refreshTable(List<Article> articles) {
        newInvoiceView.reload(articles);
    }
}
