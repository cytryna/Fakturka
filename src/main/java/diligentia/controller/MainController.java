package diligentia.controller;

import br.com.yaw.ssjpac.ui.ListArticleFrame;
import diligentia.dao.ArticleDAO;
import diligentia.view.MainFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class MainController {

    @Autowired
    private MainFrame frame;

    @Autowired
    private ArticleDAO articleDAO;

    @PostConstruct
    private void init() {


        frame.refreshTable(articleDAO.findAll());
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setSize(new Dimension(1200, 800));
        frame.setVisible(true);
    }



    private void refreshTable() {
        this.frame.refreshTable(this.articleDAO.findAll());
    }

}
