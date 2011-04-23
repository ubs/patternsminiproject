package appclasses;

import java.util.*;

/**
 *
 * @author iXeon
 */
public class CategoryModel {
    //Data Fields
    private HashMap<String, Category> categories = new HashMap();
    
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
}