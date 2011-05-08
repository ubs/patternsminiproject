package viewgui;

import controller.AppController;
import appclasses.IDebug;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

/**
 * Main Application GUI Frame
 * @author iXeon
 */
public class MainAppFrame extends JFrame implements ActionListener {
    private static final long serialVersionUID = 6662L;

    private String appTitle = "Issue Tracking System, Knowledge Base Management";

    //Domain Controller Reference - Facade Controller (Pure Fabrication)
    private AppController appController;

    //GUI Variables Here
    private WindowAction windowAction;

    //Add/Edit Variables
    protected String ACTION_COMMAND_ADD = "ADD";
    protected String ACTION_COMMAND_EDIT = "EDIT";

    //GUI App code begins
    public MainAppFrame() {
        appController = null;
        launchGUI();
    }
    
    public MainAppFrame(AppController appCtrl) {
        appController = appCtrl;
        appController.loadModels();
        launchGUI();
    }

    private void launchGUI(){
        initGUIComponents();

        /** Constructor - create a panel and add it on the frame */
        setTitle( appTitle );
        
        pack();
        setSize(800, 500);
        setVisible(rootPaneCheckingEnabled);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener( windowAction = new WindowAction());
    }

    private void initGUIComponents(){
        initMainMenuBar();
        initDefaultView();
    }

    private void initMainMenuBar(){
        setJMenuBar(new MainMenuBar(this));
    }

    protected void initDefaultView(){
        //@TODO: For now default view is article lists, make into a config setting
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(new PanelViewKnowledgeBase(), BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        IDebug.print("<|Action MainAppView|>" + " Action Command: " + e.getActionCommand() +  " getClass: " +
                e.getClass() +  " getID: " + e.getID() +  " paramString: " + e.paramString() +
                " getSource: " + e.getSource() );

        if (actionCommand.equalsIgnoreCase(MenuConstants.CMD_VIEW_ARTICLES)){
            //
        }

        else if (actionCommand.equalsIgnoreCase(MenuConstants.CMD_ADD_ARTICLES)){
            new ArticleEditDialog(this, ACTION_COMMAND_ADD);
        }

        else if (actionCommand.equalsIgnoreCase(MenuConstants.CMD_SAVE_MODEL)){
            //
        }

        else if (actionCommand.equalsIgnoreCase(MenuConstants.CMD_MANAGE_CATEGORIES)){
            //
        }

        else if (actionCommand.equalsIgnoreCase(MenuConstants.CMD_MANAGE_CONFIGURATION)){
            //
        }

        else if (actionCommand.equalsIgnoreCase(MenuConstants.CMD_ABOUT_IST)){
            JOptionPane.showMessageDialog(this,
                    "Issue Tracking System \nKnowledge Base Management" +
                    "\nBy UDOISANG Blessing Sunday (7588349 - ACS&ITM)",
                    appTitle, JOptionPane.INFORMATION_MESSAGE);
        }

        else if (actionCommand.equalsIgnoreCase(MenuConstants.CMD_EXIT)){
            windowAction.windowClosing(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }

    /** Window events inner class */
    private class WindowAction extends WindowAdapter{
        @Override
        public void windowOpened(WindowEvent e) {
            //Inits on focus?
        }

        @Override
        public void windowClosing(WindowEvent e){
            IDebug.print(this.getClass() + ": About to close Application from WindowClosing Method");
            if (JOptionPane.showConfirmDialog(
                    null, "Are you sure you want to quit the KnowledgeBase System?",
                    "Quit IST KnowledgeBase System", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                setVisible(false);
                dispose();
                System.exit(0);
            }
        }
    }
}