package com.myxh.smart.planet.order;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author MYXH
 * @date 2023/10/21
 * @description 日期操作工具类
 */
public class DateUtil
{
    private static final String dateFormat = "yyyy-MM-dd";
    private static final String timeFormat = "HH:mm:ss";

    /**
     * 格式化日期
     *
     * @param date 日期
     * @return 格式化日期
     */
    public static String formatDate(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

        return sdf.format(date);

    }

    /**
     * 格式化日期时间
     *
     * @param date 日期时间
     * @return 格式化日期时间
     */
    public static String formatTime(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);

        return sdf.format(date);

    }

    public static Date parseTime(String date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);

        try
        {
            return sdf.parse(date);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 截取比较断两个日期对象的 field 处的值
     * 如果第一个日期小于、等于、大于第二个，则对应返回负整数、0、正整数
     *
     * @param date1 第一个日期对象，非 null
     * @param date2 第二个日期对象，非 null
     * @param field Calendar 中的阈值
     * @return date1 > date2，返回：1
     * date1 = date2，返回：0
     * date1 < date2，返回：-1
     */
    public static int truncatedCompareTo(final Date date1, final Date date2, final int field)
    {
        return DateUtils.truncatedCompareTo(date1, date2, field);
    }

    /**
     * 比对日期大小
     *
     * @param beginDate 开始日期
     * @param endDate   结束日期
     * @return 比对日期大小
     */
    public static boolean dateCompare(Date beginDate, Date endDate)
    {
        if (null == beginDate || null == endDate)
        {
            return false;
        }

        return endDate.getTime() > beginDate.getTime();
    }

    /**
     * 比对日期时间大小
     *
     * @param beginDate 开始日期时间
     * @param endDate   结束日期时间
     * @return 比对日期时间大小
     */
    public static boolean timeCompare(Date beginDate, Date endDate)
    {
        Calendar instance1 = Calendar.getInstance();

        // 设置时间为当前时间
        instance1.setTime(beginDate);
        instance1.set(Calendar.YEAR, 0);
        instance1.set(Calendar.MONTH, 0);
        instance1.set(Calendar.DAY_OF_MONTH, 0);

        Calendar instance2 = Calendar.getInstance();

        // 设置时间为当前时间
        instance2.setTime(endDate);
        instance2.set(Calendar.YEAR, 0);
        instance2.set(Calendar.MONTH, 0);
        instance2.set(Calendar.DAY_OF_MONTH, 0);

        return DateUtil.truncatedCompareTo(instance1.getTime(), instance2.getTime(), Calendar.SECOND) != 1;
    }
}
