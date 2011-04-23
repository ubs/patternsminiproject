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
        return XMLPersistenceString.toString();
    }
}
