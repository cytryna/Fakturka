package br.com.yaw.ssjpac.ui;

import java.awt.event.ActionEvent;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.KeyStroke;

import br.com.yaw.ssjpac.action.AbstractAction;

public class MenuF1 extends JMenu {

	public MenuF1(String title) {
		super(title);
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"),
			"click");
	}

	public void addListener(final AbstractAction action) {
		this.getActionMap().put("click", new javax.swing.AbstractAction() {

			public void actionPerformed(ActionEvent e) {
				action.actionPerformed();
			}
		});
	}

}
