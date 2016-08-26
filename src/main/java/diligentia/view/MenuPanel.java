package diligentia.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPanel extends JPanel {
    private JButton createInvoiceButton;
    private JPanel contentPanel;

    public MenuPanel(JPanel contentPanel) {
        this.contentPanel = contentPanel;
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        createInvoiceButton = new JButton("Wystaw fakturę");//TODO-rwichrowski tłumaczenia
        createInvoiceButton.setVisible(true);
        createInvoiceButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                createInvoicePanel();
            }
        });
        add(createInvoiceButton);
    }

    private void createInvoicePanel() {
        contentPanel.add(new JLabel("ggggggggggggggggggggggggggg"));
        contentPanel.revalidate();
    }
}
