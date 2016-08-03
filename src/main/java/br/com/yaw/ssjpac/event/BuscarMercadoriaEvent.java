package br.com.yaw.ssjpac.event;

import java.util.List;

import br.com.yaw.ssjpac.model.Article;

/**
 * Evento deve ser gerado durante a pesquisa de mercadorias.
 * 
 * <p>
 *  Recebe um <code>List</code> com a(s) <code>Article<code>(s) encontrada(s).
 * </p>
 * 
 * @author YaW Tecnologia
 */
public class BuscarMercadoriaEvent extends AbstractEvent<List<Article>> {
	
	public BuscarMercadoriaEvent(List<Article> m) {
		super(m);
	}

}
