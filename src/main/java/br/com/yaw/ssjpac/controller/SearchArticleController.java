package br.com.yaw.ssjpac.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import diligentia.entity.Entry;
import br.com.yaw.ssjpac.ui.SearchArticleFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.yaw.ssjpac.action.AbstractAction;
import br.com.yaw.ssjpac.dao.ArticleDAO;
import br.com.yaw.ssjpac.event.BuscarMercadoriaEvent;

@Component
public class SearchArticleController extends AbstractController {

	@Autowired
	private SearchArticleFrame frame;
	
	@Autowired
	private ArticleDAO dao;

	@Autowired
	public SearchArticleController(ListArticleController parent) {
		super(parent);
	}
	
	@PostConstruct
	private void init() {
		this.frame.addWindowListener(this);
		
		registerAction(frame.getBuscarButton(), new AbstractAction() {
			private List<Entry> list;
			
			@Override
			public void action() {
				if (frame.getText().length() > 0) {
					list = dao.getArticleByName(frame.getText().concat("%"));
				}
			}
			
			@Override
			public void posAction() {
				cleanUp();
				fireEvent(new BuscarMercadoriaEvent(list));
				list = null;
			}
		});
	}
	
	public void show() {
		frame.setVisible(true);
	}

	@Override
	protected void cleanUp() {
		frame.setVisible(false);
		frame.resetForm();
		
		super.cleanUp();
	}
}
