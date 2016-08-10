package diligentia.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MainFrame extends JFrame {

    private JPanel mainPanel = new JPanel();
    private JPanel sellerPanel = new JPanel();
    private JPanel purchaserPanel = new JPanel();

    public MainFrame() {
        init();

    }

    private void init() {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVisible(true);
        setContentPane(scrollPane);
        scrollPane.setBackground(Color.gray);
        scrollPane.setOpaque(true);
        scrollPane.setSize(new Dimension(800, 400));
        scrollPane.setPreferredSize(new Dimension(800, 400));
        mainPanel.setPreferredSize(new Dimension(800, 400));
        mainPanel.setVisible(true);
        scrollPane.add(mainPanel);
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        sellerPanel.setBackground(Color.cyan);
        sellerPanel.setVisible(true);
        mainPanel.add(sellerPanel, gridBagConstraints);
        gridBagConstraints.gridy = 1;
        purchaserPanel.setBackground(Color.magenta);
        purchaserPanel.setVisible(true);
        mainPanel.add(purchaserPanel, gridBagConstraints);


    }
}
