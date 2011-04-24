package issuetrackingsystem;

import appclasses.IDebug;
import viewgui.MainAppView;

/**
 * Main Class for the Issue Tracking System
 * @author iXeon
 */
public class Main {

    public static void main(String[] args) {
        IDebug.print("Hello IST - Knowledge Based System!");
        MainAppView mainAppView = new MainAppView();
    }
}