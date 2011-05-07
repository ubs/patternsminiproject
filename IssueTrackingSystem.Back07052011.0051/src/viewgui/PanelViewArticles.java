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
    protected CategoryInfoView catInfoView;
    protected ArticlesView articlesView;
    protected ArticleDetailsView articleDetailsView;

    //GUI Split Panes
    JSplitPane splitPaneCategoryArticles, splitPaneCategoryTreeCategoryInfo;

    public PanelViewArticles() {
        initPanelViewArticles();
    }

    private void initPanelViewArticles() {
        catTreeView = new CategoryTreeView();
        catInfoView = new CategoryInfoView();
        articlesView = new ArticlesView();
        addObserversToCategoryTreeView();

        setupCategoryTreeAndInfoSplit();
        setupMainSplitPane();

        setLayout(new BorderLayout());
        add(splitPaneCategoryArticles, BorderLayout.CENTER);
    }

    private void addObserversToCategoryTreeView() {
        //@TODO: Add Observers to Category Tree View, Consider Refactoring
        catTreeView.addObserver(articlesView);
        catTreeView.addObserver(catInfoView);
    }

    private void setupMainSplitPane() {
        //JSplitPane Category, Articles: Main Split
        splitPaneCategoryArticles = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPaneCategoryArticles.setContinuousLayout(true);
        splitPaneCategoryArticles.setOneTouchExpandable(true);
        splitPaneCategoryArticles.setLeftComponent(splitPaneCategoryTreeCategoryInfo);
        splitPaneCategoryArticles.setRightComponent(articlesView);
    }

    private void setupCategoryTreeAndInfoSplit() {
        //JSplitPane CategoryTree, CategoryInfo: SubSplit
        splitPaneCategoryTreeCategoryInfo = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPaneCategoryTreeCategoryInfo.setContinuousLayout(true);
        splitPaneCategoryTreeCategoryInfo.setOneTouchExpandable(true);
        splitPaneCategoryTreeCategoryInfo.setTopComponent(catTreeView);
        splitPaneCategoryTreeCategoryInfo.setBottomComponent(catInfoView);
        catTreeView.setMinimumSize(new Dimension(catTreeView.getWidth(), 300));
        //catInfoView.setPreferredSize(new Dimension(catInfoView.getWidth(), 300));
    }
}