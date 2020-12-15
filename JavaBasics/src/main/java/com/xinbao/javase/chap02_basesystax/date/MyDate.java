package com.xinbao.javase.chap02_basesystax.date;

/**
 * 写一个类 MyDate, 属性 year，month，day，方法 String say（）
 */
public class MyDate {
    int year = 2020;
    int month = 12;
    int day = 15;

    public String say() {
        String str = year + "年" + month + "月" + day + "日";
        return str;
    }
}
