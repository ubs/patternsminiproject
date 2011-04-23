package AppPersistence;

import java.io.File;
import java.io.FileInputStream;

/**
 * FileSystemPersistenceImplementor extends the Persistence Implementor Interface
 * to add file reading and writing functions
 * @author iXeon
 */
public interface FileSystemPersistenceImplementor extends PersistenceImplementor {
    public FileInputStream getFileInputStream(String filePath);
    public String readFromFile(File f);
    public boolean writeToFile(File f, String fileContent);
}
