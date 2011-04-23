package AppPersistence;

import AppClasses.IDebug;
import java.io.File;
import javax.xml.parsers.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * @Pattern ???
 * @author iXeon
 */
public class CategoryXMLMapper extends XMLPersistenceImplementor {
    private String XMLStorageFile = "";

    public CategoryXMLMapper() throws
            FactoryConfigurationError, ParserConfigurationException, SAXException {
        initSAXXMLParser();
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
        //Get XML Parser
        //Get File Input Stream
        //Parse File
        IDebug.print("\nCalling " + getClass() + " live!\n");
        try {
            XMLSAXParser.parse(getFileInputStream(XMLStorageFile), this);
        } catch (Exception e){
            //
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
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
        IDebug.print("startElement: " + qName);
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        IDebug.print("startElement: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        IDebug.print("startElement: " + new String(ch, start, length));
    }
}
