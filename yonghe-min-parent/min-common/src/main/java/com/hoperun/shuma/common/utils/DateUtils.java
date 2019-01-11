package com.hoperun.shuma.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

/**
 * @author ZC
 * @date 2017/10/9
 */
public class DateUtils {

    /**
     * 默认时间格式
     */
    public static final String DATETIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 毫秒
     */
    public static final String DATETIME_MS_DEFAULT_FORMAT = "ddMMyyyyHHmmssSSS";

    public static final String DATE_DEFAULT_FORMAT = "yyyyMMdd";
    /**
     * 时间格式化
     */
    private static DateFormat dateTimeFormat = null;
    private static DateFormat dateTimeMSFormat = null;
    private static DateFormat dateFormat = null;

    static {
        dateTimeFormat = new SimpleDateFormat(DATETIME_DEFAULT_FORMAT);
        dateTimeMSFormat = new SimpleDateFormat(DATETIME_MS_DEFAULT_FORMAT);
        dateFormat = new SimpleDateFormat(DATE_DEFAULT_FORMAT);
    }

    public static String getTimeFormat(Date date) {
        return dateTimeFormat.format(date);
    }

    public static String getDateFormat(Date date) {
        return dateFormat.format(date);
    }

    public static Date getDateFormat(String date) throws ParseException {
        return dateFormat.parse(date);
    }

    public static Date convertStr(String date) {
        LocalDate day = LocalDate.parse(date);
        return LocalDateToUdate(day);
    }

    /**
     * java.util.Date --> java.time.LocalDateTime
     */
    public static LocalDateTime UDateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * java.util.Date --> java.time.LocalDate
     */
    public static LocalDate UDateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalDate();
    }

    /**
     * java.util.Date --> java.time.LocalTime
     */
    public static LocalTime UDateToLocalTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalTime();
    }


    /**
     * java.time.LocalDateTime --> java.util.Date
     */
    public static Date LocalDateTimeToUdate(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }


    /**
     * java.time.LocalDate --> java.util.Date
     */
    public static Date LocalDateToUdate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * java.time.LocalTime --> java.util.Date
     */
    public static Date LocalTimeToUdate(LocalTime localTime, LocalDate localDate) {
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 时间到毫秒格式化
     *
     * @return
     */
    public static String getDatetimeMsDefaultFormat() {
        return dateTimeMSFormat.format(new Date());
    }
}
