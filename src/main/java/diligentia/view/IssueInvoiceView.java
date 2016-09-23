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

//    https://examples.javacodegeeks.com/core-java/java-swing-mvc-example/
//    lub inne
//    https://www.google.pl/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=java+swing+mvc+example+code+
//    w java2s jest kiepski przykłąd
}
