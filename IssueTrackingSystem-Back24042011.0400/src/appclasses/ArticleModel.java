package appclasses;

import java.util.*;

/**
 * Article Model
 * @author iXeon
 */
public class ArticleModel {
    //Data Fields
    private HashMap<String, Article> articles = new HashMap();

    //Constructor
    private static ArticleModel instance;

    private ArticleModel() {
    }

    public static synchronized ArticleModel getInstance() {
        if (instance == null) {
            instance = new ArticleModel();
        }

        return instance;
    }

    public void addArticle(Article article) {
        IDebug.print("ArticleModel: Adding Article to Model");
        articles.put(article.getArticleID(), article);
    }

    public boolean addArticles(Vector<Article> articleObjects){
        boolean success = true;
        IDebug.print("Total Objects sent in: " + articleObjects.size());
        Article article;
        Enumeration e = articleObjects.elements();
        while( e.hasMoreElements() ){
            article = (Article) e.nextElement();
            addArticle(article);
        }
        return success;
    }

    public Article getArticle(String articleID){
        if (articles.containsKey(articleID)){
            return articles.get(articleID);
        }
        return null;
    }

    public void removeArticle(String articleID){
        if (articles.containsKey(articleID)){
            articles.remove(articleID);
        }
    }

    public void addNewArticle(String articleID, String articleTitle, String articleCatID, String issue, String solution) {
        Article article = new Article();
        article.setArticleID(articleID);
        article.setArticleTitle(articleTitle);
        article.setArticleCatID(articleCatID);
        article.setIssue(issue);
        article.setSolution(solution);
        article.setEntryDate(new Date());
        addArticle(article);
    }

    public void updateArticle(String articleID, String articleTitle, String articleCatID, String issue, String solution) {
        if (!articles.containsKey(articleID)){
            //
        }
        else {
            Article article = articles.get(articleID);
            //article.setArticleID(articleID);
            article.setArticleTitle(articleTitle);
            article.setArticleCatID(articleCatID);
            article.setIssue(issue);
            article.setSolution(solution);
        }
    }

    public void dumpArticles(){
        Article article;
        IDebug.print("Dumping All Articles");

        for (Map.Entry<String, Article> entry : articles.entrySet()) {
            //String key = entry.getKey();
            article = entry.getValue();
            article.print(System.out);
            //IDebug.print("\n" + article.toPersistenceString());
        }
    }

    //Getters and Setters
    public Map<String, Article> getArticles() {
        return articles;
    }

    public long getTotalCount(){
        return articles.size();
    }
}