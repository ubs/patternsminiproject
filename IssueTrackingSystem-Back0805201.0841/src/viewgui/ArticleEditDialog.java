package viewgui;

import appclasses.Article;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author iXeon
 */
public class ArticleEditDialog extends JDialog {
    //articleID, * articleTitle, articleCatID, *issue, *solution, entryDate, relatedArticles

    protected JLabel lblArticleTitle;
    protected JLabel lblIssueDescription;
    protected JLabel lblResolution;
    
    protected JTextField txtArticleTitle;
    protected JTextArea txtIssueDescription;
    protected JTextArea txtResolution;
    
    protected JButton btnSave;
    protected JButton btnCancel;
    protected String actionCommand;

    private JPanel mainJPanel;
    private String DIALOG_TITLE = "Add/Edit Article";

    public ArticleEditDialog(Component parentComponent, String iCommand) {
        actionCommand = iCommand;
        showArticleEditDialog(parentComponent);
    }

    public ArticleEditDialog(Component parentComponent, String iCommand, Article article) {
        actionCommand = iCommand;
        showArticleEditDialog(parentComponent);
    }

    private void showArticleEditDialog(Component parentComponent) {
        setupControls();
        Container dialogContainer = this.getContentPane();
        dialogContainer.add(mainJPanel);

        setTitle(DIALOG_TITLE);
        setLocationRelativeTo(parentComponent);
        setModalityType(ModalityType.APPLICATION_MODAL);
        pack();
        setVisible(true);
    }

    protected void setupControls(){
        mainJPanel = new JPanel();
        mainJPanel.setLayout(new GridLayout(4, 2));

        lblArticleTitle = new JLabel("Article Title");
        lblIssueDescription = new JLabel("Issue Description");
        lblResolution = new JLabel("Resolution Details");

        txtArticleTitle = new JTextField();
        txtIssueDescription = new JTextArea();
        txtResolution = new JTextArea(3, 5);

        btnCancel = new JButton("Cancel");
        btnSave = new JButton();
        btnSave.setText( actionCommand.equalsIgnoreCase("Add") ? "Add Article" : "Update Article" );

        btnSave.addActionListener(new SetAction(this));
        btnCancel.addActionListener(new CancelAction(this));

        mainJPanel.add(lblArticleTitle);
        mainJPanel.add(txtArticleTitle);
        mainJPanel.add(lblIssueDescription);
        mainJPanel.add(txtIssueDescription);
        mainJPanel.add(lblResolution);
        mainJPanel.add(txtResolution);
        mainJPanel.add(btnSave);
        mainJPanel.add(btnCancel);
    }

    //Preferred size
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 180);
    }

    public Dimension getMinimunSize() {
        return new Dimension(400, 180);
    }

    /**
    Set Action inner class
     */
    protected class SetAction implements ActionListener {
        ArticleEditDialog dialog;
        public SetAction(ArticleEditDialog d) { dialog = d; }
        
        public void actionPerformed(ActionEvent e) {

            dialog.dispose();

            if (actionCommand.equalsIgnoreCase("Add")) {
                //dialog.panel.add();
            } else {
                //dialog.panel.edit();
            }
        }
    }

    protected class CancelAction implements ActionListener {
        ArticleEditDialog dialog;

        public CancelAction(ArticleEditDialog d) { dialog = d; }

        public void actionPerformed(ActionEvent e) {
            dialog.dispose();
        }
    }
}