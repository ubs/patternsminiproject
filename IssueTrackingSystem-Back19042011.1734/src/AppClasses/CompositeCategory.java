package AppClasses;

import java.util.List;

/**
 * Composite Level Category made up Simple or Self Categories
 * @Pattern COMPOSITE
 * @author iXeon
 */
public class CompositeCategory implements Category {
    private List<Category> subCategories;

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

    public Category getSubCategories(){
        //return subCategories;
        throw new UnsupportedOperationException();
    }

    public Article[] getArticles(){
        throw new UnsupportedOperationException();
    }
}
