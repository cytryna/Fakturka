package br.com.yaw.ssjpac.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.SwingUtilities;

import diligentia.model.Article;
import br.com.yaw.ssjpac.ui.ListArticleFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.yaw.ssjpac.action.AbstractAction;
import br.com.yaw.ssjpac.dao.ArticleDAO;
import br.com.yaw.ssjpac.event.AbstractEventListener;
import br.com.yaw.ssjpac.event.RefreshListEventArticle;
import br.com.yaw.ssjpac.event.BuscarMercadoriaEvent;
import br.com.yaw.ssjpac.event.DeletarMercadoriaEvent;
import br.com.yaw.ssjpac.event.IncluirMercadoriaEvent;
import br.com.yaw.ssjpac.ui.AboutFrame;

@Component
public class ListArticleController extends AbstractController {

	@Autowired
	private ListArticleFrame frame;
	
	@Autowired
	private AboutFrame aboutFrame;
	
	@Autowired
	private IncludeArticleController includeArticleController;

	@Autowired
	private SearchArticleController searchArticleController;
	
	@Autowired
	private ArticleDAO articleDAO;
	

//	@PostConstruct
	private void init() {
		this.frame.addWindowListener(this);
		
		registerAction(frame.getNewButton(), new AbstractAction() {
			public void action() {
				includeArticleController.show();
			}
		});
		
		registerAction(frame.getRefreshButton(), new AbstractAction() {
			public void action() {
				fireEvent(new RefreshListEventArticle());
			}
		});
		
		registerAction(frame.getFindButton(), new AbstractAction() {
			public void action() {
				searchArticleController.show();
			}
		});
		
		AbstractAction actionSobre = new AbstractAction() {
			@Override
			protected void action() {
				aboutFrame.setVisible(true);
			}
		};
		registerAction(frame.getMenuSobre(), actionSobre);
		this.frame.getMenuAjuda().addListener(actionSobre);
		
		this.frame.getTable().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount() == 2) {
					Article m = frame.getTable().getMercadoriaSelected();
					if (m != null) {
						includeArticleController.show(m);
					}
				}
			}
		});
		
		registerEventListener(IncluirMercadoriaEvent.class, new AbstractEventListener<IncluirMercadoriaEvent>() {
			public void handleEvent(IncluirMercadoriaEvent event) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						refreshTable();
					}
				});
			}
		});
		
		registerEventListener(DeletarMercadoriaEvent.class, new AbstractEventListener<DeletarMercadoriaEvent>() {
			public void handleEvent(DeletarMercadoriaEvent event) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						refreshTable();
					}
				});
			}
		});
		
		registerEventListener(RefreshListEventArticle.class, new AbstractEventListener<RefreshListEventArticle>() {
			public void handleEvent(RefreshListEventArticle event) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						refreshTable();
					}
				});
			}
		});
		
		registerEventListener(BuscarMercadoriaEvent.class, new AbstractEventListener<BuscarMercadoriaEvent>() {
			public void handleEvent(final BuscarMercadoriaEvent event) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						List<Article> list = event.getTarget();
						if (list != null) {
							frame.refreshTable(list);
						}
					}
				});
			}
		});
		
		this.frame.setVisible(true);
		refreshTable();
	}
	
	private void refreshTable() {
		this.frame.refreshTable(this.articleDAO.findAll());
	}
	
}
