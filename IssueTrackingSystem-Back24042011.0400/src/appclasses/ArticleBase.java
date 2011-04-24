package appclasses;

import java.io.PrintStream;
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
    private String articleCatID;
    private String issue;
    private String solution;
    private Date entryDate;
    private List<String> relatedArticles;

    //Constructor
    public ArticleBase() {
        articleID = null;
        articleTitle = null;
        articleCatID = null;
        issue = null;
        solution = null;
        entryDate = null;
        relatedArticles = null;
    }

    abstract String toPersistenceString();

    public void addToRelatedArticles(String articleID){
        if (articleID != null && !articleID.trim().isEmpty()){
            relatedArticles.add(articleID);
        }
    }

    public void print(PrintStream out) {
        out.println( "\nArticle Object: " );
        out.println( " articleID -> " + articleID );
        out.println( " articleTitle -> " + articleTitle );
        out.println( " articleCatID -> " + articleCatID );
        out.println( " issue -> " + issue );
        out.println( " solution -> " + solution );
        out.println( " entryDate -> " + IDate.dateToString(entryDate) );
        out.println( " relatedArticles -> " + relatedArticles + "\n");
    }

    //Getters and Setters
    public String getArticleCatID() {
        return articleCatID;
    }

    public void setArticleCatID(String articleCatID) {
        this.articleCatID = articleCatID;
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

    public void setRelatedArticles(List<String> relatedArticles) {
        this.relatedArticles = relatedArticles;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}