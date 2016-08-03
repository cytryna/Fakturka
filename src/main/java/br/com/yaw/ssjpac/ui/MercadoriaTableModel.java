package br.com.yaw.ssjpac.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.yaw.ssjpac.model.Article;

/**
 * Define um TableModel para entidade <code>Article</code>, considerando as colunas:
 * <ul>
 *   <li>Nome;</li>
 *   <li>Descrição;</li>
 *   <li>Preço;</li>
 *   <li>Quantidade;</li>
 * </ul> 
 * 
 * @author YaW Tecnologia
 */
public class MercadoriaTableModel extends AbstractTableModel {

	private List<Article> articles;
	
	private String[] colNomes = { "Nome", "Descricao", "Preco", "Quantidade" };
	
	private Class<?>[] colTipos = { String.class, String.class, String.class, Integer.class };
	
	public MercadoriaTableModel(){}
	
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
			return Article.convertPrecoToString(m.getPreco());
		case 3:
			return m.getQuantidade();
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
