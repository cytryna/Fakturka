package diligentia.view;

import diligentia.util.GridBagConstraintsBuilder;

import javax.swing.*;
import java.awt.*;

public class IssueInvoiceView extends JPanel {

    public IssueInvoiceView() {

        init();

    }

    private void init() {
        setLayout(new GridBagLayout());
        add(new JTextField(), GridBagConstraintsBuilder.constraints().build());
        add(new JTextField(), GridBagConstraintsBuilder.constraints().build());
        add(new JTextField(), GridBagConstraintsBuilder.constraints().build());
        add(new JTextField(), GridBagConstraintsBuilder.constraints().build());

    }
}
