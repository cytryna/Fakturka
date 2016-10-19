package br.com.yaw.ssjpac.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import diligentia.entity.Product;

/**
 * Define um TableModel para entidade <code>Product</code>, considerando as colunas:
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

	private List<Product> entries;
	
	private String[] colNomes = { "Nome", "Descricao", "Preco", "Quantidade" };
	
	private Class<?>[] colTipos = { String.class, String.class, String.class, Integer.class };
	
	public MercadoriaTableModel(){}
	
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
		return false;
	}
	
	public Product getMercadoriaAt(int index) {
		return entries.get(index);
	}
	
}
