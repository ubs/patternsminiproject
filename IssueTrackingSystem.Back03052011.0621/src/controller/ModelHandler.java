package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import persistence.IPersistence;
import persistence.IPersistenceImp;
import persistence.PersistenceImplementor;
import persistence.AppConfigXMLMapper;
import persistence.ArticleXMLMapper;
import persistence.CategoryXMLMapper;

/**
 * @PATTERN CONTROLLER
 * Pure Fabrication that Separates the View from the Model
 * @author iXeon
 */
public class ModelHandler {

    //Persistence Interface and Implementation (@Pattern: Bridge)
    private IPersistence persistenceAPI;
    private IPersistenceImp persistenceIMP;

    //Concrete File System Persistence Implementors
    private PersistenceImplementor catImplementor;
    private PersistenceImplementor appConfigImplementor;
    private PersistenceImplementor articleImplementor;

    public ModelHandler() {}

    public void loadModels() {
        try {
            catImplementor = new CategoryXMLMapper();
            appConfigImplementor = new AppConfigXMLMapper();
            articleImplementor = new ArticleXMLMapper();

            //Start with loading model for appConfig
            persistenceIMP = new IPersistenceImp(appConfigImplementor);
            persistenceAPI = persistenceIMP;
            persistenceAPI.loadAll();

            //Next is Category Model, Switch Implementor, Rock and Roll
            persistenceIMP.setImplementor(catImplementor);
            persistenceAPI.loadAll();

            //Next is Articles Model, Switch Implementor, Rock and Roll
            persistenceIMP.setImplementor(articleImplementor);
            persistenceAPI.loadAll();


        } catch (FactoryConfigurationError ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}