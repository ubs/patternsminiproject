package persistence;

/**
 * This class is the Persistence Interface for the application
 * @Pattern BRIDGE
 * @author iXeon
 */
public interface IPersistence {
    /**
     * persist the Object, to be implemented by Implementor
     * @param object
     * @return returns objectID
     */
    public boolean persist(Object object);
    public boolean persistAll(Object[] objects);

    /**
     * Load the object from persistent storage, to be implemented by Implementor
     * @param objectID String
     * @return Object
     */
    public Object load(String objectID);
    public Object[] loadAll();
}
