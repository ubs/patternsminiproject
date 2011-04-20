package AppPersistence;

/**
 * @Pattern BRIDGE
 * @author iXeon
 */
public class PersistenceInterfaceImp implements PersistenceInterface {

    private PersistenceImplementor implementor = null;

    public PersistenceInterfaceImp(PersistenceImplementor imp) {
        this.implementor = imp;
    }

    @Override
    public void deleteById(String objectId) {
        implementor.deleteObject(objectId.trim());
    }

    @Override
    public Object findById(String objectId) {
        //return implementor.getObject(Long.parseLong(objectId));
        return implementor.getObject(objectId.trim());
    }

    @Override
    public String persist(Object object) {
        //return Long.toString( implementor.saveObject(object) );
        return implementor.saveObject(object);
    }
}
