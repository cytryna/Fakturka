package br.com.yaw.ssjpac.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import diligentia.model.Entry;
import org.springframework.stereotype.Component;


@Component
public class IncluirMercadoriaFrame extends JFrame {

	private JTextField tfNome;
	private JFormattedTextField tfQuantidade;
	private JTextField tfDescricao;
	private JTextField tfPreco;
	private JFormattedTextField tfId;

	
	private JButton bSalvar;
	private JButton bCancelar;
	private JButton bExcluir;
	
	public IncluirMercadoriaFrame() {
		setSize(300,250);
		setLocationRelativeTo(null);
		setResizable(false);
		inicializaComponentes();
		resetForm();
	}
	
	private void inicializaComponentes() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(montaPanelEditarMercadoria(), BorderLayout.CENTER);
		panel.add(montaPanelBotoesEditar(), BorderLayout.SOUTH);
		add(panel);
		
		GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
	}
	
	private JPanel montaPanelBotoesEditar() {
		JPanel panel = new JPanel();

		bSalvar = new JButton("Salvar");
		bSalvar.setActionCommand("salvarIncluirMercadoriaAction");
		bSalvar.setMnemonic(KeyEvent.VK_S);
		panel.add(bSalvar);

		bCancelar = new JButton("Cancelar");
		bCancelar.setActionCommand("cancelarIncluirMercadoriaAction");
		bCancelar.setMnemonic(KeyEvent.VK_C);
		panel.add(bCancelar);
		
		bExcluir = new JButton("Excluir");
		bExcluir.setActionCommand("excluirMercadoriaAction");
		bExcluir.setMnemonic(KeyEvent.VK_E);
		panel.add(bExcluir);

		return panel;
	}

	private JPanel montaPanelEditarMercadoria() {
		JPanel painel = new JPanel();
		GridLayout layout = new GridLayout(8, 1);
		painel.setLayout(layout);
		
		tfNome = new JTextField();
		tfDescricao = new JTextField();
		tfPreco = new JTextField();
		tfQuantidade = new JFormattedTextField();
		tfQuantidade.setValue(new Integer(1));
		tfId = new JFormattedTextField();
		tfId.setValue(new Integer(0));
		tfId.setEnabled(false);


		painel.add(new JLabel("Nome:"));
		painel.add(tfNome);
		painel.add(new JLabel("Descrição:"));
		painel.add(tfDescricao);
		painel.add(new JLabel("Preço:"));
		painel.add(tfPreco);
		painel.add(new JLabel("Quantidade:"));
		painel.add(tfQuantidade);
		painel.add(new JLabel("Id: "));
		painel.add(tfId);

		return painel;
	}
	
	private Entry loadMercadoriaFromPanel() {
		String nome = null;
		if (!tfNome.getText().trim().isEmpty()) {
			nome = tfNome.getText().trim();
		}
		
		String descricao = null;
		if (!tfDescricao.getText().trim().isEmpty()) {
			descricao = tfDescricao.getText().trim();
		}
		
		Integer amount = null;
		try {
			if (!tfQuantidade.getText().trim().isEmpty())
			amount = Integer.valueOf(tfQuantidade.getText());
		} catch (NumberFormatException nex) {
			throw new RuntimeException("Erro durante a conversão do campo amount (Integer).\nConteudo inválido!");
		}
		
		Double preco = null;
		try {
			if (!tfPreco.getText().trim().isEmpty()) {
				preco = Entry.formatStringToPreco(tfPreco.getText());
			}
		} catch (ParseException nex) {
			throw new RuntimeException("Erro durante a conversão do campo preço (Double).\nConteudo inválido!");
		}
		
		Integer id = null;
		try {
			id = Integer.parseInt(tfId.getText());
		} catch (Exception nex) {}
		
		Integer version = null;

		return new Entry(id, nome, descricao, amount, preco, version);
	}
	
	public void resetForm() {
		tfId.setValue(null);
		tfNome.setText("");
		tfDescricao.setText("");
		tfPreco.setText("");
		tfQuantidade.setValue(new Integer(1));
		bExcluir.setVisible(false);
	}
	
	private void populaTextFields(Entry m){
		tfId.setValue(m.getId());
		tfNome.setText(m.getName());
		tfDescricao.setText(m.getDescription());
		tfQuantidade.setValue(m.getAmount());
		tfPreco.setText(m.getPriceFormatted());
	}
	
	/**
	 * Limpa e carrega os campos da tela de acordo com objeto <code>Entry</code>.
	 * @param m referência da <code>Entry</code> que deve ser apresentada na tela.
	 */
	public void setMercadoria(Entry m){
		resetForm();
		if (m != null) {
			populaTextFields(m);
			bExcluir.setVisible(true);
		}
	}
	
	/**
	 * @return uma nova instância de <code>Entry</code> com os dados preenchidos do campos na tela.
	 */
	public Entry getMercadoria() {
		return loadMercadoriaFromPanel();
	}
	
	/**
	 * @return o identificador da <code>Entry</code> em edição. Retorna <code>null</code> em modo de inclusão.
	 */
	public Integer getMercadoriaId() {
		try {
			return Integer.parseInt(tfId.getText());
		} catch (Exception nex) {
			return null;
		}
	}
	
	public JButton getSalvarButton() {
		return bSalvar;
	}
	
	public JButton getCancelarButton() {
		return bCancelar;
	}
	
	public JButton getExcluirButton() {
		return bExcluir;
	}

}
