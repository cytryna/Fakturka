package br.com.yaw.ssjpac.event;

import diligentia.entity.Entry;

/**
 * Evento deve ser gerado durante a exclusão de uma <code>Entry</code>.
 * 
 * <p>Recebe a referência da <code>Entry</code> que foi removida.</p>
 * 
 * @author YaW Tecnologia
 */
public class DeletarMercadoriaEvent extends AbstractEvent<Entry> {
	
	public DeletarMercadoriaEvent(Entry m) {
		super(m);
	}

}
