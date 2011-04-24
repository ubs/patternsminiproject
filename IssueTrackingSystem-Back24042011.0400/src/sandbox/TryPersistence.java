package sandbox;

import appclasses.ArticleModel;
import appclasses.CategoryModel;
import persistence.CategoryXMLMapper;
import persistence.AppConfigXMLMapper;
import persistence.ArticleXMLMapper;

import appclasses.IDebug;

import persistence.PersistenceImplementor;
import persistence.IPersistence;
import persistence.IPersistenceImp;
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
        PersistenceImplementor implementor2 = null;
        PersistenceImplementor implementor3 = null;

        if (databaseDriverExists()) {
            //implementor = new DatabasePersistenceImplementor();
        } else {
            try {
                implementor = new CategoryXMLMapper();
                implementor2 = new AppConfigXMLMapper();
                implementor3 = new ArticleXMLMapper();
            } catch (FactoryConfigurationError ex) {
                Logger.getLogger(TryPersistence.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(TryPersistence.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(TryPersistence.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        IPersistence persistenceAPI = new IPersistenceImp(implementor);
        IPersistence persistenceAPI2 = new IPersistenceImp(implementor2);
        IPersistence persistenceAPI3 = new IPersistenceImp(implementor3);

        //Object o = persistenceAPI.load("12343755");
        persistenceAPI.loadAll();
        persistenceAPI2.loadAll();
        persistenceAPI3.loadAll();

        

        //IDebug.print("Count of Categories = " + CategoryModel.getInstance().getTotalCount());
        //ArticleModel.getInstance().dumpArticles();


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