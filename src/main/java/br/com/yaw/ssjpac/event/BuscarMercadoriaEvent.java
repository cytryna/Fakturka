package br.com.yaw.ssjpac.event;

import java.util.List;

import diligentia.model.Entry;

/**
 * Evento deve ser gerado durante a pesquisa de mercadorias.
 * 
 * <p>
 *  Recebe um <code>List</code> com a(s) <code>Entry<code>(s) encontrada(s).
 * </p>
 * 
 * @author YaW Tecnologia
 */
public class BuscarMercadoriaEvent extends AbstractEvent<List<Entry>> {
	
	public BuscarMercadoriaEvent(List<Entry> m) {
		super(m);
	}

}
