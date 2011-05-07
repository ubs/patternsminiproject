package sandbox;

import controller.AppController;
import viewgui.MainAppFrame;

/**
 *
 * @author iXeon
 */
public class TryGUI {

    public TryGUI() {
    }

    public static void main(String[] args){
        //TryGUI tryGUI =  new TryGUI();
        new TryGUI().testRunGUI();
    }

    public void testRunGUI(){
        new MainAppFrame(new AppController());
    }
}
