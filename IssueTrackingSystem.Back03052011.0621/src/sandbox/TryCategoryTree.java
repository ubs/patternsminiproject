package sandbox;

import appclasses.Category;
import appclasses.IDebug;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.BevelBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class TryCategoryTree extends JFrame implements TreeSelectionListener {
    private static final long serialVersionUID = 66601L;

    Category categoryBoss, categoryMarketVP, categoryProdVP;
    Category categorySalesMgr, categoryAdvMgr;
    Category categoryProdMgr, categoryShipMgr;
    
    JScrollPane sp;
    JPanel treePanel;
    JTree tree;
    DefaultMutableTreeNode troot;
    JLabel lblCatID;

    public TryCategoryTree() {
        super("Trying out my Composite Category");
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                IDebug.print("[xdebug] Window Closing Event....Closing App");
                System.exit(0);
            }
        });

        makeCategories();
        setGUI();
    }

    //--------------------------------------
    private void setGUI() {
        treePanel = new JPanel();
        getContentPane().add(treePanel);
        treePanel.setLayout(new BorderLayout());

        sp = new JScrollPane();
        treePanel.add("Center", sp);
        treePanel.add("South", lblCatID = new JLabel("Status Info Here:          "));

        treePanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        troot = new DefaultMutableTreeNode(categoryBoss.getCatName());
        tree = new JTree(troot);
        tree.setBackground(Color.lightGray);
        loadTree(categoryBoss);
        /* Put the Tree in a scroller. */

        sp.getViewport().add(tree);
        setSize(new Dimension(200, 300));
        setVisible(true);
    }

    //------------------------------------
    public void loadTree(Category topCat) {
        DefaultMutableTreeNode newTreeRoot;
        newTreeRoot = new DefaultMutableTreeNode(topCat.getCatName());
        treePanel.remove(tree);
        tree = new JTree(newTreeRoot);
        tree.addTreeSelectionListener(this);
        sp.getViewport().add(tree);

        addNodes(newTreeRoot, topCat);
        tree.expandRow(0);
        repaint();
    }

    //--------------------------------------
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

    //--------------------------------------
    private void makeCategories() {
        categoryBoss = new Category("CEO", "CEO", "");
        categoryBoss.addSubCategory(categoryMarketVP = new Category("MKT-VP", "Marketing VP", ""));
        categoryBoss.addSubCategory(categoryProdVP = new Category("PRO-VP", "Production VP", ""));

        categoryMarketVP.addSubCategory(categorySalesMgr = new Category("SLS_MGR", "Sales Mgr", ""));
        categoryMarketVP.addSubCategory(categoryAdvMgr = new Category("ADVT-MGR", "Advert Mgr", ""));

        String randInt = "";
        for (int i = 0; i < 5; i++) {
            randInt = new Integer(i).toString();
            Category newCat = new Category("SALES" + randInt, "Sales " + randInt, "");
            categorySalesMgr.addSubCategory(newCat);
            
            //Test something
            if (i%3==0){
                randInt = new Integer(i).toString();
                newCat.addSubCategory(new Category("SALES-AST" + randInt, "Sales Assistant " + randInt, ""));
            }
        }
        categoryAdvMgr.addSubCategory(new Category("ADVM-SEC", "Secy", ""));

        categoryProdVP.addSubCategory(categoryProdMgr = new Category("PRD-MGR", "Prod Mgr", ""));
        categoryProdVP.addSubCategory(categoryShipMgr = new Category("SHIP-MGR", "Ship Mgr", ""));
        
        for (int i = 0; i < 4; i++) {
            randInt = new Integer(i).toString();
            categoryProdMgr.addSubCategory(new Category("MAN" + randInt, "Manuf " + randInt, ""));
        }
        
        for (int i = 0; i < 3; i++) {
            categoryShipMgr.addSubCategory(new Category("SHIP-CLK" + randInt, "ShipClrk " + randInt, ""));
        }
    }

    //--------------------------------------
    public void valueChanged(TreeSelectionEvent evt) {
        TreePath path = evt.getPath();
        String selectedTerm = path.getLastPathComponent().toString();

        IDebug.print(selectedTerm);

        Category cat = categoryBoss.getSubCategory(selectedTerm);
        if (cat != null) {
            lblCatID.setText(cat.getCatID() + " #Sub Cats: " + cat.countSubCategories());
        }
    }

    //--------------------------------------
    static public void main(String argv[]) {
        TryCategoryTree tryCategoryTree = new TryCategoryTree();
    }
}