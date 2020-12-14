package com.atguigu.javase.object;

import java.util.Objects;

/*
练习：写一个类MyDate, 包含属性year, month, day
在测试类中创建两个对象, 都是今天的日期, 打印d1.equals(d2)
如果想要完成对象的内容的真正比较, 应该怎么办?
*/
public class MyDate {

    private int year;
    private int month;
    private int day;


    public MyDate() {}

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String say() {
        return year + "年 " + month + "月 " + day + "日";
    }

    // 重写Object 类的 equals 方法
    @Override
    public boolean equals(Object obj) {     // 完成对象的真正的内容的比较
        if(this == obj) return true;    //
        if(obj == null || getClass() != obj.getClass()) return false;
        MyDate myDate = (MyDate)obj;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    // 调用现有的方法
    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    /*
    @Override
    public boolean equals(Object obj) { // 完成对象的真正的内容的比较
        if (obj instanceof MyDate &&
                this.year == ((MyDate)obj).year &&
                this.month == ((MyDate)obj).month &&
                this.day == ((MyDate)obj).day) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(year + "" + month + day);
    }
    */
}
