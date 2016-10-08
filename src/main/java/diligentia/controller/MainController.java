package diligentia.controller;

import br.com.yaw.ssjpac.ui.ListArticleFrame;
import diligentia.dao.ArticleDAO;
import diligentia.dao.CompanyRepository;
import diligentia.model.Article;
import diligentia.view.MainFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

@Component
public class MainController {

    List<Article> articles = new ArrayList<>();


    @Autowired
    private MainFrame frame;

//    @Autowired
//    private CompanyRepository companyRepository;Rozkminić dlaczego nie mogę tego wtrzyknąć

    @PostConstruct
    private void init() {


//        frame.refreshTable(articleDAO.findAll());
        articles.add(new Article(1, "Silnik", "opis", 3, 3.0, 2));
        articles.add(new Article(2, "Alternator", "opis", 4, 4.0, 4));

        frame.refreshTable(articles);

        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setSize(new Dimension(1200, 800));
        frame.setVisible(true);
    }



    private void refreshTable() {
//        this.frame.refreshTable(this.articleDAO.findAll());
        articles.add(new Article(1, "Silnik", "opis", 3, 3.0, 2));
        articles.add(new Article(2, "Alternator", "opis", 4, 4.0, 4));
        frame.refreshTable(articles);

    }

}
