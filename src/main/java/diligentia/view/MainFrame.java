package diligentia.view;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class MainFrame extends JFrame {

    private JPanel mainPanel = new JPanel();
    private JPanel menuPanel;
    private JPanel contentPanel = new JPanel();

    public MainFrame() {
        init();

    }

    @PostConstruct
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

        createButton("First");
        createButton("Second");
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
        menuPanel.add(jButton);
    }


    private void swichPanel(JComponent component) {
        contentPanel.add(component);
    }

}
