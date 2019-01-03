package com.sys.gateway.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @auth LD
 * @date 2019-01-03
 *
 * */
public class DateUtils {

    //两种常见日期类型
    public static final DateFormat YYYYMMDDHHMISS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final DateFormat YYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");

    //日期类型
    public enum DateType{
        YEAR(0L),
        MONTH(2L),
        DAY(24*60*60*1000L),
        HOUR(60*60*1000L),
        MINUTE(60000L),
        SECOND(1000L),
        MILLISECOND(1L);

        private Long index;

        DateType(Long index){
            this.index = index;
        }

        public Long getIndex(){
           return this.index;
        }

    }

    /*===============================获取当前时间==================================*/

    /**
     * 查询当前String时间
     *
     * @param df 时间模板
     * @return String类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static String currentTimeString(DateFormat df){
        if(df == null){
            df = YYYYMMDDHHMISS;
        }
        return df.format(new Date());
    }

    /**
     * 查询当前Long时间戳
     *
     * @return String类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static Long currentTimeLong(){
        return System.currentTimeMillis();
    }

    /**
     * 查询当前Date时间
     *
     * @return String类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static Date currentTimeDate(){
        return new Date();
    }

    /*===============================时间转换==================================*/

    /**
     * Long --> String
     *
     * @param df 时间模板
     * @param date 需要转换的时间参数
     * @return String类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static String timeLong2String(DateFormat df, Long date){
        if(df == null){
            df = YYYYMMDDHHMISS;
        }
        return df.format(new Date(date));
    }

    /**
     * Date --> String
     *
     * @param df 时间模板
     * @param date 需要转换的时间参数
     * @return String类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static String timeDate2String(DateFormat df, Date date){
        if(df == null){
            df = YYYYMMDDHHMISS;
        }
        return df.format(date);
    }

    /**
     * Date --> Long
     *
     * @param date 需要转换的时间参数
     * @return Long类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static Long timeDate2Long(Date date){
        return date.getTime();
    }

    /**
     * String --> Long
     *
     * @param date 需要转换的时间参数
     * @return Long类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static Long timeString2Long(String date) throws ParseException{
        return YYYYMMDDHHMISS.parse(date).getTime();
    }

    /**
     * Long --> Date
     *
     * @param date 需要转换的时间参数
     * @return Date类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static Date timeLong2Date(Long date){
        return new Date(date);
    }

    /**
     * String --> Date
     *
     * @param date 需要转换的时间参数
     * @return Date类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static Date timeString2Date(String date) throws ParseException{
        return YYYYMMDDHHMISS.parse(date);
    }

    /*===============================时间计算==================================*/

    /**
     * String时间差(end - begin)
     *
     * @param begin 开始时间
     * @param end 结束时间
     * @param df 时间模板
     * @param dateType 返回时间类型（年月日时分秒）,从DateType中获取 DateType.YEAR.getIndex();
     * @return Long型时间差
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static Long timeStringMinus(String begin, String end, DateFormat df, Long dateType) throws ParseException{
        if(dateType != DateType.YEAR.getIndex() && dateType != DateType.MONTH.getIndex()){
            Long resultMillisecond = df.parse(end).getTime() - df.parse(begin).getTime();
            return resultMillisecond/dateType;
        }

        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(df.parse(end));
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(df.parse(begin));
        if(dateType == DateType.YEAR.getIndex()){
            return Long.valueOf(calEnd.get(Calendar.YEAR) - calBegin.get(Calendar.YEAR));
        }
        return Long.valueOf(calEnd.get(Calendar.MONTH) - calBegin.get(Calendar.MONTH));
    }
}
