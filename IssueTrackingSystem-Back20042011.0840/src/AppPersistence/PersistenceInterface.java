package AppPersistence;

/**
 * This class is the Persistence Interface for the application
 * @Pattern BRIDGE
 * @author iXeon
 */
public interface PersistenceInterface {
    /**
     * persist the Object, to be implemented by Implementor
     * @param object
     * @return returns objectID
     */
    public String persist(Object object);

    /**
     * For retreiving objects from persistent storage
     * @param objectId
     * @return persisted Object
     */
    public Object findById(String objectId);

    /**
     * Delete object from storage
     * @param id
     */
    public void deleteById(String id);
}
