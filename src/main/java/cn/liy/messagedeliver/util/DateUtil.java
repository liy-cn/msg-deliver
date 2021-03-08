package cn.liy.messagedeliver.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.util.Calendar.DATE;


/**
 * 日期工具类
 *
 * @author liy
 * @date 2021-03-08 21:47
 */
public class DateUtil {

    /**
     * 年-月-日 时:分:秒 显示格式
     */
    // 备注:如果使用大写HH标识使用24小时显示格式,如果使用小写hh就表示使用12小时制格式。
    public static String DATE_TO_STRING_DETAIAL_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 年-月-日 显示格式
     */
    public static String DATE_TO_STRING_SHORT_PATTERN = "yyyy-MM-dd";

    /**
     * eightClock HH:mm:ss
     */
    public static String EIGHT_CLOCK_SUFFIX = " 08:00:00";

    /**
     * 时间相减得到天数
     * 不写common端工具类里，减少PRC调用
     *
     * @param beginDate 开始日期
     * @param endDate   结束日期
     */
    public static long getDaySub(Date beginDate, Date endDate) {
        if (beginDate == null || endDate == null) {
            return 0;
        }
        return (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
    }

    /**
     * 时间相减得到月数
     * 不写common端工具类里，减少PRC调用
     *
     * @param beginDate 开始日期
     * @param endDate   结束日期
     */
    public static int getMonthSub(Date beginDate, Date endDate) {
        if (beginDate == null || endDate == null) {
            return 0;
        }
        return (int)(endDate.getTime() - beginDate.getTime())/(1000*60*60*24*30);
    }

    /**
     * 字符串转换为对应日期(可能会报错异常)
     *
     * @param source  source
     * @param pattern pattern
     * @return Date
     */
    public static Date stringToDate(String source, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Date类型转为指定格式的String类型
     *
     * @param source  source
     * @param pattern pattern
     * @return 指定格式的String类型
     */
    public static String dateToString(Date source, String pattern) {
        if (source == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(source);
    }

    /**
     * 功能描述：返回月
     *
     * @param date Date 日期
     * @return 返回月份
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 功能描述：返回日期
     *
     * @param date Date 日期
     * @return 返回日份
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取指定日期的第二天
     *
     * @param currentDate 指定日期
     * @return 指定日期的第二天
     */
    public static int getTomorrowDay(Date currentDate) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(currentDate);
        //把日期往后增加一天.整数往后推,负数往前移动
        calendar.add(DATE, 1);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前时间8点的Date
     *
     * @param currentDate 当前时间
     * @return 当前时间8点的Date
     */
    public static Date getTodayEightClock(Date currentDate) {
        String prefixDate = dateToString(currentDate, DATE_TO_STRING_SHORT_PATTERN);
        return stringToDate(prefixDate + EIGHT_CLOCK_SUFFIX, DATE_TO_STRING_DETAIAL_PATTERN);
    }

    /**
     * 获取当前日期昨天8点的Date
     *
     * @param currentDate 当前日期
     * @return 当前日期昨天8点的Date
     */
    public static Date getYesterdayEightClock(Date currentDate) {
        Date todayEightClock = getTodayEightClock(currentDate);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(todayEightClock);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 功能描述：返回小时
     *
     * @param date 日期
     * @return 返回小时
     */
    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 功能描述：返回分
     *
     * @param date 日期
     * @return 返回分钟
     */
    public static int getMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 返回秒钟
     *
     * @param date Date 日期
     * @return 返回秒钟
     */
    public static int getSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 功能描述：返回毫
     *
     * @param date 日期
     * @return 返回毫
     */
    public static long getMillis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

}
