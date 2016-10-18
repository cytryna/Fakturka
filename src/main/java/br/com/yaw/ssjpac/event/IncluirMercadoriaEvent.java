package br.com.yaw.ssjpac.event;

import diligentia.entity.Entry;

/**
 * Evento deve ser gerado durante a inclusão de uma <code>Entry</code>.
 * 
 * <p>Recebe a referência da <code>Entry</code> que foi incluida.</p>
 * 
 * @author YaW Tecnologia
 */
public class IncluirMercadoriaEvent extends AbstractEvent<Entry> {
	
	public IncluirMercadoriaEvent(Entry m) {
		super(m);
	}
}
