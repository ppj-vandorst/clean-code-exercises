package src.methods;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TextFormatter {
    private static String DATE_FORMAT = "yyyy-MM-dd";
    private static String TIME_FORMAT = "'T'HH:mm:ss.SSS";
    private static String AM_PM_FORMAT = "XXX";

    public String parseDate(Date date) {
        return parseDate(date, DATE_FORMAT);
    }

    public String parseDateWithTime(Date date) {
        return parseDate(date, DATE_FORMAT + TIME_FORMAT);
    }

    public String parseDateWithTimeAndTimezone(Date date) {
        return parseDate(date, DATE_FORMAT + TIME_FORMAT + AM_PM_FORMAT);
    }

    private String parseDate(Date date, String format) {
        SimpleDateFormat sdf;

        sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(TimeZone.getTimeZone("CET"));
        return sdf.format(date);
    }
}

class Main3 {
    public static void main(String[] args) {
        TextFormatter formatter = new TextFormatter();
        String result1 = formatter.parseDate(new Date());
        String result2 = formatter.parseDateWithTime(new Date());
        String result3 = formatter.parseDateWithTimeAndTimezone(new Date());
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}