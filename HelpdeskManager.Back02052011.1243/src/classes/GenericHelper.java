package classes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is a generic class that helps with some utility function
 * @author popoola
 */
public class GenericHelper {

    public static void printout(String info){
        System.out.println(info);
    }

    public static Date convertString2Date(String strDate){
        Date date = null;
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        try {
            date = dateFormat.parse(strDate);
        } catch (ParseException e){ date = null; }

        return date;
    }
}