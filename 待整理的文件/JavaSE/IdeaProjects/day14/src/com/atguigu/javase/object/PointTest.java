package com.atguigu.javase.object;

public class PointTest {

    public static void main(String[] args) {
        Object p1 = new Point(10, 20);
        Object p2 = new Point(10, 20);

        System.out.println(p1 == p2);       // 判断两个引用中的地址值是否相等
        System.out.println(p1.equals(p2));  // 判断两个对象的内容是否相等

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        System.out.println("*******toString*******");



        // 调用 toString() 方法
        System.out.println(p1.toString());
        // 直接打印又安全又省事，显式调用toString()容易出错
        System.out.println(p2);

        String p3 = null;
        // 此时若调用 toString() ，会报错
        System.out.println(p3);
        //System.out.println(p3.toString());  // 报错
    }
}
