package sandobox.stackoverflow;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * Created by rwichrowski on 23.09.16.
 */
public class SearchPersonAction extends AbstractAction {

    private static final long serialVersionUID = 4083406832930707444L;

    private Document searchInput;
    private DefaultListModel searchResult;
    private PersonService personService;

    public SearchPersonAction(Document searchInput,
                              DefaultListModel searchResult, PersonService personService) {
        this.searchInput = searchInput;
        this.searchResult = searchResult;
        this.personService = personService;
    }

    public void actionPerformed(ActionEvent e) {
        String searchString = getSearchString();

        List<Person> matchedPersons = personService.searchPersons(searchString);

        searchResult.clear();
        for (Person person : matchedPersons) {
            Object elementModel = new PersonElementModel(person);
            searchResult.addElement(elementModel);
        }
    }

    private String getSearchString() {
        try {
            return searchInput.getText(0, searchInput.getLength());
        } catch (BadLocationException e) {
            return null;
        }
    }

}