package persistence;

/**
 *
 * @author popoola
 */
public class PersistenceFactory {

    private static PersistenceFactory instance;

    private PersistenceFactory() {
    }

    public static synchronized PersistenceFactory getInstance(){
        if (instance == null){ instance = new PersistenceFactory(); }
        return instance;
    }

    public HardwarePersistenceMapper getHardwarePersistenceMapper(){
        return HardwarePersistenceMapper.getInstance();
    }

    public SoftwarePersistenceMapper getSoftwarePersistenceMapper(){
        return SoftwarePersistenceMapper.getInstance();
    }
}