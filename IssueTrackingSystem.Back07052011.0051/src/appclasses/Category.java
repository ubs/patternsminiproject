package appclasses;

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
    
    public Category(String catID, String catName, String catDescription, String catParent) {
        super(catID, catName, catDescription, catParent);
        categoryInits();
    }

    public Category(Category parentCategory, String catID, String catName, String catDescription, String catParent) {
        super(catID, catName, catDescription, catParent);
        categoryInits();
        this.parentCategory = parentCategory;
    }

    @Override
    public String toString() {
        String separator = ", ";
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Category{").append("catID=").append(getCatID())
                .append(separator).append("catName=").append(getCatName());
        if (parentCategory != null){
            strBuilder.append(" [Parent Category: ").append(parentCategory.getCatName()).append("]");
        }
        strBuilder.append("}");
        return strBuilder.toString();
    }

    //~Class Methods
    private void categoryInits(){
        isLeafCategory = false;
        subCategories = new ArrayList<Category>();
    }

    //~Getters and Setters
    public boolean isParentCategory() {
        return !isLeafCategory();
    }

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
        this.parentCategory.addSubCategory(this);
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
                cat = iterator.next();
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

    public long countSubCategories(){
        return subCategories.size();
    }

    public ArticleBase[] getArticles(){
        return null;
    }

    public String toPersistenceString(){
        return toXMLPersistenceString();
    }

    protected String toXMLPersistenceString(){
        StringBuilder XMLPersistenceString = new StringBuilder();
        String breakLine = "\n";
        
        XMLPersistenceString
                .append("<category>").append(breakLine)
                    .append("<catID>").append(getCatID()).append("</catID>").append(breakLine)
                    .append("<catName>").append(getCatName()).append("</catName>").append(breakLine)
                    .append("<catDescription>").append(getCatDescription()).append("</catDescription>").append(breakLine)
                    .append("<catParentID>").append(getCatParentID()).append("</catParentID>").append(breakLine)
                .append("</category>").append(breakLine);
        
        return XMLPersistenceString.toString();
    }
}