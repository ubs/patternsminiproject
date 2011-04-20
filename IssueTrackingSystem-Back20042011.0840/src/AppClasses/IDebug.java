package AppClasses;

/**
 *
 * @author iXeon
 */
public class IDebug {
    private static String baseStr = "[iDebug]: ";
    private static String str;
    
    private IDebug() {}

    public static void print(String info){
        str = baseStr + info;
        System.out.println(str);
    }

}
