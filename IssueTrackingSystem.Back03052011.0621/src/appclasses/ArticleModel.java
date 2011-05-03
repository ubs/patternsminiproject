package appclasses;

import java.util.*;
import java.util.ArrayList;

/**
 * Article Model
 * @author iXeon
 */
public class ArticleModel extends AppModel {
    //Data Fields
    private HashMap<String, Article> articles = new HashMap<String, Article>();

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

    //Prevent Cloning
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
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

    public ArrayList<Article> getArticlesByCategoryAsArrayList(String categoryID){
        Article article;
        ArrayList<Article> articlesListByCat = new ArrayList<Article>();

        for (Map.Entry<String, Article> entry : articles.entrySet()) {
            //String key = entry.getKey();
            article = entry.getValue();
            IDebug.print(categoryID + "vs" + article.getArticleCatID());
            if (article.getArticleCatID().equalsIgnoreCase(categoryID)){
                articlesListByCat.add(article);
            }
        }
        return articlesListByCat;
    }

    public Article[] getArticlesByCategoryAsArray(String categoryID){
        ArrayList<Article> articlesListByCat = getArticlesByCategoryAsArrayList(categoryID); //new ArrayList<Article>();
        return articlesListByCat.toArray(new Article[0]);
    }

    public long getTotalCount(){
        return articles.size();
    }

    //Persistence String Generator
    @Override
    public String toPersistenceString() {
        return toXMLPersistenceString();
    }

    protected String toXMLPersistenceString(){
        StringBuilder XMLPersistenceString = new StringBuilder();
        String breakLine = "\n";
        String modelRootBeginTag = "<articlemodel>";
        String modelRootEndTag = "</articlemodel>";
        Article article;

        XMLPersistenceString.append(getXMLHeaderString()).append(breakLine);

        XMLPersistenceString.append(modelRootBeginTag).append(breakLine);

        for (Map.Entry<String, Article> entry : articles.entrySet()) {
            //String key = entry.getKey();
            article = entry.getValue();
            XMLPersistenceString.append( article.toPersistenceString() ).append(breakLine);
        }

        XMLPersistenceString.append(modelRootEndTag).append(breakLine);

        return XMLPersistenceString.toString();
    }

    protected String getXMLHeaderString(){
        StringBuilder XMLHeaderString = new StringBuilder();
        String breakLine = "\n";

        XMLHeaderString
            .append("<?xml version='1.0' encoding='UTF-8'?>").append(breakLine)
            .append("<!DOCTYPE articlemodel [").append(breakLine)
            .append("<!ELEMENT articlemodel (article)*>").append(breakLine)
            .append("<!ELEMENT article (articleID, articleTitle, articleCatID, issue, solution, entryDate, relatedArticles)>").append(breakLine)
            .append("<!ELEMENT articleID (#PCDATA)>").append(breakLine)
            .append("<!ELEMENT articleTitle (#PCDATA)>").append(breakLine)
            .append("<!ELEMENT articleCatID (#PCDATA)>").append(breakLine)
            .append("<!ELEMENT issue (#PCDATA)>").append(breakLine)
            .append("<!ELEMENT solution (#PCDATA)>").append(breakLine)
            .append("<!ELEMENT entryDate (#PCDATA)>").append(breakLine)
            .append("<!ELEMENT relatedArticles (#PCDATA)>").append(breakLine)
            .append("]>").append(breakLine);

        return XMLHeaderString.toString();
    }
}