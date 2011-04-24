package viewgui;

import javax.swing.*;

/**
 *
 * @author iXeon
 */
public class MainAppView extends JFrame {
    private String appTitle = "Issue Tracking System, Knowledge Base Management";

    public MainAppView() {
        initGUIComponents();
        
        /** Constructor - create a panel and add it on the frame */
        setTitle( appTitle );

        //Container c = getContentPane();
        //c.setLayout(new BorderLayout());

        //abp = new AddressBookPanel(this);
        //abt = new AddressBookToolBar(this);

        //c.add(abp, BorderLayout.CENTER);
        //c.add(abt, BorderLayout.NORTH);

        //pack();
        setVisible(rootPaneCheckingEnabled);
        //this.addWindowListener( new WindowAction());
    }

    public void launchGUI(){
        //
    }

    private void initGUIComponents(){
        //Setup the default GUI
        mainGUIPanel = new JPanel();
        initMainMenuBar();
    }

    private void initMainMenuBar(){
        mainMenuBar = new MainMenuBar();
    }

    //GUI Variables Here
    private javax.swing.JPanel mainGUIPanel;
    private javax.swing.JMenuBar mainMenuBar;
}
