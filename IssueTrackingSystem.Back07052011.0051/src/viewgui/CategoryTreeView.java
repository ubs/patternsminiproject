package viewgui;

import appclasses.Category;
import appclasses.CategoryModel;
import appclasses.IDebug;
import appclasses.IObservable;
import appclasses.IObserver;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author iXeon
 */
public class CategoryTreeView extends JPanel implements TreeSelectionListener, IObservable {
    private Category rootCategory;
    private Category selectedCategory;

    private JScrollPane jScrollPane;
    private JTree categoryTree;
    private DefaultMutableTreeNode treeRoot;

    public CategoryTreeView() {
        super();
        initCategoryTreeView();
    }

    private void initCategoryTreeView() {        
        getRootCategory();

        setLayout(new BorderLayout());
        //setBorder(new BevelBorder(BevelBorder.RAISED));

        jScrollPane = new JScrollPane();
        add(jScrollPane, BorderLayout.CENTER);
        
        treeRoot = new DefaultMutableTreeNode(rootCategory.getCatName());
        categoryTree = new JTree(treeRoot);
        categoryTree.setBackground(Color.lightGray);
        loadTree(rootCategory);

        jScrollPane.getViewport().add(categoryTree); //Put the Tree in a scroller
        jScrollPane.setPreferredSize(new Dimension(250, jScrollPane.getPreferredSize().height));
        setSize(jScrollPane.getPreferredSize().width, jScrollPane.getPreferredSize().height);
    }

    protected void getRootCategory() {
        rootCategory = CategoryModel.getInstance().getRootCategory();
    }

    //Load Tree------------------------------------
    public void loadTree(Category topCat) {
        DefaultMutableTreeNode newTreeRoot;
        newTreeRoot = new DefaultMutableTreeNode(topCat.getCatName());
        remove(categoryTree);
        
        categoryTree = new JTree(newTreeRoot);
        categoryTree.addTreeSelectionListener(this);
        jScrollPane.getViewport().add(categoryTree);

        addNodes(newTreeRoot, topCat);
        categoryTree.expandRow(0);
        repaint();
    }

    //Add Nodes--------------------------------------
    private void addNodes(DefaultMutableTreeNode pnode, Category cat) {
        DefaultMutableTreeNode node;

        Iterator itr = cat.getSubCategoriesIterator();

        while (itr.hasNext()) {
            Category newCat = (Category) itr.next();
            node = new DefaultMutableTreeNode(newCat.getCatName());
            pnode.add(node);
            addNodes(node, newCat);
        }
    }

    @Override //From Tree Selection Listener
    public void valueChanged(TreeSelectionEvent evt) {
        TreePath path = evt.getPath();
        String selectedTerm = path.getLastPathComponent().toString();

        IDebug.print(selectedTerm);
        Category cat = rootCategory.getSubCategory(selectedTerm);
        if (cat != null) {
            selectedCategory = cat;
            notifyObservers();
            //lblCatID.setText(cat.getCatID() + " #Sub Cats: " + cat.countSubCategories());
        }
    }

    //Getters and Setters
    public Category getSelectedCategory() {
        return selectedCategory;
    }

    //Observable Implementation
    //@PATTERN Observer
    //@OBSERVED_STATE: selectedCategory
    private ArrayList<IObserver> observers = new ArrayList<IObserver>();

    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        //Iterate through and notify each observer
        Iterator<IObserver> itr = observers.iterator();
        while( itr.hasNext() ) {
            IObserver iObserver = itr.next();
            iObserver.observableUpdate(this);
        }
    }
}