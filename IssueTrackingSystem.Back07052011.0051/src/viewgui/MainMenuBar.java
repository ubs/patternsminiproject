package viewgui;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

/**
 * Global Menu Bar
 * @author iXeon
 */
public class MainMenuBar extends JMenuBar {

    private static final long serialVersionUID = 6661L;

    protected ActionListener actionListener;

    public MainMenuBar(ActionListener acl) {
        actionListener = acl;
        setName("mainMenuBar");
        initMenuBar();
    }

    private void initMenuBar(){
        //mainMenuBar = new JMenuBar();
        JMenu mnuKnowledgeBase = new JMenu();
        JMenu mnuSettings = new JMenu();
        JMenu mnuHelp = new JMenu();

        mnuKnowledgeBase.setMnemonic(KeyEvent.VK_K);
        mnuSettings.setMnemonic(KeyEvent.VK_T);
        mnuHelp.setMnemonic(KeyEvent.VK_H);
        
        JMenuItem mnuiViewArticles = new JMenuItem(MenuConstants.LBL_VIEW_ARTICLES);
        mnuiViewArticles.setActionCommand(MenuConstants.CMD_VIEW_ARTICLES);
        mnuiViewArticles.addActionListener(actionListener);

        JMenuItem mnuiAddArticle = new JMenuItem(MenuConstants.LBL_ADD_ARTICLES);
        mnuiAddArticle.setActionCommand(MenuConstants.CMD_ADD_ARTICLES);
        mnuiAddArticle.addActionListener(actionListener);

        JMenuItem mnuiSaveToStorage = new JMenuItem(MenuConstants.LBL_SAVE_MODEL);
        mnuiSaveToStorage.setActionCommand(MenuConstants.CMD_SAVE_MODEL);
        mnuiSaveToStorage.addActionListener(actionListener);

        JMenuItem mnuiCategories = new JMenuItem(MenuConstants.LBL_MANAGE_CATEGORIES);
        mnuiCategories.setActionCommand(MenuConstants.CMD_MANAGE_CATEGORIES);
        mnuiCategories.addActionListener(actionListener);

        JMenuItem mnuiConfig = new JMenuItem(MenuConstants.LBL_MANAGE_CONFIGURATION);
        mnuiConfig.setActionCommand(MenuConstants.CMD_MANAGE_CONFIGURATION);
        mnuiConfig.addActionListener(actionListener);

        JMenuItem mnuiAbout = new JMenuItem(MenuConstants.LBL_ABOUT_IST);
        mnuiAbout.setActionCommand(MenuConstants.CMD_ABOUT_IST);
        mnuiAbout.addActionListener(actionListener);

        JMenuItem mnuiExit = new JMenuItem(MenuConstants.LBL_EXIT, KeyEvent.VK_X);
        mnuiExit.setActionCommand(MenuConstants.CMD_EXIT);
        KeyStroke ctrlQKeyStroke = KeyStroke.getKeyStroke("control Q");
        mnuiExit.setAccelerator(ctrlQKeyStroke);
        mnuiExit.addActionListener(actionListener);

        mnuKnowledgeBase.setText(MenuConstants.LBL_KNOWLEDGE_BASE);
        mnuKnowledgeBase.add(mnuiViewArticles);
        mnuKnowledgeBase.add(mnuiAddArticle);
        mnuKnowledgeBase.add(mnuiSaveToStorage);
        mnuKnowledgeBase.add(new JSeparator());
        mnuKnowledgeBase.add(mnuiExit);

        mnuSettings.setText(MenuConstants.LBL_SETTINGS);
        mnuSettings.add(mnuiCategories);
        mnuSettings.add(mnuiConfig);

        mnuHelp.setText(MenuConstants.LBL_HELP);
        mnuHelp.add(mnuiAbout);

        add(mnuKnowledgeBase);
        add(mnuSettings);
        add(mnuHelp);
    }
}