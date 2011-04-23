package persistence;

/**
 * @Pattern BRIDGE
 * @author iXeon
 */
public class IPersistenceImp implements IPersistence {

    private PersistenceImplementor implementor = null;

    public IPersistenceImp(PersistenceImplementor imp) {
        this.implementor = imp;
    }

    @Override
    public boolean persist(Object object){
        return implementor.persistObject(object);
    }

    @Override
    public boolean persistAll(Object[] objects){
        return implementor.persistAllObjects(objects);
    }

    @Override
    public Object load(String objectID){
        return implementor.loadObject(objectID.trim());
    }

    @Override
    public Object[] loadAll(){
        return implementor.loadAllObjects();
    }
}
