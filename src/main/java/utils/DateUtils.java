package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String getTimeStamp(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

}
