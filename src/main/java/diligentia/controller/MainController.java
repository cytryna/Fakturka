package diligentia.controller;

import br.com.yaw.ssjpac.ui.ListArticleFrame;
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

    @PostConstruct
    private void init() {
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setSize(new Dimension(1200, 800));
        frame.setVisible(true);
    }

}
