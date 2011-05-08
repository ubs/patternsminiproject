package appclasses;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * IDate for handling date related functions
 * @author iXeon
 */
public class IDate {

    private IDate() {}

    public static Date stringToDate(String strDate) {
        Date date2Return = null;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date2Return = df.parse(strDate);
        } catch (ParseException e) {
            date2Return = null;
        }
        return date2Return;
    }

    public static String dateToString(Date date) {
        StringBuilder strDate;
        if (date == null){
            strDate = new StringBuilder("");
        }
        else {
            try {
                SimpleDateFormat dateformatMMDDYYYY = new SimpleDateFormat("MM/dd/yyyy");
                strDate = new StringBuilder( dateformatMMDDYYYY.format( date ) );
            } catch (Exception e){
                strDate = new StringBuilder("");
            }
        }

        return strDate.toString();
    }
}