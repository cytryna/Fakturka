package br.com.yaw.ssjpac.ui;

import java.util.List;

import javax.swing.JTable;

import diligentia.entity.Product;


public class MercadoriaTable extends JTable {

	private MercadoriaTableModel modelo;
	
	public MercadoriaTable() {
		modelo = new MercadoriaTableModel();
		setModel(modelo);
	}
	
	public Product getMercadoriaSelected() {
		int i = getSelectedRow();
		if (i < 0) {
			return null;
		}
		return modelo.getMercadoriaAt(i);
	}
	
	public void reload(List<Product> entries) {
		modelo.reload(entries);
	}
}
