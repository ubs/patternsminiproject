package AppPersistence;

/**
 * Implementor Interface: The Implementation of the Persistence API
 * @Pattern BRIDGE
 * @author iXeon
 */
public interface PersistenceImplementor {

    public String saveObject(Object object);

    public void deleteObject(String objectId);

    public Object getObject(String objectId);
}
