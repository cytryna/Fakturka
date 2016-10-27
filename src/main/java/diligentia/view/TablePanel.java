package diligentia.view;

import diligentia.model.InvoiceModel;

import javax.swing.*;
import java.awt.*;

public class TablePanel extends JPanel {

    float[] columnWidthPercentage = {64.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f};
    private final InvoiceModel invoiceModel;

    public TablePanel(InvoiceModel invoiceModel) {
        this.invoiceModel = invoiceModel;
        setBorder(BorderFactory.createLineBorder(Color.green));
        initialize();
    }


    private String[] colNomes =  { "Nazwa towaru", "Ilość",
            "Cena jednostkowa netto", "Wartość netto", "Stawka Vat", "Kwota Vat", "Wartość brutto"};


    private void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JTextField nameField = new JTextField("Pokrowce samochodowe");
        add(nameField);
        add(new JTextField("2"));
        add(new JTextField("szt"));
        add(new JTextField("59.99"));
        add(new JTextField("119.98"));
    }
}
