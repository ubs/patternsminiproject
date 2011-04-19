package AppClasses;

/**
 * This is the main category interface
 * @Pattern COMPOSITE
 * @author iXeon
 */
public interface Category {
    public long countArticles();
    public long countSubCategories();
    public Category getSubCategories();
    public Article[] getArticles();
}
