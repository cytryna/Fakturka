package br.com.yaw.ssjpac.ui;

import java.util.List;

import javax.swing.JTable;

import diligentia.model.Article;


public class MercadoriaTable extends JTable {

	private MercadoriaTableModel modelo;
	
	public MercadoriaTable() {
		modelo = new MercadoriaTableModel();
		setModel(modelo);
	}
	
	public Article getMercadoriaSelected() {
		int i = getSelectedRow();
		if (i < 0) {
			return null;
		}
		return modelo.getMercadoriaAt(i);
	}
	
	public void reload(List<Article> articles) {
		modelo.reload(articles);
	}
}
