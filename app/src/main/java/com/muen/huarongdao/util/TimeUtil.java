package com.muen.huarongdao.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TimeUtil {
    public static String transformTimeFromMillisToFormat(long ms, String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(ms);
    }

    public static String format(String str, Object... args) {
        return String.format(str, args);
    }
}
