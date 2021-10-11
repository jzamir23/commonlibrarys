package com.macwz.commonlibrarys.utils.adapter;

import com.blankj.utilcode.util.LogUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter {
    private static final ThreadLocal<SimpleDateFormat> local = new ThreadLocal<>();

    private static SimpleDateFormat getFormatter() {
        SimpleDateFormat sdf = local.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
            local.set(sdf);
        }
        return sdf;
    }

    private static SimpleDateFormat getFormatter(String format) {
        SimpleDateFormat sdf = local.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat(format, Locale.CHINA);
            local.set(sdf);
        }
        return sdf;
    }

    public static Date parse(String date) {
        if (date != null) {
            try {
                return getFormatter().parse(date);
            } catch (ParseException e) {
                LogUtils.w("data format not match.", e);
            }
        }
        return null;
    }

    public static Date parse(String date, String format) {
        if (date != null) {
            try {
                return getFormatter(format).parse(date);
            } catch (ParseException e) {
                LogUtils.w("data format not match.", e);
            }
        }
        return null;
    }

    public static String format(Date date) {
        if (date == null) {
            return "";
        }
        return getFormatter().format(date);
    }

    public static String format(Date date, String format) {
        if (date == null) {
            return "";
        }
        return getFormatter(format).format(date);
    }

    public static String format(long ms) {
        return getFormatter().format(new Date(ms));
    }
}
