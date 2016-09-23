package sandobox.stackoverflow;


import java.awt.*;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class Main {

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("MVC example");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(640, 300);
        mainFrame.setLocationRelativeTo(null);

        PersonService personService = new PersonServiceMock();

        DefaultListModel searchResultListModel = new DefaultListModel();
        DefaultListSelectionModel searchResultSelectionModel = new DefaultListSelectionModel();
        searchResultSelectionModel
                .setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Document searchInput = new PlainDocument();

        PersonDetailsAction personDetailsAction = new PersonDetailsAction(
                searchResultSelectionModel, searchResultListModel);
        personDetailsAction.putValue(Action.NAME, "Person Details");

        Action searchPersonAction = new SearchPersonAction(searchInput,
                searchResultListModel, personService);
        searchPersonAction.putValue(Action.NAME, "Search");

        Container contentPane = mainFrame.getContentPane();

        JPanel searchInputPanel = new JPanel();
        searchInputPanel.setLayout(new BorderLayout());

        JTextField searchField = new JTextField(searchInput, null, 0);
        searchInputPanel.add(searchField, BorderLayout.CENTER);
        searchField.addActionListener(searchPersonAction);

        JButton searchButton = new JButton(searchPersonAction);
        searchInputPanel.add(searchButton, BorderLayout.EAST);

        JList searchResultList = new JList();
        searchResultList.setModel(searchResultListModel);
        searchResultList.setSelectionModel(searchResultSelectionModel);

        JPanel searchResultPanel = new JPanel();
        searchResultPanel.setLayout(new BorderLayout());
        JScrollPane scrollableSearchResult = new JScrollPane(searchResultList);
        searchResultPanel.add(scrollableSearchResult, BorderLayout.CENTER);

        JPanel selectionOptionsPanel = new JPanel();

        JButton showPersonDetailsButton = new JButton(personDetailsAction);
        selectionOptionsPanel.add(showPersonDetailsButton);

        contentPane.add(searchInputPanel, BorderLayout.NORTH);
        contentPane.add(searchResultPanel, BorderLayout.CENTER);
        contentPane.add(selectionOptionsPanel, BorderLayout.SOUTH);

        mainFrame.setVisible(true);
    }

}





