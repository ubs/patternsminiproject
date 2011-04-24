package appclasses;

/**
 * IDebug for debugging outputs
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

    public static void printError(String info){
        str = baseStr + info;
        System.err.println(str);
    }

}
