package br.com.yaw.ssjpac.event;

import diligentia.entity.Product;

/**
 * Evento deve ser gerado durante a exclusão de uma <code>Product</code>.
 * 
 * <p>Recebe a referência da <code>Product</code> que foi removida.</p>
 * 
 * @author YaW Tecnologia
 */
public class DeletarMercadoriaEvent extends AbstractEvent<Product> {
	
	public DeletarMercadoriaEvent(Product m) {
		super(m);
	}

}
