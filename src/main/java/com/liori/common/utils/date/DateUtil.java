package com.liori.common.utils.date;

import com.liori.common.exceptions.CustomizeServiceException;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * <p>时间处理工具类</p>
 * <b>created on 2019-01-03 17:50:48</b>
 *
 * @author liori
 * @since springboot-mybatis-0.0.1-SNAPSHOT
 */
public class DateUtil {

    private final static Long ONE_DAY_MILLIS = 60000 * 60 * 24L;

    /**
     * 获得本周一与当前日期相差的天数
     *
     * @return
     */
    public static int getMondayPlus() {
        Calendar cd = Calendar.getInstance();
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) {
            return -6;
        } else {
            return 2 - dayOfWeek;
        }
    }

    /**
     * 获取当日的开始时间
     *
     * @return
     */
    public static Long getCurrentDayStartTime() {
        long current = System.currentTimeMillis();
        return current / ONE_DAY_MILLIS * ONE_DAY_MILLIS - TimeZone.getDefault().getRawOffset();

    }

    /**
     * 获取当日的结束时间
     *
     * @return
     */
    public static Long getCurrentDayEndTime() {
        long current = System.currentTimeMillis();
        long zero = current / ONE_DAY_MILLIS * ONE_DAY_MILLIS - TimeZone.getDefault().getRawOffset();
        return zero + ONE_DAY_MILLIS - 1;
    }

    /**
     * 获得当前周 周一的开始时间
     *
     * @return
     */
    public static Long getCurrentMonday() {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        // 将时、分、秒、毫秒 清零
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.MILLISECOND, 0);
        Date monday = currentDate.getTime();

        return monday.getTime();
    }


    /**
     * 获得当前周 周日的开始时间
     *
     * @return
     */
    public static Long getCurrentSunday() {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
        // 将时、分、秒、毫秒 清零
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.MILLISECOND, 0);
        Date sunday = currentDate.getTime();
        return sunday.getTime();
    }

    /**
     * 获得当前月 第一天的开始日期
     *
     * @return
     */
    public static Long getCurrentMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        // 将时、分、秒、毫秒 清零
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime().getTime();
    }

    /**
     * 获得当前月 最后一天的开始时间
     *
     * @return
     */
    public static Long getCurrentMonthLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        // 将时、分、秒、毫秒 清零
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime().getTime();
    }

    /**
     * 时间转换
     * 毫秒转字符串格式
     *
     * @param millisecond
     * @param format
     * @return
     */
    public static String timestampToDateString(Long millisecond, String format) {
        if (ObjectUtils.isEmpty(millisecond) || StringUtils.isEmpty(format)) {
            throw new CustomizeServiceException("request parameters cannot be null");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(millisecond));
    }

    /**
     * 日期转换
     * 字符串转时间戮
     *
     * @param dateString
     * @param format
     * @return
     */
    public static Long dateStringToTimestamp(String dateString, String format) {
        if (StringUtils.isEmpty(dateString) || StringUtils.isEmpty(format)) {
            throw new CustomizeServiceException("request parameters cannot be null");
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            throw new CustomizeServiceException("字符串转时间戮时出现异常", e);
        }
        return date.getTime();
    }
}