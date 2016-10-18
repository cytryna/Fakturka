package diligentia.view;

import diligentia.entity.Entry;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by rwichrowski on 29.09.16.
 */
public class EntryTableModel extends AbstractTableModel {

    private List<Entry> entries;

    private String[] colNomes =  { "Symbol", "Company Name",
            "Price", "Change" };

    private Class<?>[] colTipos = { String.class, String.class, String.class, Integer.class };

    public EntryTableModel(){}


    public void addNewEntry() {
        entries.add(new Entry());
        reload(entries);
    }

    public void reload(List<Entry> entries) {
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
        Entry m = entries.get(linha);
        switch (coluna) {
            case 0:
                return m.getName();
            case 1:
                return m.getDescription();
            case 2:
                return Entry.convertPriceToString(m.getPrice());
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

    public Entry getMercadoriaAt(int index) {
        return entries.get(index);
    }

}
