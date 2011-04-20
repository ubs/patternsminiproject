package AppClasses;

import java.util.Date;
import java.util.List;

/**
 *
 * @author iXeon
 */
public abstract class ArticleBase {
    //Data Fields
    private String articleID;
    private String articleTitle;
    private CategoryBase articleCategory;
    private String issue;
    private String solution;
    private Date entryDate;
    private List relatedArticles;

    //Constructor
    public ArticleBase() {
    }

    //Getters and Setters
    public CategoryBase getArticleCategory() {
        return articleCategory;
    }

    public void setArticleCategory(CategoryBase articleCategory) {
        this.articleCategory = articleCategory;
    }

    public String getArticleID() {
        return articleID;
    }

    public void setArticleID(String articleID) {
        this.articleID = articleID;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public List getRelatedArticles() {
        return relatedArticles;
    }

    public void setRelatedArticles(List relatedArticles) {
        this.relatedArticles = relatedArticles;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}