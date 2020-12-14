package com.atguigu.javase.object;

public class PointTest {

    public static void main(String[] args) {
        Object p1 = new Point(10, 20);
        Object p2 = new Point(10, 20);

        System.out.println(p1 == p2);       // 判断两个引用中的地址值是否相等
        System.out.println(p1.equals(p2));  // 判断两个对象的内容是否相等

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

    }
}
