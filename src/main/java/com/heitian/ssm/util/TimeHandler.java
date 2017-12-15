package com.heitian.ssm.util;


import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/27.
 */
public class TimeHandler {

    public static String getTime(String time) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = null;
        try {
            d1 = df.parse(time);
            Date d2 = df.parse(df.format(new Date()));
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(df.parse(time));
            c2.setTime(df.parse(df.format(new Date())));
            long month = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
            long between = (d2.getTime() - d1.getTime()) / 1000;//除以1000是为了转换成秒
            long day1 = between / (24 * 3600);
            long hour1 = between % (24 * 3600) / 3600;
            long minute1 = between % 3600 / 60;
            long second1 = between % 60 / 60;
            if (month > 0)
                return month + "月前";
            else if (day1 > 0)
                return day1 + "天前";
            else if (hour1 > 0)
                return hour1 + "小时前";
            else if (minute1 > 0)
                return minute1 + "分钟前";
            else
                return second1 + "秒前";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getTimeNow() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());
        return time;
    }
}
