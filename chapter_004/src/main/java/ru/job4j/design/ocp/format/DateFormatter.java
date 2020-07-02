package ru.job4j.design.ocp.format;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Class DateFormatter.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 13.08.2020
 */
public class DateFormatter {
    /**
     * Format string.
     *
     * @param calendar the calendar
     * @return the string
     */
    public static String format(Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.forLanguageTag("ru"));
        return sdf.format(calendar.getTime());
    }
}
