package com.share.utils;

import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/**
 * 通用的自定义时间工具类
 *
 * @author dupenghui
 * @date 2018-07-06 18:43
 */
public class CommonDateUtil {

    /**
     * 获取当前时间的时间戳（秒数）
     *
     * @author dupenghui
     * @date 2018-07-13 10:45
     * @return long
     */
    public static long getCurrentTimestamp() {
        return Instant.now().getEpochSecond();
    }

    /**
     * 获取和当前天相差多少年月日，此方法常用语求多少岁，xx岁xx月xx天
     *
     * 目标天 < 当前天 正值
     * 目标天 = 当前天 年月日都是0
     * 目标天 > 当前天 负值
     *
     * getDays() - 获取天数
     * getMonths() - 获取月数
     * getYears() - 获取年数
     *
     * @param targetTime - 目标时间 单位是时间戳（秒）
     * @return java.time.Period
     * @author dupenghui
     * @date 2018-07-11 11:03
     */
    public static Period getPeriodUntilToday(long targetTime) {
        LocalDate localDate = LocalDateTime.ofInstant(Instant.ofEpochSecond(targetTime), ZoneId.systemDefault()).toLocalDate();
        return Period.between(localDate, LocalDate.now());
    }

    /**
     * 获取和当前时间相差多少秒、毫秒等
     *
     * 目标时间 < 当前时间 正值
     * 目标时间 = 当前时间 年月日都是0
     * 目标时间 > 当前时间 负值
     *
     * getSeconds() - 获取秒数
     * toMillis() - 获取毫秒数
     *
     * @param targetTime - 目标时间 单位是时间戳（秒）
     * @return java.time.Duration
     * @author dupenghui
     * @date 2018-07-11 11:03
     */
    public static Duration getDurationUntilNow(long targetTime) {
        return Duration.between(Instant.ofEpochSecond(targetTime), Instant.now());
    }

