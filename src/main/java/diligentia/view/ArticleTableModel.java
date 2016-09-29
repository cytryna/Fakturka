package diligentia.view;

import diligentia.model.Article;
import sandobox.javacodegeeks.Constants;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * Created by rwichrowski on 29.09.16.
 */
public class ArticleTableModel extends AbstractTableModel {

    private List<Article> articles;

    private String[] colNomes =  { "Symbol", "Company Name",
            "Price", "Change", "% Change", "Volume" };

    private Class<?>[] colTipos = { String.class, String.class, String.class, Integer.class };

    public void reload(List<Article> articles) {
        this.articles = articles;
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
        if (articles == null){
            return 0;
        }
        return articles.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Article m = articles.get(linha);
        switch (coluna) {
            case 0:
                return m.getName();
            case 1:
                return m.getDescription();
            case 2:
                return Article.convertPriceToString(m.getPrice());
            case 3:
                return m.getAmount();
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Article getMercadoriaAt(int index) {
        return articles.get(index);
    }

}
