package diligentia.view;

import diligentia.util.GridBagConstraintsBuilder;

import javax.swing.*;
import java.awt.*;

public class IssueInvoiceView extends JPanel {

    public IssueInvoiceView() {

        init();
        setBorder(BorderFactory.createLineBorder(Color.magenta));
    }

    private void init() {
        setLayout(new GridBagLayout());
        add(new JTextField("Faktura Vat"), GridBagConstraintsBuilder.constraints().build());
        add(new JTextField("15/2016"), GridBagConstraintsBuilder.constraints().build());
        add(new JTextField("Warszawa 2015-12-29"), GridBagConstraintsBuilder.constraints().build());
        add(new JLabel("Sprzedwaca"), GridBagConstraintsBuilder.constraints().build());
        add(new JTextField("NIP 775-000-78-54"), GridBagConstraintsBuilder.constraints().build());
        add(new JTextField("wich-mot edward Wichrowski"), GridBagConstraintsBuilder.constraints().build());
        add(new JTextField("09-500 Gostynin"), GridBagConstraintsBuilder.constraints().build());
        add(new JTextField("ul. Chopina 4"), GridBagConstraintsBuilder.constraints().build());
        add(new JLabel("Nabywca"), GridBagConstraintsBuilder.constraints().build());
        add(new JTextField("Firma krzak"), GridBagConstraintsBuilder.constraints().build());
        add(new JTextField("88-888 Kopydłów"), GridBagConstraintsBuilder.constraints().build());
        add(new JTextField("ul. Zagrobelna 4423"), GridBagConstraintsBuilder.constraints().build());
        add(new JTextField("NIP 465-884-55-22"), GridBagConstraintsBuilder.constraints().build());


    }

//    https://examples.javacodegeeks.com/core-java/java-swing-mvc-example/
//    lub inne
//    https://www.google.pl/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=java+swing+mvc+example+code+
//    w java2s jest kiepski przykłąd
}
