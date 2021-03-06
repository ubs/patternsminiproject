package AppClasses;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This is the main category interface
 * @Pattern COMPOSITE
 * @author iXeon
 */
public class Category extends CategoryBase implements CategoryInterface {

    //Data Members
    private ArrayList<Category> subCategories;
    private boolean isLeafCategory;
    private Category parentCategory = null;

    //~Constructors
    public Category() {
        super();
        categoryInits();
    }

    public Category(String catID, String catName, String catDescription) {
        super(catID, catName, catDescription);
        categoryInits();
    }

    //@TODO: Remove this constructor and the one in the super class
    public Category(String catID, String catName, String catDescription, String catParent) {
        super(catID, catName, catDescription, catParent);
        categoryInits();
    }

    public Category(Category parentCategory, String catID, String catName, String catDescription, String catParent) {
        super(catID, catName, catDescription, catParent);
        categoryInits();
        this.parentCategory = parentCategory;
    }

    //~Class Methods
    private void categoryInits(){
        isLeafCategory = false;
        subCategories = new ArrayList<Category>();
    }

    //~Getters and Setters
    public boolean isLeafCategory() {
        return isLeafCategory;
    }

    public void setIsLeafCategory(boolean isLeafCategory) {
        this.isLeafCategory = isLeafCategory;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    //~Should it be left public? Hang on there first
    public void setSubCategories(ArrayList subCategories) {
        this.subCategories = subCategories;
    }

    
    //~Implemented Methods from Interface
    public ArrayList getSubCategories() {
        return subCategories;
    }
    
    public boolean addSubCategory(Category cat) {
        if (!isLeafCategory) {
            subCategories.add(cat);
        }
        return isLeafCategory; //false if unsuccessful
    }

    public void removeSubCategory(Category cat) {
        if (!isLeafCategory) {
            subCategories.remove(cat);
        }
    }

    public Iterator<Category> getSubCategoriesIterator() {
        return subCategories.iterator();
    }

    //~Get Child Method where Child: Sub Category
    public Category getSubCategory(String s) {
        Category cat = null;

        if (getCatName().equals(s)) {
            return this;
        } else {
            boolean found = false;
            Iterator<Category> iterator = getSubCategoriesIterator();

            while (iterator.hasNext() && (!found)) {
                cat = (Category)iterator.next();
                found = cat.getCatName().equals(s);

                if (!found){
                    cat = cat.getSubCategory(s);
                    found = (cat != null);
                }
            }
            
            if (found) {
                return cat;
            } else {
                return null;
            }
        }
    }

    public long countArticles(){
        long articleCount = 0;
        for (Category cat: subCategories){
            articleCount += cat.countArticles();
        }
        return articleCount;
    }

    //@TODO: Work on this method as it means count articles but actually 
    //says countSubCategories
    public long countSubCategories(){
        return subCategories.size();
    }

    public ArticleBase[] getArticles(){
        return null;
    }
}