package diligentia.view;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuPanel extends JPanel {
    private JButton createInvoiceButton;

    public MenuPanel(JPanel contentPanel, AbstractAction abstractAction) {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        createInvoiceButton = new JButton("Wystaw fakturę");//TODO-rwichrowski tłumaczenia
        createInvoiceButton.setVisible(true);
        createInvoiceButton.setAction(abstractAction);
        add(createInvoiceButton);
    }
}
