package viewgui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CloseOrNot extends JFrame {

    JTextField field1;
    JPanel panel;

    public CloseOrNot() {
        super("CloseOrNot Frame");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        panel = new JPanel();
        field1 = new JTextField(10);
        panel.add(new JLabel("type yes to close the Frame "));
        panel.add(field1);
        getContentPane().add("Center", panel);
        addWindowListener(new WindowAdapter() {

            public void windowOpened(WindowEvent e) {
                field1.requestFocus();
            }

            public void windowClosing(WindowEvent e) {
                if (field1.getText().equals("yes")) {
                    if (JOptionPane.showConfirmDialog(null, "Are you sure ?") == JOptionPane.YES_OPTION) {
                        setVisible(false);
                        dispose();
                    }
                }
            }
        });
        pack();
        setVisible(true);
    }

    public static void main(String args[]) {
        new CloseOrNot();
    }
}
