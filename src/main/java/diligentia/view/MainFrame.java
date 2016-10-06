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

    private JPanel mainPanel = new JPanel();
//    private JPanel menuPanel;
    private JPanel contentPanel = new JPanel();
    private NewInvoiceView newInvoiceView;

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
        contentPanel.setLayout(new CardLayout());

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

        JPanel leftPanel = new JPanel();
        leftPanel.add(new JLabel(""));
        leftPanel.setPreferredSize(new Dimension(250, getHeight()));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Left Panel"));
        mainPanel.add(leftPanel, BorderLayout.WEST);

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        newInvoiceView = new NewInvoiceView();
        contentPanel.add(newInvoiceView);

//        createButton("First");
//        createButton("Second");
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
