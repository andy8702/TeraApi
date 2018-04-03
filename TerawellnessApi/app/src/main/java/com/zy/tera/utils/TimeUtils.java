package com.zy.tera.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by yz250242 on 2018/3/27.
 */

public class TimeUtils {

    public static boolean isValidCard(String date) {
        java.util.Date nowdate = new java.util.Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        Date d = null;
        try {
            d = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean flag = d.before(nowdate);
        if (flag)
            return false;
        else
            return true;
    }

    public static String getTodayDate() {
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(day);
    }

    public static int[] getYYYYMMDD() {
        Calendar rightNow = Calendar.getInstance();
        /*用Calendar的get(int field)方法返回给定日历字段的值。
        HOUR 用于 12 小时制时钟 (0 - 11)，HOUR_OF_DAY 用于 24 小时制时钟。*/
        int year = rightNow.get(Calendar.YEAR);
        int month = rightNow.get(Calendar.MONTH);
        int day = rightNow.get(rightNow.DAY_OF_MONTH);

        int[] date = new int[3];
        date[0] = year;
        date[1] = month;
        date[2] = day;

        return date;
    }

    public static String formateYYYYMMDD(int YYYY,int MM,int DD){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(YYYY+"-");

        int M = MM+1;
        int D = DD;

        if (M<10){
            stringBuffer.append("0"+M+"-");
        }else{
            stringBuffer.append(M+"-");
        }

        if (D<10){
            stringBuffer.append("0"+D);
        }else{
            stringBuffer.append(D);
        }

        return stringBuffer.toString();
    }
}
