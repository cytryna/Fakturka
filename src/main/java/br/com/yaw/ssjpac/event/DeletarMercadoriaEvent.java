package br.com.yaw.ssjpac.event;

import br.com.yaw.ssjpac.model.Article;

/**
 * Evento deve ser gerado durante a exclusão de uma <code>Article</code>.
 * 
 * <p>Recebe a referência da <code>Article</code> que foi removida.</p>
 * 
 * @author YaW Tecnologia
 */
public class DeletarMercadoriaEvent extends AbstractEvent<Article> {
	
	public DeletarMercadoriaEvent(Article m) {
		super(m);
	}

}
