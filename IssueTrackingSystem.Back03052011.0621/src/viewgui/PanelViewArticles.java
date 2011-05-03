package viewgui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 * View Articles Panel
 * @author iXeon
 */
public class PanelViewArticles extends JPanel {
    //Sub-components
    protected CategoryTreeView catTreeView;
    protected ArticlesView articlesView;
    protected ArticleDetailsView articleDetailsView;

    //GUI Split Panes
    JSplitPane splitPaneCategoryArticles;

    public PanelViewArticles() {
        initPanelViewArticles();
    }

    private void initPanelViewArticles() {
        catTreeView = new CategoryTreeView();
        articlesView = new ArticlesView();

        //@TODO: Add Observers to Category Tree View, Consider Refactoring
        catTreeView.addObserver(articlesView);

        setupMainSplitPane();

        setLayout(new BorderLayout());
        add(splitPaneCategoryArticles, BorderLayout.CENTER);
    }

    private void setupMainSplitPane() {
        //JSplitPane Category, Articles: Main Split
        splitPaneCategoryArticles = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPaneCategoryArticles.setContinuousLayout(true);
        splitPaneCategoryArticles.setOneTouchExpandable(true);
        splitPaneCategoryArticles.setLeftComponent(catTreeView);
        splitPaneCategoryArticles.setRightComponent(articlesView);
        catTreeView.setMinimumSize(new Dimension(catTreeView.getWidth(), catTreeView.getHeight()));
    }
}