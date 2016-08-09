package diligentia.controller;

import br.com.yaw.ssjpac.ui.ListArticleFrame;
import diligentia.view.MainFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.*;

@Component
public class MainController {

    @Autowired
    private MainFrame frame;

    @PostConstruct
    private void init() {
        frame.setSize(new Dimension(600, 200));
        frame.setVisible(true);
    }

}
