package br.com.yaw.ssjpac.event;

import diligentia.model.Article;

/**
 * Evento deve ser gerado durante a inclusão de uma <code>Article</code>.
 * 
 * <p>Recebe a referência da <code>Article</code> que foi incluida.</p>
 * 
 * @author YaW Tecnologia
 */
public class IncluirMercadoriaEvent extends AbstractEvent<Article> {
	
	public IncluirMercadoriaEvent(Article m) {
		super(m);
	}
}
