package persistence;

/**
 * Generates IDs for Persistent Objects
 * @author iXeon
 */
public class IDGenerator {

    private IDGenerator() {
        //Prevent Instantiation, use static methods only
    }

    public static String getID(){
        long nextID = System.currentTimeMillis();
        return String.valueOf(nextID);
    }
}
