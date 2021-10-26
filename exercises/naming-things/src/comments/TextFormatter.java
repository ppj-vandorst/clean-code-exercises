package src.comments;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TextFormatter {

    public String parseDateInISOFormat(Date date, boolean withTime, boolean twelveHours) {
        SimpleDateFormat sdf;
        String format = "yyyy-MM-dd'T'";
        if (withTime) {
            format = format + "HH:mm:ss.SSS";
        }
        if (twelveHours) {
            format = format + "XXX";
        }
        sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(TimeZone.getTimeZone("CET"));
        return sdf.format(date);
    }

    // TODO: bug in library, might be broken
    public String formatText(String text) {
        Library.doComplexStuff(text);
        return text;
    }
}
