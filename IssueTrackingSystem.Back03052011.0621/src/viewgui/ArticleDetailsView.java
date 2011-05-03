package viewgui;

import appclasses.Article;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author iXeon
 */
public class ArticleDetailsView extends JPanel {
    private JLabel detailsLabel;
    
    public ArticleDetailsView() {
        super();
        initArticleDetailsView();
    }

    private void initArticleDetailsView() {
        detailsLabel = new JLabel();
        detailsLabel.setText("Details Here");
        setLayout(new GridLayout(1, 1));
        add(detailsLabel);
    }

    public void displayArticleDetails(Article article){
        detailsLabel.setText(article.getSolution());
    }
}