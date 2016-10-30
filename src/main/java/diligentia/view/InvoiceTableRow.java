package diligentia.view;

import diligentia.model.Item;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.List;
import java.util.function.Consumer;

public class InvoiceTableRow implements PropertyChangeListener {

//    private List<ViewObserver> observers;

    private NumberFormat doubleFormat;
    private NumberFormat intFormat;

    private JTextField nameField;
    private JFormattedTextField priceField;
    private JFormattedTextField amountField;
    private JFormattedTextField netValueField;
    private JTextField taxField;
    private JFormattedTextField taxValueField;
    private JFormattedTextField grossValueField;

    private final Item item;

    public InvoiceTableRow(Item item) {
        this.item = item;
        initialize();
    }

    private void initialize() {
        doubleFormat = NumberFormat.getNumberInstance();
        intFormat = NumberFormat.getNumberInstance();

        nameField = new JTextField();

        priceField = new JFormattedTextField(doubleFormat);
        priceField.setValue(item.getPrice());
        priceField.addPropertyChangeListener("value", this);

        amountField = new JFormattedTextField(intFormat);
        amountField.setValue(item.getAmount());
        amountField.addPropertyChangeListener("value", this);

        netValueField = new JFormattedTextField(doubleFormat);
        netValueField.setValue(item.getNetValue());
        netValueField.addPropertyChangeListener("value", this);
        netValueField.setEditable(false);

        taxField = new JTextField(item.getTax() + " %");
        taxField.setEditable(false);

        taxValueField = new JFormattedTextField(doubleFormat);
        taxValueField.setValue(item.getTaxValue());
        taxValueField.addPropertyChangeListener("value", this);
        taxValueField.setEditable(false);

        grossValueField = new JFormattedTextField(doubleFormat);
        grossValueField.setValue(item.getGrossValue());
        grossValueField.addPropertyChangeListener("value", this);
        grossValueField.setEditable(false);

    }

    public void refreshView() {
        System.err.println("refreshView");
        netValueField.setText(""+item.getNetValue());
        taxValueField.setValue(item.getTaxValue());
        grossValueField.setValue(item.getGrossValue());

//TODO potrzebne będzie do aktualizacji ceny końcowej
//        observers.stream().forEach(new Consumer<ViewObserver>() {
//            @Override
//            public void accept(ViewObserver viewObserver) {
//                viewObserver.refreshView();
//            }
//        });
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JFormattedTextField getPriceField() {
        return priceField;
    }

    public JTextField getAmountField() {
        return amountField;
    }

    public JTextField getNetValueField() {
        return netValueField;
    }

    public JTextField getTaxField() {
        return taxField;
    }

    public JTextField getTaxValueField() {
        return taxValueField;
    }

    public JTextField getGrossValueField() {
        return grossValueField;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Object source = evt.getSource();
        if (source == priceField) {
            item.setPrice(((Number)priceField.getValue()).doubleValue());
            refreshView();
        } else if (source == amountField) {
            item.setAmount(((Number)amountField.getValue()).intValue());
            refreshView();
        } else if (source == priceField) {
            item.setName(priceField.getText());
        }
    }
}


