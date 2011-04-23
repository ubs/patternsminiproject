package AppPersistence;

import AppClasses.IDebug;
import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @Pattern BRIDGE
 * @author iXeon
 */
public abstract class XMLPersistenceImplementor extends DefaultHandler implements FileSystemPersistenceImplementor {
    protected SAXParser XMLSAXParser = null;

    @Override
    public boolean persistObject(Object object){
        return true;
    }

    @Override
    public boolean persistAllObjects(Object[] objects){
        return true;
    }

    @Override
    public Object loadObject(String objectID){
        return null;
    }

    @Override
    public Object[] loadAllObjects(){
        //Act as template method, then call hook method
        //loadAllObjectsFromXMLFile();
        return null;
    }

    @Override
    public FileInputStream getFileInputStream(String filePath){
        FileInputStream fIStream = null;
        try {
            fIStream = new FileInputStream(filePath);
        } catch (FileNotFoundException fnfe) {
            IDebug.printError("File " + filePath + " not found!");
            System.exit(2);
        }
        return fIStream;
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

    /*
     * 
    public final void performTrip(){
        doComingTransport();
        doDayA();
        doDayB();
        doDayC();
        doReturningTransport();
    }
    public abstract void doComingTransport();
    public abstract void doDayA();
    public abstract void doDayB();
    public abstract void doDayC();
    public abstract void doReturningTransport();

    */

    public SAXParser initSAXXMLParser() throws
            FactoryConfigurationError, ParserConfigurationException, SAXException {
        try {
            if (XMLSAXParser == null){
                SAXParserFactory SAXPFactory = SAXParserFactory.newInstance();
                XMLSAXParser = SAXPFactory.newSAXParser();
            }
        } catch (FactoryConfigurationError fce) {
            IDebug.printError("Error creating SAX parser factory:");
            fce.printStackTrace();
            System.exit(3);
        } catch (ParserConfigurationException pce) {
            IDebug.printError("Error creating SAX parser:");
            pce.printStackTrace();
            System.exit(4);
        } catch (SAXException saxe) {
            IDebug.printError("Error creating SAX parser:");
            saxe.printStackTrace();
            System.exit(5);
        }

        return XMLSAXParser;
    }

    /**
     * ErrorHandler Interface overrides
     */
    @Override
    public void error(SAXParseException e) throws SAXException {
        IDebug.printError("Following error occured during parsing:");
        e.printStackTrace();
        System.exit(6);
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        IDebug.printError("Following fatal error occured during parsing:");
        e.printStackTrace();
        IDebug.printError("Parsing will be Terminated.");
        throw new SAXException(e);
    }

}