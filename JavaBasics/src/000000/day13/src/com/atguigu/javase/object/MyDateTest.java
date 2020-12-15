package com.atguigu.javase.object;

public class MyDateTest {

    public static void main(String[] args) {
        MyDate d1 = new MyDate(2020, 4, 6);
        MyDate d2 = new MyDate(2020, 4, 6);

        System.out.println(d1 == d2);       // false
        // 被重写的 equals方法
        System.out.println(d1.equals(d2));  // true
        System.out.println(d1.hashCode());
        System.out.println(d2.hashCode());

        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s1.equals(s2));

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}
