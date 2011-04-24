package persistence;

import appclasses.Article;
import appclasses.ArticleModel;
import appclasses.IDate;
import appclasses.IDebug;

import java.io.CharArrayWriter;
import java.io.File;
import java.util.*;
import javax.xml.parsers.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * @Pattern BRIDGE (Implementor)
 * @author iXeon
 */
public class ArticleXMLMapper extends XMLPersistenceImplementor {

    public final String AppModelBase = "F:/Xeon_ManU/Course_Vault/COMP61532/"
            + "Individual-Mini-Project/IssueTrackingSystem-1/GUI-Sandbox/MiniProjectSandBox/src/SimpleSAXParser/";
    public final String AppModelBase2 = "src/appmodel/";
    public final String CategoryXMLFile = AppModelBase2 + "Article.xml";

    private String XMLStorageFile = "";
    private static long totalObjectsRead = 0;

    //Local list of items...
    private Vector<Article> articleItems = new Vector<Article>();
    private Article currentArticleItem;

    // Buffer for collecting data from the "characters" SAX event.
    private CharArrayWriter contents = new CharArrayWriter();

    public ArticleXMLMapper() throws
            FactoryConfigurationError, ParserConfigurationException, SAXException {
        initSAXXMLParser();
    }

    public String getXMLStorageFile() {
        return XMLStorageFile;
    }

    public void setXMLStorageFile(String XMLStorageFile) {
        this.XMLStorageFile = XMLStorageFile;
    }

    @Override
    public boolean persistObject(Object object) {
        return true;
    }

    @Override
    public boolean persistAllObjects(Object[] objects) {
        return true;
    }

    @Override
    public Object loadObject(String objectID) {
        return null;
    }

    @Override
    public Object[] loadAllObjects() {
        IDebug.print("\nCalling " + getClass() + " live, from XML Mapper!\n");
        try {
            XMLStorageFile = CategoryXMLFile;
            XMLSAXParser.parse(getFileInputStream(XMLStorageFile), this);
        } catch (Exception e) {
            //@TODO Handle error here
        }

        return null;
    }

    @Override
    public String readFromFile(File f) {
        // open file, load object and return the object
        return null;
    }

    @Override
    public boolean writeToFile(File f, String fileContent) {
        // serialize object and write it to file
        boolean success = false;
        IDebug.print(fileContent);
        return success;
    }

    /**
     * ContentHandler Interface overrides
     */
    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        IDebug.print("startElement: " + qName + ", localName: " + localName);

        contents.reset();

        if (qName.equalsIgnoreCase("article")) {
            currentArticleItem = new Article();
            articleItems.add(currentArticleItem);
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        IDebug.print("endElement: " + qName + ", localName: " + localName);

        if ( qName.equalsIgnoreCase( "articleID" ) ) {
            currentArticleItem.setArticleID(contents.toString());
        }

        if ( qName.equalsIgnoreCase( "articleTitle" ) ) {
            currentArticleItem.setArticleTitle(contents.toString());
        }

        if ( qName.equalsIgnoreCase( "articleCatID" ) ) {
            currentArticleItem.setArticleCatID(contents.toString());
        }
        
        if ( qName.equalsIgnoreCase( "issue" ) ) {
            currentArticleItem.setIssue(contents.toString());
        }
        
        if ( qName.equalsIgnoreCase( "solution" ) ) {
            currentArticleItem.setSolution(contents.toString());
        }
        
        if ( qName.equalsIgnoreCase( "entryDate" ) ) {
            currentArticleItem.setEntryDate( IDate.stringToDate(contents.toString()) );
        }
        
        if ( qName.equalsIgnoreCase( "relatedArticles" ) ) {
            currentArticleItem.addToRelatedArticles(contents.toString());
        }
        
        if (qName.equalsIgnoreCase("article")) {
            totalObjectsRead++;
        } else if (qName.equalsIgnoreCase("articlemodel")){
            //End of processing all together
            IDebug.print("Total Articles Processed: "  + totalObjectsRead + "\n");
            testParseSuccess();
            ArticleModel.getInstance().addArticles(articleItems);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //IDebug.print("characters: " + xmlCharacters);
        contents.write( ch, start, length );
    }

    private void testParseSuccess(){
        IDebug.print("Testing Parse Success");
        Article article;
        Enumeration e = articleItems.elements();
        while( e.hasMoreElements()){
            article = (Article) e.nextElement();
            article.print(System.out);
        }
    }
}