package viewgui;

import appclasses.Article;
import appclasses.ArticleModel;
import appclasses.Category;
import appclasses.IDebug;
import appclasses.IObservable;
import appclasses.IObserver;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Articles List and Details
 * @author iXeon
 */
public class ArticlesView extends JPanel implements IObserver, ListSelectionListener {
    private JLabel titleLabel;
    private JList articlesList;
    
    //GUI Panels and SplitPanes
    private JPanel panelArticlesList, panelArticlesDetails;
    JSplitPane splitPaneArtListArtDetails;

    private DefaultListModel jListModel;
    private Category currentListedCategory;
    private String currentArticleDisplayedID;

    private String TITLE_STRING = "ARTICLES LIST";
    private String DEFAULT_NO_ARTICLES_STRING = "No Articles Listed, Select a Category to List Articles";
    private String DEFAULT_NO_ARTICLES_FOUND_STRING = "No Articles found for the selected category";

    private boolean ARTICLE_LISTING_ATTEMPTED = false;

    public ArticlesView() {
        super();
        initArticleListView();
    }

    private void initArticleListView() {
        setupArticlesJList();

        //Set up panels
        setupArticlesListPanel();
        setupArticlesDetailsPanel();
        setupSplitPanels();

        setLayout(new GridLayout(1, 1));
        add(splitPaneArtListArtDetails);
        setBorder(new BevelBorder(BevelBorder.RAISED));
    }

    private void setupArticlesJList() {
        String[] defaultNoArticles = {DEFAULT_NO_ARTICLES_STRING};
        jListModel = new DefaultListModel();
        articlesList = new JList(jListModel);
        articlesList.addListSelectionListener(this);
        articlesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        populateJListModel(defaultNoArticles);
    }
    
    private void setupArticlesListPanel(){
        initTitleLabel();
        panelArticlesList = new JPanel();
        
        GroupLayout groupLayout = new GroupLayout(panelArticlesList);
        panelArticlesList.setLayout(groupLayout);

        //Specify automatic gap insertion
        //groupLayout.setAutoCreateGaps(true);
        //groupLayout.setAutoCreateContainerGaps(true);

        //Define the groups
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(articlesList, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        groupLayout.setVerticalGroup(
            groupLayout.createSequentialGroup()
            .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 30, 30)
            .addComponent(articlesList, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
    }

    private void setupArticlesDetailsPanel(){
        panelArticlesDetails = new ArticleDetailsView();
    }

    private void setupSplitPanels(){
        //JSplit Pane Article List, Article Details
        splitPaneArtListArtDetails = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPaneArtListArtDetails.setContinuousLayout(true);
        splitPaneArtListArtDetails.setOneTouchExpandable(true);

        splitPaneArtListArtDetails.setTopComponent(panelArticlesList);
        splitPaneArtListArtDetails.setBottomComponent(panelArticlesDetails);
    }

    private void initTitleLabel(){
        titleLabel = new JLabel(ViewHelper.getSpace(3) + TITLE_STRING);
        titleLabel.setBackground(new Color(204, 204, 255));
        titleLabel.setBorder(BorderFactory.createEtchedBorder());
        titleLabel.setOpaque(true);
    }

    private void clearJListModel(){
        jListModel.clear();
    }

    private void populateJListModel(Object[] items){
        clearJListModel();
        if (items.length <= 0 && ARTICLE_LISTING_ATTEMPTED){
            jListModel.addElement(DEFAULT_NO_ARTICLES_FOUND_STRING);
        }
        else {
            for (Object object : items) {
                jListModel.addElement(object);
            }
        }
    }

    private void listArticlesForCategory(Category currentListedCategory) {
        ARTICLE_LISTING_ATTEMPTED = true;
        populateJListModel(ArticleModel.getInstance().getArticlesByCategoryAsArray(currentListedCategory.getCatID()));
    }

    private void displayArticle(Article article){
        //Call Article Details View to do the job
        //ArticleDetailsView.displayArticleDetails(article);
        //panelArticlesDetails.
        IDebug.print(article.getIssue());
    }

    //ListSelecetionListener Interface Methods
    public void valueChanged(ListSelectionEvent evt) {
        IDebug.print("List Selection Event Encountered");
        
        boolean adjust = evt.getValueIsAdjusting();
        IDebug.print(", Adjusting? " + adjust);
        if (!adjust) {
            JList list = (JList) evt.getSource();
            Object selectedArticle = list.getSelectedValue();
            if (selectedArticle instanceof Article){
                displayArticle((Article)selectedArticle);
            }

            
            /*
            IDebug.print(selectedArticle.toString() + " class: " + selectedArticle.getClass());

            int selections[] = list.getSelectedIndices();
            Object selectionValues[] = list.getSelectedValues();
            for (int i = 0, n = selections.length; i < n; i++) {
                if (i == 0) {
                    System.out.print("  Selections: ");
                }
                IDebug.print(selections[i] + "/" + selectionValues[i] + " ");
            }
            IDebug.print("End of Story");
            */
        }
    }

    //Observer Implementation
    //@PATTERN Observer
    //@OBSERVABLE/SUBJECT: CategoryTreeView
    //@OBSERVED_STATE: selectedCategory
    public void observableUpdate(IObservable observable) {
        CategoryTreeView ctv = (CategoryTreeView)observable;
        currentListedCategory = ctv.getSelectedCategory();

        IDebug.print("Observable in " + getClass() + " Category is: " + currentListedCategory);
        listArticlesForCategory(currentListedCategory);
    }
}