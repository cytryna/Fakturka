package diligentia.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import diligentia.entity.Company;

/**
 * Created by rwichrowski on 29.09.16.
 */
public class CompanyTableModel extends AbstractTableModel {

    private List<Company> companies;

    private String[] colNomes =  { "Symbol", "Company Name",
            "Price", "Change" };

    private Class<?>[] colTipos = { String.class, String.class, String.class, Integer.class };

    public CompanyTableModel(){}

    public void reload(List<Company> companies) {
        this.companies = companies;
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
        if (companies == null){
            return 0;
        }
        return companies.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Company m = companies.get(linha);
        switch (coluna) {
            case 0:
                return m.getName();
            case 1:
                return m.getName();
            case 2:
                return m.getName();
            case 3:
                return m.getName();
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Company getMercadoriaAt(int index) {
        return companies.get(index);
    }

}
