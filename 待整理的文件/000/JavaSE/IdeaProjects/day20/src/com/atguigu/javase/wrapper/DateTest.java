package com.atguigu.javase.wrapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date 类
 */
public class DateTest {

    public static void main(String[] args) {

        Date date = new Date();     // 产生一个Date实例对象
        // 产生一个 formater格式化的实例
        SimpleDateFormat formater = new SimpleDateFormat();
        System.out.println(formater.format(date));  // 打印输出默认的格式

        SimpleDateFormat formater2 = new SimpleDateFormat("yyyy年MM月dd日 EEE HH:mm:ss");
        System.out.println(formater2.format(date));

        // 实例化一个指定的格式对象
        // 按指定的格式输出
        try{
            Date date2 = formater2.parse("2020年04月14日 星期三 08:08:08");
            // 将指定的日期解析后格式化按指定的格式输出
            System.out.println(date2.toString());
        } catch(ParseException e) {
            e.printStackTrace();
        }
    }


    public static void main1(String[] args) {

        Date date = new Date();
        System.out.println(date);
        System.out.println(System.currentTimeMillis());
        System.out.println(date.getTime());

        Date date1 = new Date(date.getTime());
        System.out.println(date1.getTime());
        System.out.println(date1.toString());
    }
}
