package persistence;

import appclasses.AppConfig;
import appclasses.AppConfigModel;
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
public class AppConfigXMLMapper extends XMLPersistenceImplementor {

    public final String AppModelBase = "F:/Xeon_ManU/Course_Vault/COMP61532/"
            + "Individual-Mini-Project/IssueTrackingSystem-1/GUI-Sandbox/MiniProjectSandBox/src/SimpleSAXParser/";
    public final String AppModelBase2 = "src/appmodel/";
    public final String CategoryXMLFile = AppModelBase2 + "AppConfig.xml";

    private String XMLStorageFile = "";
    private static long totalObjectsRead = 0;

    //Local list of items...
    private Vector<AppConfig> appConfigItems = new Vector<AppConfig>();
    private AppConfig currentAppConfigItem;

    // Buffer for collecting data from the "characters" SAX event.
    private CharArrayWriter contents = new CharArrayWriter();

    public String getXMLStorageFile() {
        return XMLStorageFile;
    }

    public void setXMLStorageFile(String XMLStorageFile) {
        this.XMLStorageFile = XMLStorageFile;
    }

    public AppConfigXMLMapper() throws
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

        if (qName.equalsIgnoreCase("appconfig")) {
            currentAppConfigItem = new AppConfig();
            appConfigItems.add(currentAppConfigItem);
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        IDebug.print("endElement: " + qName + ", localName: " + localName);

        if ( qName.equalsIgnoreCase( "configkey" ) ) {
            currentAppConfigItem.setConfigKey(contents.toString());
        }

        if ( qName.equalsIgnoreCase( "configname" ) ) {
            currentAppConfigItem.setConfigName(contents.toString());
        }

        if ( qName.equalsIgnoreCase( "configvalue" ) ) {
            currentAppConfigItem.setConfigValue(contents.toString());
        }

        if (qName.equalsIgnoreCase("appconfig")) {
            totalObjectsRead++;
        } else if (qName.equalsIgnoreCase("appconfigmodel")){
            //End of processing all together
            IDebug.print("Total AppConfigs Processed: "  + totalObjectsRead + "\n");
            testParseSuccess();
            AppConfigModel.getInstance().addAppConfigs(appConfigItems);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //IDebug.print("characters: " + xmlCharacters);
        contents.write( ch, start, length );
    }

    private void testParseSuccess(){
        AppConfig appConfig;
        Enumeration e = appConfigItems.elements();
        while( e.hasMoreElements()){
            appConfig = (AppConfig) e.nextElement();
            appConfig.print(System.out);
        }
    }
}