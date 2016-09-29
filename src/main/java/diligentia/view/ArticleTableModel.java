package diligentia.view;

import sandobox.javacodegeeks.Constants;

import javax.swing.table.DefaultTableModel;

/**
 * Created by rwichrowski on 29.09.16.
 */
public class ArticleTableModel extends DefaultTableModel {

    public ArticleTableModel() {
        super(Constants.DATA, Constants.TABLE_HEADER);
    }

}
