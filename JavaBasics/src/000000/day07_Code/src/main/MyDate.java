package main;

/**
 * 总和练习：写一个 MyDate类，包含属性：year，month，day
 * 提供2个构造器，要求无参构造器创建的对象代表你的生日
 * 在测试类中创建两个对象，一个是你的生日，另一个是今天的日期
 */
public class MyDate {

    // 第一步：定义属性，考虑封装
    private int year;
    private int month;
    private int day;


    // 第二部：定义构造器，2个
    public MyDate(){
        //this.year = 1991;
        //this.month = 9;
        //this.day = 7;
        this(1991, 9, 7);   // 通过间接调用全参构造器完成初始化
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }


    // 第三步：定义 set 和 get 方法
    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }


    // 第四部：提供 say() 方法
    public String say(){
        return year + "年，" + month + "月，" + day + "日";
    }

    // 提供其他方法
    public void hobby(){
        System.out.println("写代码");
    }
}
