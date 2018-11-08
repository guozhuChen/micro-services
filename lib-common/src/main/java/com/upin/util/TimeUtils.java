package com.upin.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Created by Leslie on 2018/7/18.
 */
public class TimeUtils {
    /**
     * java中的时间格式字符串精确到秒<br>
     * 值 : yyyy-MM-dd HH:mm:ss
     */
    private final static String FORAMTER = "yyyy-MM-dd HH:mm:ss";



    /**
     * 得到当前时间
     */

    public static Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 日期转换字符串
     */
    public static String dateToString(Date date) {
        if (date == null){
            return null ;
        }
        SimpleDateFormat format = new SimpleDateFormat(FORAMTER);
        return format.format(date);
    }

    /**
     * 字符串转换日期
     */
    public static Date stringToDate(String str){
        if (StringUtils.isBlank(str)){
            return null ;
        }
        SimpleDateFormat format = new SimpleDateFormat(FORAMTER);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
