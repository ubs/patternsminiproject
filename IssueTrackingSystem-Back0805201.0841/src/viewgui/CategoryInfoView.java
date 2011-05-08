package viewgui;

import appclasses.Category;
import appclasses.CategoryModel;
import appclasses.IDebug;
import appclasses.IObservable;
import appclasses.IObserver;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

/**
 * Category Statistics and Info
 * @author iXeon
 */
public class CategoryInfoView extends JPanel implements IObserver {
    private Category currentSelectedCategory;
    
    private JLabel titleLabel;
    private JLabel lblTotalSubCat, lblTotalArticles, lblCummTotalArticles, lblCatDescription;
    private JLabel TotalSubCat, TotalArticles, CummTotalArticles;
    private JTextArea jtaCatDescription;
    private JScrollPane jScrollPane;

    private String TITLE_STRING = "Category Stats & Info";
    private String DEFAULT_NO_VALUE = "--";
    private String DEFAULT_NO_CATEGORY_SELECTED = "None Selected";
    private String TOTAL_SUBCAT_DISPLAY_STRING = "Total Subcategories";
    private String TOTAL_ARTICLE_DISPLAY_STRING = "Total Articles";
    private String CUMM_TOTAL_DISPLAY_STRING = "Cummulative Total";
    private String CAT_DESCRIPTION_DISPLAY_STRING = "Category Description";

    public CategoryInfoView() {
        super();
        initCategoryInfoView();
    }

    private void initCategoryInfoView() {
        initDisplayLabels();
        initValueLabels();
        setDisplayControlsProperties();
        setupCategoryViewPanel();
    }
    
    private void setupCategoryViewPanel() {
        JPanel jpanel = getCategoryInfoPanel();
        add(jpanel);
        setSize(getWidth(), 300);
    }

    private void displayInformationForCategory(Category currentSelectedCategory) {
        if (currentSelectedCategory != null){
            String catID = currentSelectedCategory.getCatID();
            
            TotalSubCat.setText( String.valueOf(currentSelectedCategory.countSubCategories()) );
            
            TotalArticles.setText(
                String.valueOf(
                    CategoryModel.getInstance().countArticlesInCategory(catID)
                )
            );

            CummTotalArticles.setText(
                String.valueOf(
                    CategoryModel.getInstance().countCummulativeArticlesInCategory(catID)
                )
            );
            
            jtaCatDescription.setText(currentSelectedCategory.getCatDescription());
        }
    }

    //Observer Implementation
    //@PATTERN Observer
    //@OBSERVABLE/SUBJECT: CategoryTreeView
    //@OBSERVED_STATE: selectedCategory
    public void observableUpdate(IObservable observable) {
        CategoryTreeView ctv = (CategoryTreeView)observable;
        currentSelectedCategory = ctv.getSelectedCategory();

        IDebug.print("Observable in " + getClass() + " Category is: " + currentSelectedCategory);
        displayInformationForCategory(currentSelectedCategory);
    }

    //Initialization of Labels
    private void initDisplayLabels() {
        titleLabel = new JLabel(TITLE_STRING);
        lblTotalSubCat = new JLabel(TOTAL_SUBCAT_DISPLAY_STRING);
        lblTotalArticles = new JLabel(TOTAL_ARTICLE_DISPLAY_STRING);
        lblCummTotalArticles = new JLabel(CUMM_TOTAL_DISPLAY_STRING);
        lblCatDescription = new JLabel(CAT_DESCRIPTION_DISPLAY_STRING);
    }

