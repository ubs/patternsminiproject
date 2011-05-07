package viewgui;

import appclasses.Article;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 *
 * @author iXeon
 */
public class ArticleDetailsView extends JPanel {
    private JPanel panelArticleDetails;
    private JScrollPane jScrollPane;
    
    private JLabel titleLabel;
    private JTextArea detailsJTextArea;

    private String STR_BRKLINE = "\n";
    private String TITLE_STRING = "ARTICLE DETAILS";
    private String DEFAULT_NO_ARTICLE_DISPLAYED = "Select an article title above to view details here";

    private StringBuilder strBuilder = new StringBuilder();
    
    public ArticleDetailsView() {
        super();
        initArticleDetailsView();
    }

    private void initArticleDetailsView() {
        setupArticlesDetailsPanel();
        setLayout(new GridLayout(1, 1));
        add(panelArticleDetails);
    }

    public void displayArticleDetails(Article article){
        clearStringBuilder();
        strBuilder.append("ISSUE:").append(STR_BRKLINE)
                .append(article.getIssue())
                .append(STR_BRKLINE).append(STR_BRKLINE)
                .append("SOLUTION:").append(STR_BRKLINE)
                .append(article.getSolution());
        
        detailsJTextArea.setText(strBuilder.toString());
    }

    private void clearStringBuilder(){
        strBuilder.delete(0, strBuilder.length());
    }

    //Prepare controls for the display
    private void initDetailsViewControls(){
        titleLabel = new JLabel(ViewHelper.getSpace(3) + TITLE_STRING);
        titleLabel.setBackground(new Color(204, 204, 255));
        titleLabel.setBorder(BorderFactory.createEtchedBorder());
        titleLabel.setOpaque(true);

        detailsJTextArea = new JTextArea(DEFAULT_NO_ARTICLE_DISPLAYED);
        detailsJTextArea.setEditable(false);
        detailsJTextArea.setFont(new Font("Verdana", Font.PLAIN, 12));
        detailsJTextArea.setLineWrap(true);

        //Border used as padding
        Border detailsLabelPaddingBorder = BorderFactory.createEmptyBorder(10,5,10,5);
        detailsJTextArea.setBorder(detailsLabelPaddingBorder);

        //Add a scroll pane to the textarea
        jScrollPane = new JScrollPane();
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.getViewport().add(detailsJTextArea);
        //jScrollPane.setPreferredSize(new Dimension(250, jScrollPane.getPreferredSize().height));
    }

    private void setupArticlesDetailsPanel(){
        initDetailsViewControls();
        panelArticleDetails = new JPanel();

        GroupLayout groupLayout = new GroupLayout(panelArticleDetails);
        panelArticleDetails.setLayout(groupLayout);

        //Specify automatic gap insertion
        //groupLayout.setAutoCreateGaps(true);
        //groupLayout.setAutoCreateContainerGaps(true);

        //Define the groups
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        groupLayout.setVerticalGroup(
            groupLayout.createSequentialGroup()
            .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 30, 30)
            .addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
    }
}