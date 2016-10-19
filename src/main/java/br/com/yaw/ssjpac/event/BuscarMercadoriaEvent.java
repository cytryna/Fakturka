package br.com.yaw.ssjpac.event;

import java.util.List;

import diligentia.entity.Product;

/**
 * Evento deve ser gerado durante a pesquisa de mercadorias.
 * 
 * <p>
 *  Recebe um <code>List</code> com a(s) <code>Product<code>(s) encontrada(s).
 * </p>
 * 
 * @author YaW Tecnologia
 */
public class BuscarMercadoriaEvent extends AbstractEvent<List<Product>> {
	
	public BuscarMercadoriaEvent(List<Product> m) {
		super(m);
	}

}
