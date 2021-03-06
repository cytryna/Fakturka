package br.com.yaw.ssjpac.controller;

import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;

import diligentia.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.yaw.ssjpac.action.AbstractAction;
import br.com.yaw.ssjpac.action.BooleanExpression;
import br.com.yaw.ssjpac.action.ConditionalAction;
import br.com.yaw.ssjpac.dao.ArticleDAO;
import br.com.yaw.ssjpac.event.DeletarMercadoriaEvent;
import br.com.yaw.ssjpac.event.IncluirMercadoriaEvent;
import br.com.yaw.ssjpac.ui.IncluirMercadoriaFrame;
import br.com.yaw.ssjpac.validation.Validator;

/**
 * Define a <code>Controller</code> responsável por gerir a tela de inclusão/edição de <code>Product</code>.
 * 
 * <p>
 *  <code>IncludeArticleController</code> é mapeada como <code>@Component</code> do Spring.
 *  Dessa forma uma instância de <code>IncludeArticleController</code> pode ser criada e gerenciada
 *  pelo Spring, favorecendo a Inversão de Controle <i>(IoC)</i> e Injeção de Dependência <i>(DI)</i>.
 * </p>
 * 
 * <p>
 *  Essa <code>Controller</code> depende de outros componentes da camada <code>Model</code> (DAO) e <code>View</code> (telas).
 *  As dependências são resolvidas pelo Spring, através da <strong>Injeção de Dependência</strong> c/ a anotação <code>@Autowired</code>.
 * </p>
 * 
 *
 * @author YaW Tecnologia
 */
@Component
public class IncludeArticleController extends AbstractController {

	@Autowired
	private IncluirMercadoriaFrame frame;
	
	@Autowired
	private Validator<Product> validador;
	
	@Autowired
	private ArticleDAO dao;
	
	@Autowired
	public IncludeArticleController(ListArticleController parent) {
		super(parent);
	}

	/**
	 * Método executado pelo <code>Spring</code>, depois de criar a instância de <code>IncludeArticleController</code>.
	 * 
	 * <p>Faz o registro das ações.</p>
	 */
	@PostConstruct
	private void init() {
		frame.addWindowListener(this);
		registerAction(frame.getCancelarButton(), new AbstractAction() {
			public void action() {
				cleanUp();
			}
		});
		
		registerAction(frame.getSalvarButton(), 
			ConditionalAction.build()
				.addConditional(new BooleanExpression() {
					
					public boolean conditional() {
						Product m = frame.getMercadoria();
						String msg = validador.validate(m);
						if (!"".equals(msg == null ? "" : msg)) {
							JOptionPane.showMessageDialog(frame, msg, "Validação", JOptionPane.INFORMATION_MESSAGE);
							return false;
						}
						return true;
					}
				})
				.addAction(new AbstractAction() {
						private Product m;
						
						@Transactional
						@Override
						protected void action() {
							m = frame.getMercadoria();
							dao.save(m);
						}
						
						@Override
						public void posAction() {
							cleanUp();
							fireEvent(new IncluirMercadoriaEvent(m));
							m = null;
						}
					}));
		
		registerAction(frame.getExcluirButton(), 
			new AbstractAction() {
				private Product m;
					
				@Transactional
				@Override
				protected void action() {
					m = frame.getMercadoria();
					Integer id = frame.getMercadoriaId();
					if (id != null) {
						dao.delete(id);
					}
				}
				
				public void posAction() {
					cleanUp();
					fireEvent(new DeletarMercadoriaEvent(m));
					m = null;
				}
			});
	}
	
	public void show() {
		frame.setTitle("Incluir Product");
		frame.setVisible(true);
	}
	
	public void show(Product m) {
		frame.setMercadoria(m);
		frame.setTitle("Editar Product");
		frame.setVisible(true);
	}
	
	@Override
	protected void cleanUp() {
		frame.setVisible(false);
		frame.resetForm();
		
		super.cleanUp();
	}
	
}
