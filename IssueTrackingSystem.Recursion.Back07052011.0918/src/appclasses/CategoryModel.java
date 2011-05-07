package appclasses;

import java.util.*;

/**
 *
 * @author iXeon
 */
public class CategoryModel extends AppModel {
    //Data Fields
    private HashMap<String, Category> categories = new HashMap<String, Category>();
    private Category rootCategory = null;
    private long articlesInCategoryCount = 0;
    
    //Constructor
    private static CategoryModel instance;

    private CategoryModel() {
    }

    public static synchronized CategoryModel getInstance() {
        if (instance == null) {
            instance = new CategoryModel();
        }

        return instance;
    }

    //Prevent Cloning
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void addCategory(Category category) {
        IDebug.print("CategoryModel: Adding Cateory to Model");
        categories.put(category.getCatID(), category);
    }

    public boolean addCategories(Vector<Category> categoryObjects){
        boolean success = true;
        IDebug.print("Total cat Objects sent in: " + categoryObjects.size());
        Category catI;
        Enumeration e = categoryObjects.elements();
        while( e.hasMoreElements() ){
            catI = (Category) e.nextElement();
            addCategory(catI);
        }
        return success;
    }

    public void addNewCategory(String catID, String catName, String catDescription, String catParent){
        Category category = new Category(catID, catName, catDescription);
        if (catParent != null && isNumeric(catID)){
            if (categories.containsKey(catID)){
                Category parentCategory = categories.get(catID);
                category.setParentCategory(parentCategory);
            }
        }
        addCategory(category);
    }

    public boolean addCategoriesAndInitComposites(Vector<Category> categoryObjects){
        boolean success = true;
        addCategories(categoryObjects);
        initializeCompositeCategories();
        dumpCategories();
        return success;
    }

    public Category getCategory(String catID){
        if (categories.containsKey(catID)){
            return categories.get(catID);
        }
        return null;
    }

    public void removeCategory(String catID){
        //Set sub categories parent null before deleting
        if (categories.containsKey(catID)){
            categories.remove(catID);
        }
    }

    public Category getRootCategory(){
        if (rootCategory == null) { initRootCategory(); }
        return rootCategory;
    }

    public void initRootCategory(){
        //The Root Category is simply an Ancestor Category ot others
        Category category;
        rootCategory = new Category("0", "Categories", "Root Category", null);

        for (Map.Entry<String, Category> entry : categories.entrySet()) {
            category = entry.getValue();

            if (category.getParentCategory()==null){
                //Yes! Yes!
                category.setParentCategory(rootCategory);
            }
        }
    }

    public void initializeCompositeCategories() {
        //Set Parents and Children as due
        String parentID;
        Category category, parentCategory;
        
        for (Map.Entry<String, Category> entry : categories.entrySet()) {
            category = entry.getValue();
            parentID = category.getCatParentID();
            if (isNumeric(parentID)){
                if (categories.containsKey(parentID)){
                    parentCategory = categories.get(parentID);
                    category.setParentCategory(parentCategory);
                }
            }
        }
    }

    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void dumpCategories(){
        Category catI;
        IDebug.print("Dumping Categories");

        for (Map.Entry<String, Category> entry : categories.entrySet()) {
            //String key = entry.getKey();
            catI = entry.getValue();
            catI.print(System.out);
            //IDebug.print("\n" + catI.toPersistenceString());
        }
    }

    //Getters and Setters
    public Map<String, Category> getCategories() {
        return categories;
    }

    public long getTotalCount(){
        return categories.size();
    }

    public long countArticlesInCategory(String catID){
        long articlesCount = 0;
        articlesCount = ArticleModel.getInstance().countArticlesByCategory(catID);
        return articlesCount;
    }

    public long countCummulativeArticlesInCategory(String catID){
        IDebug.print("In cummulative counter:>>");
        long articlesCount = 0;
        Category catI;
        
        if (categories.containsKey(catID)){
            IDebug.print("In cummulative counter:>> Key found, proceeding");
            catI = categories.get(catID);

            //Using Recursion to count all articles, count all sub category articles, then count main cat
            if (catI.isParentCategory()){
                IDebug.print("In cummulative counter:>> Category" + catI + " is Parent, Recursive Entrance");
                //Do a recursive count on all sub categories
                Iterator<Category> subcatIterator = catI.getSubCategoriesIterator();

                Category subcat;
                while (subcatIterator.hasNext()) {
                    subcat = subcatIterator.next();
                    IDebug.print("In cummulative counter:>> current SubCategory : " + 
                            subcat + " Is parent? " + subcat.isParentCategory() + ", Is Leaf? " +
                            subcat.isLeafCategory());
                    articlesCount += countCummulativeArticlesInCategory( subcat.getCatID() );
                }
            }

            //Count in Main catgeory itself
            IDebug.print("On the terminating else end of this recursion >> Article Count: " + articlesCount);
            articlesCount += ArticleModel.getInstance().countArticlesByCategory(catID);
            IDebug.print("Articles count thus far: " + articlesCount);
        }
        return articlesCount;
    }

    //Persistence String Generator
    @Override
    public String toPersistenceString() {
        return toXMLPersistenceString();
    }

    protected String toXMLPersistenceString(){
        StringBuilder XMLPersistenceString = new StringBuilder();
        String breakLine = "\n";
        String modelRootBeginTag = "<categorymodel>";
        String modelRootEndTag = "</categorymodel>";
        Category catI;

        XMLPersistenceString.append(getXMLHeaderString()).append(breakLine);

        XMLPersistenceString.append(modelRootBeginTag).append(breakLine);
        
        for (Map.Entry<String, Category> entry : categories.entrySet()) {
            //String key = entry.getKey();
            catI = entry.getValue();
            XMLPersistenceString.append( catI.toPersistenceString() ).append(breakLine);
        }

        XMLPersistenceString.append(modelRootEndTag).append(breakLine);

        return XMLPersistenceString.toString();
    }

    protected String getXMLHeaderString(){
        StringBuilder XMLHeaderString = new StringBuilder();
        String breakLine = "\n";

        XMLHeaderString
            .append("<?xml version='1.0' encoding='UTF-8'?>").append(breakLine)
            .append("<!DOCTYPE categorymodel [").append(breakLine)
            .append("<!ELEMENT categorymodel (category)*>").append(breakLine)
            .append("<!ELEMENT category (catID, catName, catDescription, catParentID)>").append(breakLine)
            .append("<!ELEMENT catID (#PCDATA)>").append(breakLine)
            .append("<!ELEMENT catName (#PCDATA)>").append(breakLine)
            .append("<!ELEMENT catDescription (#PCDATA)>").append(breakLine)
            .append("<!ELEMENT catParentID (#PCDATA)>").append(breakLine)
            .append("]>").append(breakLine);

        return XMLHeaderString.toString();
    }
}