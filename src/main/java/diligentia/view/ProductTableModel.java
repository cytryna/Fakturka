package diligentia.view;

import diligentia.model.Item;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

    public class ProductTableModel extends AbstractTableModel {

    private List<Item> items = new ArrayList<>();

    private String[] colNomes =  { "Nazwa towaru", "Ilość",
            "Cena jednostkowa netto", "Wartość netto", "Stawka Vat", "Kwota Vat", "Wartość brutto"};

    private Class<?>[] colTipos = { String.class, Integer.class, String.class, String.class,  String.class, String.class, String.class};

    public ProductTableModel(){}


    public void addNewProduct() {
        items.add(new Item());
        reload(items);
    }

    public void reload(List<Item> entries) {
        this.items = entries;
        //atualiza o componente na tela
        fireTableDataChanged();
    }
    @Override
    public Class<?> getColumnClass(int coluna) {
        return colTipos[coluna];
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int coluna) {
        return colNomes[coluna];
    }

    @Override
    public int getRowCount() {
        if (items == null){
            return 0;
        }
        return items.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Item m = items.get(linha);
        switch (coluna) {
            case 0:
                return m.getName();
            case 1:
                return m.getAmount();
            case 2:
                return m.getPrice();
            case 3:
                return m.getNetValue();
            case 4:
                return m.getTax() + "%";
            case 5:
                return m.getTaxValue();
            case 6:
                return m.getGrossValue();
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public Item getMercadoriaAt(int index) {
        return items.get(index);
    }

}
