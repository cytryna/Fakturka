package br.com.yaw.ssjpac.event;

import diligentia.entity.Product;

/**
 * Evento deve ser gerado durante a inclusão de uma <code>Product</code>.
 * 
 * <p>Recebe a referência da <code>Product</code> que foi incluida.</p>
 * 
 * @author YaW Tecnologia
 */
public class IncluirMercadoriaEvent extends AbstractEvent<Product> {
	
	public IncluirMercadoriaEvent(Product m) {
		super(m);
	}
}
