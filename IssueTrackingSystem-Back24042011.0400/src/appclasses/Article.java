package appclasses;

/**
 *
 * @author iXeon
 */
public class Article extends ArticleBase {

    public Article() {
        super();
    }

    public String toPersistenceString(){
        return toXMLPersistenceString();
    }

    protected String toXMLPersistenceString(){
        StringBuilder XMLPersistenceString = new StringBuilder();
        String breakLine = "\n";

        XMLPersistenceString
                .append("<article>").append(breakLine)
                    .append("<articleID>").append(getArticleID()).append("</articleID>").append(breakLine)
                    .append("<articleTitle>").append(getArticleTitle()).append("</articleTitle>").append(breakLine)
                    .append("<articleCatID>").append(getArticleCatID()).append("</articleCatID>").append(breakLine)
                    .append("<issue>").append(getIssue()).append("</issue>").append(breakLine)
                    .append("<solution>").append(getSolution()).append("</solution>").append(breakLine)
                    .append("<entryDate>").append(IDate.dateToString(getEntryDate())).append("</entryDate>").append(breakLine)
                    .append("<relatedArticles>").append("").append("</relatedArticles>").append(breakLine)
                .append("</article>").append(breakLine);

        return XMLPersistenceString.toString();
    }
}