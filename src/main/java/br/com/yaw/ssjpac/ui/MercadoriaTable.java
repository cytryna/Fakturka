package br.com.yaw.ssjpac.ui;

import java.util.List;

import javax.swing.JTable;

import br.com.yaw.ssjpac.model.Article;

/**
 * <code>JTable</code> com operações customizadas para entidade <code>Article</code>.
 * 
 * @see br.com.yaw.sjc.ui.MercadoriaTableModel
 * 
 * @author YaW Tecnologia
 */
public class MercadoriaTable extends JTable {

	private MercadoriaTableModel modelo;
	
	public MercadoriaTable() {
		modelo = new MercadoriaTableModel();
		setModel(modelo);
	}
	
	/**
	 * @return <code>Article</code> selecionada na tabela. Caso a tabela não tenha elementos, retorna <code>null</code>.
	 */
	public Article getMercadoriaSelected() {
		int i = getSelectedRow();
		if (i < 0) {
			return null;
		}
		return modelo.getMercadoriaAt(i);
	}
	
	/**
	 * Recarrega a tabela de <code>Article</code> com a lista <code>articles</code>.
	 * @param articles <code>List</code> com os elementos <code>Article</code> que devem ser exibidos na tabela.
	 */
	public void reload(List<Article> articles) {
		modelo.reload(articles);
	}
}
