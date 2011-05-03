package persistence;

/**
 *
 * @author popoola
 */
public class SoftwarePersistenceMapper {
    private static SoftwarePersistenceMapper instance;

    private SoftwarePersistenceMapper() {
    }

    public static synchronized SoftwarePersistenceMapper getInstance(){
        if (instance == null){ instance = new SoftwarePersistenceMapper(); }
        return instance;
    }
}
