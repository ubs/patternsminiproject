package AppPersistence;

import java.io.File;

/**
 * @Pattern BRIDGE
 * @author iXeon
 */
//public abstract class FileSystemPersistenceImplementor implements PersistenceImplementor {
public class FileSystemPersistenceImplementor implements PersistenceImplementor {

    @Override
    public void deleteObject(String objectId) {
        try {
            File f = new File("/persistence/" + objectId);
            f.delete();
        } catch (Exception e) {
            //Hold On
        }
    }

    @Override
    public Object getObject(String objectId) {
        File f = new File("/persistence/" + objectId);
        return readObjectFromFile(f);
    }

    @Override
    public String saveObject(Object object) {
        long fileId = System.currentTimeMillis();
        
        // open file
        File f = new File("/persistence/" + Long.toString(fileId));

        // write file to Streanm
        writeObjectToFile(f, object);
        return Long.toString(fileId);
    }

    private Object readObjectFromFile(File f) {
        // open file, load object and return the object
        return null;
    }

    private void writeObjectToFile(File f, Object object) {
        // serialize object and write it to file
        System.out.println("Writing Object: " + object + " to File: " + f);
    }
}