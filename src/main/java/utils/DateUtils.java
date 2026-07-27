package utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtils {


    private DateUtils(){

    }


    public static String getCurrentDate(){

        return new SimpleDateFormat(
                "yyyy-MM-dd"
        )
                .format(new Date());

    }



    public static String getTimestamp(){

        return new SimpleDateFormat(
                "yyyyMMdd_HHmmss"
        )
                .format(new Date());

    }

}