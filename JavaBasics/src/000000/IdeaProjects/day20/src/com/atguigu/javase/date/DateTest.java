package com.atguigu.javase.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Date 可以用来表示日期，也包括时间
 *      缺点是创建对象极其不方便，因为它处理日期时间有基础值。
 *
 * Calendar 日历：内部使用一个大的 int[] 来保存所有数据
 *      访问数据时必须要提供下标，下标值用常量表示
 *      缺点：月份存储小于1，读取或设置属性都不方便。内容是可变的
 *
 * Java8中的新API，所有数据存储都是真实的，内容不可改变（安全）。所有的修改都会产生新对象。
 *      LocalDate   处理日期
 *      LocalTime   处理时间
 *      LocalDateTime   处理日期时间
 *      DateTimeFormatter   时间格式化器
 */
public class DateTest {

    /**
     * 直接创建时间
     */
    @Test
    public void test5() {
        // 日期，使用of直接创建日期对象
        LocalDate date1 = LocalDate.of(2008,8,8);
        System.out.println(date1);

        // 时间
        LocalTime time = LocalTime.now();
        System.out.println(time);

        // 日期时间
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        // 日期时间格式化器
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        String formatDate = dtf.format(dateTime);
        System.out.println(formatDate);
    }


    /**
     * 练习：创建一个 LocalDate 对象，把它变成你的生日，获取你的百日。打印输出
     */
    @Test
    public void exer3() {

        LocalDate date = LocalDate.now();

        LocalDate myDate = date
                .withYear(1991)
                .withMonth(9)
                .withDayOfMonth(7)
                .plusDays(100);
        System.out.println(myDate);
    }


    /**
     * Java8 新的API
     */
    @Test
    public void test4() {

        LocalDate date1 = LocalDate.now();
        System.out.println(date1);

        int year = date1.getYear();
        int month = date1.getMonthValue();
        int day = date1.getDayOfMonth();
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);

        //
        DayOfWeek dayOfWeek = date1.getDayOfWeek();  // 星期
        System.out.println(dayOfWeek);
        int dayOfYear = date1.getDayOfYear();       // 年中的天
        System.out.println(dayOfYear);

        // 一旦修改就会产生新对象
        LocalDate date2 = date1.withYear(2008);    // 伴随着修改产生新对象
        LocalDate date3 = date2.withMonth(8);      // 伴随着修改产生新对象
        LocalDate date4 = date3.withDayOfMonth(8); // 伴随着修改产生新对象
        System.out.println(date4);

        // 链式操作
        LocalDate date5 = date1.withYear(2008).withMonth(8).withDayOfMonth(8);
        System.out.println(date5);

        // 增加日期的同时，会产生新对象
        LocalDate date6 = date1.plusMonths(10);   // 10月以后，
        System.out.println(date6);
    }


    /**
     * 练习：创建一个 Calender 对象，把它变成你的生日，获取你的百日。打印输出
     */
    @Test
    public void exer2() {

        // 创建一个 Calender 对象
        Calendar myDate = Calendar.getInstance();

        // 把它变成你的生日
        myDate.set(Calendar.YEAR, 1991);
        myDate.set(Calendar.MONTH, 8);      // 存储的数据比实际值小1
        myDate.set(Calendar.DAY_OF_MONTH, 7);

        // 获取你的百日
        myDate.add(Calendar.DAY_OF_MONTH, 100);

        // 创建格式化器
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 输出
        //System.out.println(myDate.getTime());
        System.out.println(sdf.format(myDate.getTime()));   // 使用格式化器格式化再输出
    }


    @Test
    public void test3() {
        Calendar calendar = Calendar.getInstance(); // new Calendar(); 类似工厂的方法获取对象
        System.out.println(calendar);
        // calendar.getYear();
        int year = calendar.get(Calendar.YEAR);    // 通用的get 方法，获取什么属性，通过参数
        System.out.println(year);
        int month = calendar.get(Calendar.MONTH);   // 内部存储的数据比实际的月 小 1
        System.out.println(month);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);

        // calendar.setYear();
        calendar.set(Calendar.YEAR, 2020);          // 设置年
        calendar.set(Calendar.MONTH, 3);            // 设置年, 3 表示 4月
        calendar.set(Calendar.DAY_OF_MONTH, 15);    // 设置日
        System.out.println(calendar.getTime());     // 获取相应的 Date 对象

        // 加日期
        calendar.add(Calendar.MONTH, 10);           // 日期10个月之后
        calendar.add(Calendar.DAY_OF_MONTH, -100);  // 100天以前
        System.out.println(calendar.getTime());

    }

    @Test
    public void test2() {
        // 年是以1900为基础，月是以1为基础，日是以0为基础
        Date date = new Date(2008, 8, 8);
        System.out.println(date);   // 3908 09 08

        int year = date.getYear();
        System.out.println(year);

        int month = date.getMonth();
        System.out.println(month);
    }


    @Test
    public void test1() {
        long millis = System.currentTimeMillis();
        System.out.println(millis);

        Date date = new Date();     // 创建日期对象
        System.out.println(date);

        // 日期格式化器
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 把日期对象格式化成字符串，并要符合模式
        String format = sdf.format(date);
        System.out.println(format);

        // 格式和模式完全匹配
        String string = "2020-04-15 21:50:50";
        try {
            Date date2 = sdf.parse(string); // 字符串解析成日期对象
        } catch(ParseException e) {
            e.printStackTrace();
        }

        String format1 = sdf.format(millis);
        System.out.println(format1);
    }
}
