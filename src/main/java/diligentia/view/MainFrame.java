package diligentia.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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

//        menuPanel = new MenuPanel(contentPanel);
        menuPanel = new JPanel();
        menuPanel.setVisible(true);

        mainPanel.setVisible(true);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(menuPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

//        createButton("First", e -> swichPanel(new JLabel("first")));
//        createButton("Second", e -> swichPanel(new JLabel("second")));
    }


    public void createButton(String buttonName, ActionListener listener)
    {
        JButton jButton = new JButton(buttonName);
        jButton.addActionListener(listener);
        menuPanel.add(jButton);
    }


    private void swichPanel(JComponent component) {
        contentPanel.add(component);
    }

}
