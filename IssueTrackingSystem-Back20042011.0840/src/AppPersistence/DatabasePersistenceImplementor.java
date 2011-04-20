package AppPersistence;

/**
 * @Pattern BRIDGE
 * @author iXeon
 */
public class DatabasePersistenceImplementor implements PersistenceImplementor {
    private Object connection;

    public DatabasePersistenceImplementor() {
        //Constructor load database driver & make connection
        connection = null;
    }

    @Override
    public void deleteObject(String objectId) {
        // DELETE FROM This WHERE That = Those
    }

    @Override
    public Object getObject(String objectId) {
        //Retrieve records & create object: SELECT * FROM ...
        return null;
    }

    @Override
    public String saveObject(Object object) {
        // Save Object: INSERT INTO This
        return "";
    }
}