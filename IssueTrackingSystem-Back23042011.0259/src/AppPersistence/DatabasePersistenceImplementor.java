package AppPersistence;

/**
 * @Pattern BRIDGE
 * @author iXeon
 */
public abstract class DatabasePersistenceImplementor implements PersistenceImplementor {
    private Object connection;

    public DatabasePersistenceImplementor() {
        //Constructor load database driver & make connection
        connection = null;
    }

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
        return null;
    }
}