package br.com.yaw.ssjpac.ui;

import java.util.List;

import javax.swing.JTable;

import diligentia.model.Entry;


public class MercadoriaTable extends JTable {

	private MercadoriaTableModel modelo;
	
	public MercadoriaTable() {
		modelo = new MercadoriaTableModel();
		setModel(modelo);
	}
	
	public Entry getMercadoriaSelected() {
		int i = getSelectedRow();
		if (i < 0) {
			return null;
		}
		return modelo.getMercadoriaAt(i);
	}
	
	public void reload(List<Entry> entries) {
		modelo.reload(entries);
	}
}
