package viewgui;

import appclasses.ArticleModel;
import appclasses.Category;
import appclasses.IDebug;
import appclasses.IObservable;
import appclasses.IObserver;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
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

    private String TITLE_STRING = "Articles List";
    private String DEFAULT_NO_ARTICLES_STRING = "No Articles Listed, Select a Category to List Articles";
    private String DEFAULT_NO_ARTICLES_FOUND_STRING = "No Articles found for the selected category";

    private boolean ARTICLE_LISTING_ATTEMPTED = false;

    public ArticlesView() {
        super();
        initArticleListView();
    }

    private void initArticleListView() {
        String defaultNoArticles[] = {DEFAULT_NO_ARTICLES_STRING};
        jListModel = new DefaultListModel();
        articlesList = new JList(jListModel);

        //articlesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        populateJListModel(defaultNoArticles);
        
        //Set up panels
        setupArticlesListPanel();
        setupArticlesDetailsPanel();
        setupSplitPanels();

        setLayout(new GridLayout(1, 1));
        //Constraints x = new Constraints(2, 2, 34, 45);
        add(splitPaneArtListArtDetails);
        setBorder(new BevelBorder(BevelBorder.RAISED));
    }

    private void setupArticlesListPanel(){
        initTitleLabel();
        panelArticlesList = new JPanel();
        panelArticlesList.setLayout(new GridLayout(2, 1));
        panelArticlesList.setMinimumSize(new Dimension(panelArticlesList.getWidth(), 200));
        panelArticlesList.add(titleLabel);
        panelArticlesList.add(articlesList);
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
        titleLabel = new JLabel(TITLE_STRING);
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

    //ListSelecetionListener Interface Methods
    public void valueChanged(ListSelectionEvent e) {
        IDebug.print("List Selection Event Encountered");
        JOptionPane.showMessageDialog(this, "Selection Listener", "Message Title", JOptionPane.INFORMATION_MESSAGE);
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