package com.xinbao.javase.chap02_basesystax.date;

/**
 * 在测试类中创建两个对象，一个对象代表生日，另一个代表今天，打印输出
 * 交换两个引用，再打印
 */
public class MyDateTest {
    public static void main(String[] args) {

        MyDate d1 = new MyDate();
        System.out.println("生日：" + d1.say());

        MyDate d2 = new MyDate();
        d2.year = 2020;
        d2.month = 3;
        d2.day = 26;
        System.out.println("今天：" + d2.say());


        System.out.println("**************");
        // 交换引用
        MyDate tmp = d1;
        d1 = d2;
        d2 = tmp;
        System.out.println("今天：" + d1.say());
        System.out.println("生日：" + d2.say());
    }
}