    /**
     * 目标时间距当前时间的总小时数
     *
     * @author dupenghui
     * @date 2018-07-13 10:31
     * @param startTime  - 目标时间 单位是时间戳（秒）
     * @return long
     */
    public static long getTotalMinutesUntilNow(long startTime) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(startTime), ZoneId.systemDefault());
        return ChronoUnit.MINUTES.between(localDateTime, LocalDateTime.now());
    }

    /**
     * 目标时间距当前时间的总小时数
     *
     * @author dupenghui
     * @date 2018-07-13 10:31
     * @param startTime  - 目标时间 单位是时间戳（秒）
     * @return long
     */
    public static long getTotalHoursUntilNow(long startTime) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(startTime), ZoneId.systemDefault());
        return ChronoUnit.HOURS.between(localDateTime, LocalDateTime.now());
    }

    /**
     * 目标时间距今天的总天数
     *
     * @author dupenghui
     * @date 2018-07-13 10:31
     * @param startDateTime  - 目标时间 单位是时间戳（秒）
     * @return long
     */
    public static long getTotalDaysUntilToday(long startDateTime) {
        LocalDate localDate = LocalDateTime.ofInstant(Instant.ofEpochSecond(startDateTime), ZoneId.systemDefault()).toLocalDate();
        return ChronoUnit.DAYS.between(localDate, LocalDate.now());
    }

    /**
     * 目标时间距今天的总月数
     *
     * @author dupenghui
     * @date 2018-07-13 10:31
     * @param startDateTime  - 目标时间 单位是时间戳（秒）
     * @return long
     */
    public static long getTotalMonthsUntilToday(long startDateTime) {
        LocalDate localDate = LocalDateTime.ofInstant(Instant.ofEpochSecond(startDateTime), ZoneId.systemDefault()).toLocalDate();
        return ChronoUnit.MONTHS.between(localDate, LocalDate.now());
    }

    /**
     * 目标时间距今天的总年数
     *
     * @author dupenghui
     * @date 2018-07-13 10:31
     * @param startDateTime  - 目标时间 单位是时间戳（秒）
     * @return long
     */
    public static long getTotalYearsUntilToday(long startDateTime) {
        LocalDate localDate = LocalDateTime.ofInstant(Instant.ofEpochSecond(startDateTime), ZoneId.systemDefault()).toLocalDate();
        return ChronoUnit.YEARS.between(localDate, LocalDate.now());
    }

    /**
     * 获取本月第一天的0点时间戳
     *
     * @author dupenghui
     * @date 2018-07-11 20:23
     * @return long
     */
    public static long getStartTimeOfThisMonth() {
        return LocalDateTime.now()
                .with(TemporalAdjusters.firstDayOfMonth())
                .with(LocalTime.MIN)
                .atZone(ZoneId.systemDefault())
                .toEpochSecond();
    }

    /**
     * 获取指定时间所在月第一天的0点时间戳
     *
     * @author dupenghui
     * @date 2018-07-11 20:23
     * @return long
     */
    public static long getStartTimeOfMonth(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault())
                .with(TemporalAdjusters.firstDayOfMonth())
                .with(LocalTime.MIN)
                .atZone(ZoneId.systemDefault())
                .toEpochSecond();
    }

    /**
     * 获取本月最后一天的23点59分59秒时刻
     *
     * @author dupenghui
     * @date 2018-07-11 20:23
     * @return long
     */
    public static long getEndTimeOfThisMonth() {
        return LocalDateTime.now()
                .with(TemporalAdjusters.lastDayOfMonth())
                .with(LocalTime.MAX)
                .atZone(ZoneId.systemDefault())
                .toEpochSecond();
    }

    /**
     * 获取指定时间所在月最后一天的23点59分59秒时刻
     *
     * @author dupenghui
     * @date 2018-07-11 20:23
     * @return long
     */
    public static long getEndTimeOfMonth(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault())
                .with(TemporalAdjusters.lastDayOfMonth())
                .with(LocalTime.MAX)
                .atZone(ZoneId.systemDefault())
                .toEpochSecond();
    }

    /**
     * 获取本周周一的0点时间戳
     *
     * @author dupenghui
     * @date 2018-07-11 20:23
     * @return long
     */
    public static long getStartTimeOfThisWeek() {
        return LocalDateTime.now()
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
                .with(LocalTime.MIN)
                .atZone(ZoneId.systemDefault())
                .toEpochSecond();
    }

    /**
     * 获取指定时间所在周周一的0点时间戳
     *
     * @author dupenghui
     * @date 2018-07-11 20:23
     * @return long
     */
    public static long getStartTimeOfWeek(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault())
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
                .with(LocalTime.MIN)
                .atZone(ZoneId.systemDefault())
                .toEpochSecond();
    }

    /**
     * 获取本周周日的23点59分59秒时刻
     *
     * @author dupenghui
     * @date 2018-07-11 20:23
     * @return long
     */
    public static long getEndTimeOfThisWeek() {
        return LocalDateTime.now()
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY))
                .with(LocalTime.MAX)
                .atZone(ZoneId.systemDefault())
                .toEpochSecond();
    }

    /**
     * 获取指定时间所在周周日的23点59分59秒时刻
     *
     * @author dupenghui
     * @date 2018-07-11 20:23
     * @return long
     */
    public static long getEndTimeOfWeek(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault())
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY))
                .with(LocalTime.MAX)
                .atZone(ZoneId.systemDefault())
                .toEpochSecond();
    }

    /**
     * 获取指定时间戳对应的当天的0点时刻
     *
     * @author dupenghui
     * @date 2018-07-12 9:55
     * @param timestamp  - 指定时间戳
     * @return long
     */
    public static long getStartTimeOfDay(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault())
                .with(LocalTime.MIN)
                .atZone(ZoneId.systemDefault())
                .toEpochSecond();
    }

    /**
     * 获取今天的0点时刻
     *
     * @author dupenghui
     * @date 2018-07-12 9:55
     * @return long
     */
    public static long getStartTimeOfToday() {
        return LocalDateTime.now()
                .with(LocalTime.MIN)
                .atZone(ZoneId.systemDefault())
                .toEpochSecond();
    }

    /**
     * 获取指定时间戳对应的当天的23点59分59秒时刻
     *
     * @author dupenghui
     * @date 2018-07-12 9:55
     * @param timestamp  - 指定时间戳
     * @return long
     */
    public static long getEndTimeOfDay(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault())
                .with(LocalTime.MAX)
                .atZone(ZoneId.systemDefault())
                .toEpochSecond();
    }

    /**
     * 获取今天的23点59分59秒时刻
     *
     * @author dupenghui
     * @date 2018-07-12 9:55
     * @return long
     */
    public static long getEndTimeOfToday() {
        return LocalDateTime.now()
                .with(LocalTime.MAX)
                .atZone(ZoneId.systemDefault())
                .toEpochSecond();
    }

    /**
     * 获取指定时间戳是星期几，1 代表 星期一 2 代表 星期二 。。。
     *
     * @author dupenghui
     * @date 2018-07-13 14:17
     * @param timestamp  - 指定时间戳（秒）
     * @return long
     */
    public static int getWeekDayFromTimestamp(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault()).getDayOfWeek().getValue();
    }

    /**
     * 获取指定时间戳是星期几，eg: 星期一 星期二 。。。
     *
     * @author dupenghui
     * @date 2018-07-13 14:17
     * @param timestamp  - 指定时间戳（秒）
     * @return long
     */
    public static String getWeekDayFormatFromTimestamp(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault()).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.SIMPLIFIED_CHINESE);
    }

}
