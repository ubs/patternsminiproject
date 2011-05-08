package guiclasses;

import classes.GenericHelper;
import helpdeskmanagerapplication.MainController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import persistence.HardwarePersistenceMapper;
import persistence.SoftwarePersistenceMapper;

public class Gui extends JFrame implements MyObserver {

    public Gui() {
        super("HELPDESK MANAGER APPLICATION");
    }

    public void init() {
        initializeControls();
        initializeButtons();
        setUpGUI();
        MainController.addListenersToSPMHPM(this);

        pack();
        //close the application while exiting
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void initializeControls() {
        jtextName = new JTextField("");
        jtextSerialNumber = new JTextField("");
        jtextAddress = new JTextField("");
        jtextProblemDescription = new JTextField("");
        jtextDate = new JTextField("");
        jtextResolution = new JTextField("");
        jchkHardwareRepair = new JCheckBox("");
        jtextCounter = new JTextField("");
        jtextCounter.setEditable(false);
    }

    private void initializeButtons() {
        btnCreate = new JButton("Create");
        //Setup Button action
        btnCreate.addActionListener(new CreateAction());

        btnEdit = new JButton("Edit");
        btnEdit.addActionListener(new EditAction());

        btnGenerate = new JButton("Generate Report");
        btnGenerate.addActionListener(new GenerateAction());

        btnClear = new JButton("Clear");
        btnClear.addActionListener(new ClearAction());
    }

    private void setUpGUI() {
        // Create the action Buttons
        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(btnCreate);
        p1.add(btnEdit);
        p1.add(btnGenerate);
        p1.add(btnClear);

        // Setting Grid for inputs
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(7, 2));
        p2.add(new JLabel("Serial Number"));
        p2.add(jtextSerialNumber);
        p2.add(new JLabel("Name"));
        p2.add(jtextName);
        p2.add(new JLabel("Address"));
        p2.add(jtextAddress);
        p2.add(new JLabel("Problem Desription"));
        p2.add(jtextProblemDescription);
        p2.add(new JLabel("Date"));
        p2.add(jtextDate);
        p2.add(new JLabel("Resolution"));
        p2.add(jtextResolution);
        p2.add(new JLabel("Hardware Repair"));
        p2.add(jchkHardwareRepair);

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(2, 1));
        p3.add(new JLabel("Ticket Counter"));
        p3.add(jtextCounter);
        p3.add(new JLabel(""));
        p3.setBorder(BorderFactory.createEtchedBorder());

        Container con = getContentPane();
        con.setLayout(new BorderLayout());
        con.add(p1, BorderLayout.NORTH);
        con.add(p2, BorderLayout.SOUTH);
        con.add(p3, BorderLayout.CENTER);

    }

    //OBSERVER PATTERN
    public void update(MyObservable obs) {
        GenericHelper.printout("I am observing, yay...." + obs.getClass());
        jtextCounter.setText( MainController.getTotalTicketsCount() + "" );
    }

    protected class CreateAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String problemDescription, customerName;
            String customerAddress, resolution, serialNumber;
            boolean isHardwareRepair, isHardwareUpgrade;

            problemDescription = jtextProblemDescription.getText();
            customerName = jtextName.getText();
            customerAddress = jtextAddress.getText();
            resolution = jtextResolution.getText();
            serialNumber = jtextSerialNumber.getText();
            isHardwareRepair = jchkHardwareRepair.isSelected();
            isHardwareUpgrade = !isHardwareRepair;

            if (isHardwareRepair == true){
             MainController.implementHardwarePersistence(problemDescription, customerName,
                     customerAddress, resolution, serialNumber, isHardwareRepair, isHardwareUpgrade);
                     GenericHelper.printout("Just created a new hardware ticket via Controller");
            }
 else{
            MainController.implementSoftwarePersistence(problemDescription, customerName, 
                    customerAddress, resolution, serialNumber, isHardwareRepair, isHardwareRepair);
            GenericHelper.printout("Just created a new sofware ticket via Controller");
        }
    }
}
    //  Edit Button
    protected class EditAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JOptionPane.showInputDialog("Enter Ticket ID");
        }
    }

    // Clear Text Field
    protected class ClearAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            jtextProblemDescription.setText("");
            jtextName.setText("");
            jtextAddress.setText("");
            jtextResolution.setText("");
            jtextSerialNumber.setText("");
            jchkHardwareRepair.isSelected();
            jtextDate.setText("");
            jchkHardwareRepair.setSelected(false);
        }
    }

    // Generate Report
    protected class GenerateAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            GuiReport gr = new GuiReport();
            gr.init();

        }
    }
    private JTextField jtextSerialNumber;
    private JTextField jtextName;
    private JTextField jtextAddress;
    private JTextField jtextProblemDescription;
    private JTextField jtextDate;
    private JTextField jtextResolution;
    private JTextField jtextCounter;
    private JCheckBox jchkHardwareRepair;
    private JButton btnCreate;
    private JButton btnEdit;
    private JButton btnGenerate;
    private JButton btnClear;
}
