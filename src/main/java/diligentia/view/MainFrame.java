package diligentia.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MainFrame extends JFrame {

    private JPanel mainPanel = new JPanel();
    private JPanel menuPanel;
    private JPanel contentPanel = new JPanel();

    public MainFrame() {
        init();
    }

    private void init() {
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVisible(true);
        add(scrollPane, BorderLayout.CENTER);

        contentPanel.setVisible(true);
        contentPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));//TODO-rwichrowski jakiś properties z kolorami
        contentPanel.setLayout(new CardLayout());

        menuPanel = new MenuPanel(contentPanel, createInvoicePanel());
        menuPanel.setVisible(true);

        mainPanel.setVisible(true);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(menuPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

    }

    private AbstractAction createInvoicePanel() {
        contentPanel. skończyć card layout
    }
}
