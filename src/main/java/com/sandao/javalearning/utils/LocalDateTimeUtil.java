package com.sandao.javalearning.utils;

import lombok.NonNull;

import java.time.*;
import java.util.Date;

/**
 * 时间工具类
 * @author maoyanting
 * @version V1.0
 * @date 2019/07/30
 */
public class LocalDateTimeUtil {


    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate nextDay = now.plusDays(1);
        LocalDate nextMouth = now.plusMonths(1);
        System.out.println(nextDay);
        System.out.println(nextMouth);

        System.out.println(!now.isAfter(now));
//        LocalDate localDate = now.toLocalDate();
//        LocalTime localTime = now.toLocalTime();
//        System.out.println("当前时间：" + now);
//        System.out.println("当前日期：" + localDate);
//        System.out.println("当前日期：" + LocalDate.now());
//        System.out.println("当前时间（24小时制）：" + localTime);

    }

    /**
     * date类型转localdate
     */
    public static LocalDate toLocalDate(@NonNull Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        return localDate;
    }

    /**
     * localdate转date
     */
    public static Date toDate(@NonNull LocalDate localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * date类型时间累加
     */
    public static Date plusDay(Date date, long days) {
        return toDate(toLocalDate(date).plusDays(days));
    }

    /**
     * 计算一个月内两个日期相差天数
     */
    public static Integer differDayInSameMonth(@NonNull LocalDate localDate1, @NonNull LocalDate localDate2) {
        LocalDate localDateFrom, localDateTo;
        if (localDate1.isBefore(localDate2)) {
            localDateFrom = localDate1;
            localDateTo = localDate2;
        } else {
            localDateFrom = localDate2;
            localDateTo = localDate1;
        }
        Period period = Period.between(localDateFrom, localDateTo);
        return period.getDays();
    }

    /**
     * 计算不同月份两个日期相差天数
     */
    public static Long differDay(@NonNull LocalDate localDate1, @NonNull LocalDate localDate2) {
        return localDate1.isBefore(localDate2) ? localDate2.toEpochDay() - localDate1.toEpochDay() : localDate1.toEpochDay() - localDate2.toEpochDay();
    }

    /**
     * 计算两个日期相差天数
     */
    public static int differDayInSameMonth(Date Date1, Date Date2) {
        return differDayInSameMonth(toLocalDate(Date1), toLocalDate(Date2));
    }

    /**
     * 计算两个日期相差天数
     */
    public static Long differDay(Date Date1, Date Date2) {
        return differDay(toLocalDate(Date1), toLocalDate(Date2));
    }
}
