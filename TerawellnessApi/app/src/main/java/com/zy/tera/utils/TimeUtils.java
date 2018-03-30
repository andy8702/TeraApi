package com.zy.tera.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by yz250242 on 2018/3/27.
 */

public class TimeUtils {

    public static boolean isValidCard(String date) {
        java.util.Date nowdate=new java.util.Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        Date d = null;
        try {
            d = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean flag = d.before(nowdate);
        if(flag)
            return false;
        else
            return true;
    }

    public static String getTodayDate(){
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(day);
    }
}
