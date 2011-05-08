package persistence;

import classes.GenericHelper;
import org.w3c.dom.*;

/**
 * This class would help out with some useful shared methods for XML operations
 * @author popoola
 */
public class XMLUtility {

    public static int getSize(Document doc, String tagName) {
        //Given an XML document and a tag name return the number of ocurrences
        NodeList rows = doc.getDocumentElement().getElementsByTagName(tagName);
        return rows.getLength();
    }

    public static Element getElement(Document doc, String tagName, int index) {
        //Given an XML document and a tag return an Element at a given index
        NodeList rows = doc.getDocumentElement().getElementsByTagName(tagName);
        return (Element) rows.item(index);
    }

    public static String getValue(Element e, String tagName) {
        String str2Return = "";

        try {    
            //Get node lists of a tag name from a Element
            NodeList elements = e.getElementsByTagName(tagName);

            Node node = elements.item(0);
            NodeList nodes = node.getChildNodes();

            //Find a value whose value is non-whitespace
            for (int i = 0; i < nodes.getLength(); i++) {
                str2Return = ((Node) nodes.item(i)).getNodeValue().trim();
                if (str2Return.isEmpty() || str2Return.equals("\r")) {
                    continue;
                } else {
                    break;
                }
            }
        } catch (Exception ex) {
            GenericHelper.printout(ex.getMessage());
            //ex.printStackTrace();
            str2Return = "";
        }

        return str2Return;
    }
}