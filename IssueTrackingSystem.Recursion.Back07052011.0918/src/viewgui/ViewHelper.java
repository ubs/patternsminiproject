package viewgui;

/**
 * View Helper Class
 * @author iXeon
 */
public class ViewHelper {

    private static String STR_SPACE = " ";
    private static StringBuilder strBuilder = new StringBuilder();
    
    private ViewHelper() {}

    public static String getSpace(long howMany){
        clearStringBuilder();
        for (int i = 0; i < howMany; i++) {
            strBuilder.append(STR_SPACE);
        }
        return strBuilder.toString();
    }

    private static void clearStringBuilder(){
        strBuilder.delete(0, strBuilder.length());
    }
}
