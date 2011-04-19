package AppClasses;

/**
 * Leaf Level Category
 * @Pattern COMPOSITE
 * @author iXeon
 */
public class SimpleCategory implements Category {
    public long countArticles(){
        return 0;
    }

    public long countSubCategories(){
        return 0;
    }

    public Category getSubCategories(){
        throw new UnsupportedOperationException();
    }

    public Article[] getArticles(){
        throw new UnsupportedOperationException();
    }
}
