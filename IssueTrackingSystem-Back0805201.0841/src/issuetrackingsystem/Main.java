package issuetrackingsystem;

import appclasses.IDebug;
import controller.AppController;
import viewgui.MainAppFrame;

/**
 * Main Class for the Issue Tracking System
 * @author iXeon
 */
public class Main {
    public static void main(String[] args) {
        IDebug.print("Hello... Starting up IST - Knowledge Base System!");
        MainAppFrame mainAppFrame = new MainAppFrame(new AppController());
    }
}