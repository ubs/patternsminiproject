package viewgui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Global Menu Bar
 * @author iXeon
 */
public class MainMenuBar extends JMenuBar {

    public MainMenuBar() {
        setName("mainMenuBar");
        initMenuBar();
    }

    private void initMenuBar(){
        //mainMenuBar = new JMenuBar();
        JMenu mnuKnowledgeBase = new JMenu();
        JMenu mnuSettings = new JMenu();
        JMenu mnuHelp = new JMenu();
        JMenu mnuExit = new JMenu();
        
        JMenuItem mnuiViewArticles = new JMenuItem("View Articles");
        JMenuItem mnuiAddArticle = new JMenuItem("Add Article");
        JMenuItem mnuiSaveToStorage = new JMenuItem("Save Model to Storage");
        JMenuItem mnuiCategories = new JMenuItem("Manage Categories");
        JMenuItem mnuiConfig = new JMenuItem("Manage Configuration");
        JMenuItem mnuiAbout = new JMenuItem("About IST");
        JMenuItem mnuiExit = new JMenuItem("Exit");

        mnuKnowledgeBase.setText("Knowledge Base");
        mnuKnowledgeBase.add(mnuiViewArticles);
        mnuKnowledgeBase.add(mnuiAddArticle);
        mnuKnowledgeBase.add(mnuiSaveToStorage);
        mnuKnowledgeBase.add(mnuiExit);

        mnuSettings.setText("Settings");
        mnuSettings.add(mnuiCategories);
        mnuSettings.add(mnuiConfig);

        mnuHelp.setText("Help");
        mnuHelp.add(mnuiAbout);

        mnuExit.setText("Exit");

        add(mnuKnowledgeBase);
        add(mnuSettings);
        add(mnuHelp);
        add(mnuExit);
    }
}