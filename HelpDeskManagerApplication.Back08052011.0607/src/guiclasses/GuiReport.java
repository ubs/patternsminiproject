package guiclasses;

import helpdeskmanagerapplication.MainController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GuiReport extends JFrame {
    public GuiReport() {
        super("Report Interface");
    }

    public void init() {
        initializeControls();
        initializeButtons();
        setUpGUI();
        displayReport();

        pack();
        setSize(400, 400);
        //close the application while exiting
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void initializeControls() {
        reportTitleLabel = new JLabel("Report of All Ticket Loggeds");
        reportTitleLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        jtextReport = new JTextArea("");
        jtextReport.setEditable(false);

        jtextScroller = new JScrollPane();
        jtextScroller.getViewport().add(jtextReport);
    }

    private void initializeButtons() {
        btnExit = new JButton("Close Report");
        btnExit.addActionListener(new ExitAction());
    }

    private void setUpGUI() {
        // Create the action Buttons
        JPanel p1 = new JPanel();
        p1.setBorder(BorderFactory.createEtchedBorder());
        
        GroupLayout gl = new GroupLayout(p1);
        p1.setLayout(gl);

        gl.setHorizontalGroup(
           gl.createParallelGroup()
           .addComponent(btnExit)
           .addComponent(reportTitleLabel, 0, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
           .addComponent(jtextScroller, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
        );

        gl.setVerticalGroup(
            gl.createSequentialGroup()
            .addComponent(btnExit)
            .addComponent(reportTitleLabel, GroupLayout.PREFERRED_SIZE, 30, 40)
            .addComponent(jtextScroller, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        Container con = getContentPane();
        con.setLayout(new GridLayout(1, 1));
        con.add(p1);
    }

    private void displayReport() {
        String report2Display = MainController.getReport();
        jtextReport.setText(report2Display);
    }

    protected class CreateReport implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        }
    }

    // Clear Text Field
    protected class ExitAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            dispose();
        }
    }

    private JLabel reportTitleLabel;
    private JTextArea jtextReport;
    private JButton btnExit;
    private JScrollPane jtextScroller;
}