    private void initValueLabels() {
        TotalSubCat = new JLabel(DEFAULT_NO_VALUE, SwingConstants.CENTER);
        TotalSubCat.setOpaque(true);
        TotalSubCat.setBackground(Color.WHITE);
        Border borderTotalSubCat = BorderFactory.createLineBorder(Color.BLACK);
        TotalSubCat.setBorder(borderTotalSubCat);

        TotalArticles = new JLabel(DEFAULT_NO_VALUE, SwingConstants.CENTER);
        TotalArticles.setOpaque(true);
        TotalArticles.setBackground(Color.WHITE);
        Border borderTotalArticles = BorderFactory.createLineBorder(Color.BLACK);
        TotalArticles.setBorder(borderTotalArticles);

        CummTotalArticles = new JLabel(DEFAULT_NO_VALUE, SwingConstants.CENTER);
        CummTotalArticles.setOpaque(true);
        CummTotalArticles.setBackground(Color.WHITE);
        Border borderCummTotalArticles = BorderFactory.createLineBorder(Color.BLACK);
        CummTotalArticles.setBorder(borderCummTotalArticles);

        jtaCatDescription = new JTextArea(DEFAULT_NO_CATEGORY_SELECTED);
        jtaCatDescription.setEditable(false);
        jtaCatDescription.setFont(new Font("Verdana", Font.BOLD, 12));
        jtaCatDescription.setLineWrap(true);
        jtaCatDescription.setWrapStyleWord(true);

        //Border used as padding
        Border jtaCatDescriptionPaddingBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        jtaCatDescription.setBorder(jtaCatDescriptionPaddingBorder);

        //Add a scroll pane to the textarea
        jScrollPane = new JScrollPane();
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.getViewport().add(jtaCatDescription);
        //jScrollPane.setPreferredSize(new Dimension(250, jScrollPane.getPreferredSize().height));
    }
    
    private void setDisplayControlsProperties(){
        lblCummTotalArticles.setName("lblCummTotalArticles"); 

        lblTotalSubCat.setName("lblTotalSubCat"); 

        TotalSubCat.setBackground(Color.WHITE); 
        TotalSubCat.setHorizontalAlignment(SwingConstants.CENTER);
        TotalSubCat.setHorizontalTextPosition(SwingConstants.CENTER);
        TotalSubCat.setName("TotalSubCat"); 
        TotalSubCat.setOpaque(true);

        lblTotalArticles.setName("lblTotalArticles");
        TotalArticles.setBackground(Color.WHITE); 
        TotalArticles.setHorizontalAlignment(SwingConstants.CENTER); 
        TotalArticles.setName("TotalArticles"); 
        TotalArticles.setOpaque(true);

        CummTotalArticles.setBackground(Color.WHITE); 
        CummTotalArticles.setHorizontalAlignment(SwingConstants.CENTER);
        CummTotalArticles.setName("CummTotalArticles"); 
        CummTotalArticles.setOpaque(true);

        lblCatDescription.setBackground(new Color(204, 204, 255));
        lblCatDescription.setBorder(BorderFactory.createEtchedBorder());
        lblCatDescription.setName("CatDescription"); 
        lblCatDescription.setOpaque(true);

        titleLabel.setBackground(new Color(204, 204, 255)); 
        titleLabel.setBorder(BorderFactory.createEtchedBorder());
        titleLabel.setName("titleLabel"); 
        titleLabel.setOpaque(true);
    }

    public JPanel getCategoryInfoPanel(){
        JPanel jPanel1 = new JPanel();
        jPanel1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        jPanel1.setName("CategoryInfoPanel");
        
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);

        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addComponent(lblTotalSubCat, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(lblCummTotalArticles, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblTotalArticles, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(TotalArticles, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
            .addComponent(TotalSubCat, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
            .addComponent(CummTotalArticles, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
            .addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
            .addComponent(lblCatDescription, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
            .addComponent(titleLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
            .addContainerGap())
        );

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(TotalSubCat, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(TotalArticles, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
            .addGap(29, 29, 29))
            .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(lblTotalSubCat, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lblTotalArticles, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(lblCummTotalArticles, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
            .addComponent(CummTotalArticles, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))))
            .addGap(7, 7, 7)
            .addComponent(lblCatDescription, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
            .addGap(11, 11, 11))
        );

        return jPanel1;
    }
}