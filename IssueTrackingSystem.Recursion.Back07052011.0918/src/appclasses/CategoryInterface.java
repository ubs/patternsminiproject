package appclasses;

import java.util.ArrayList;

/**
 * @Pattern COMPOSITE
 * @author iXeon
 */
public interface CategoryInterface {
    public long countArticles();
    public long countSubCategories();

    public ArticleBase[] getArticles();
    public Category getSubCategory(String s); //~Get Child
    public ArrayList getSubCategories(); //~Get Children
    
    public boolean addSubCategory(Category cat); //~Add Child
    public void removeSubCategory(Category cat); //~Remove Child

}
