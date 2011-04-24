package persistence;

/**
 * Implementor Interface: The Implementation of the Persistence API
 * @Pattern BRIDGE
 * @author iXeon
 */
public interface PersistenceImplementor {
    public boolean persistObject(Object object);

    public boolean persistAllObjects(Object[] objects);

    public Object loadObject(String objectID);

    public Object[] loadAllObjects();
}
