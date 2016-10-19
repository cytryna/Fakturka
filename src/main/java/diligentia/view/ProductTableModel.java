package diligentia.view;

import diligentia.entity.Product;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by rwichrowski on 29.09.16.
 */
public class ProductTableModel extends AbstractTableModel {

    private List<Product> entries;

    private String[] colNomes =  { "Symbol", "Company Name",
            "Price", "Change" };

    private Class<?>[] colTipos = { String.class, String.class, String.class, Integer.class };

    public ProductTableModel(){}


    public void addNewProduct() {
        entries.add(new Product());
        reload(entries);
    }

    public void reload(List<Product> entries) {
        this.entries = entries;
        //atualiza o componente na tela
        fireTableDataChanged();
    }
    @Override
    public Class<?> getColumnClass(int coluna) {
        return colTipos[coluna];
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int coluna) {
        return colNomes[coluna];
    }

    @Override
    public int getRowCount() {
        if (entries == null){
            return 0;
        }
        return entries.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Product m = entries.get(linha);
        switch (coluna) {
            case 0:
                return m.getName();
            case 1:
                return m.getDescription();
            case 2:
                return Product.convertPriceToString(m.getPrice());
            case 3:
                return m.getAmount();
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public Product getMercadoriaAt(int index) {
        return entries.get(index);
    }

}
