package AppSandbox;

import AppPersistence.CategoryXMLMapper;
import AppPersistence.PersistenceImplementor;
import AppPersistence.IPersistence;
import AppPersistence.IPersistenceImp;
import AppPersistence.XMLPersistenceImplementor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author iXeon
 */
public class TryPersistence {

    public static void main(String[] args) {

        PersistenceImplementor implementor = null;

        if (databaseDriverExists()) {
            //implementor = new DatabasePersistenceImplementor();
        } else {
            try {
                implementor = new CategoryXMLMapper();
            } catch (FactoryConfigurationError ex) {
                Logger.getLogger(TryPersistence.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(TryPersistence.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(TryPersistence.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        IPersistence persistenceAPI = new IPersistenceImp(implementor);

        //Object o = persistenceAPI.load("12343755");
        persistenceAPI.loadAll();


        // do changes to the object

        // then persist

        //persistenceAPI.persist(o);

        // can also change implementor
        //persistenceAPI = new IPersistenceImp(new XMLPersistenceImplementor());
        //persistenceAPI.loadAll();
    }

    private static boolean databaseDriverExists() {
        return false;
    }
}