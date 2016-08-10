package diligentia.view;

import javax.swing.*;

public class MenuPanel extends JPanel {
    private JButton createInvoice;

    public MenuPanel(JPanel contentPanel) {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        createInvoice = new JButton("Wystaw fakturę");//TODO-rwichrowski tłumaczenia
        createInvoice.setVisible(true);
        add(createInvoice);
    }
}
