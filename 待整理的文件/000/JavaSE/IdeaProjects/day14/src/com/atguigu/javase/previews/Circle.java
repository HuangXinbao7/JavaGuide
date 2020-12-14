package com.atguigu.javase.previews;

public class Circle {

    public static double pi = 3.14159;  // static 修饰的成员变量
    private double radius;
    public static double getPi() {      // 类方法
        return pi;
    }


    // 全参构造
    public Circle(double radius) {
        this.radius = radius;
    }

    // 求圆的面积
    public double getArea() {
        return pi * radius * radius;
    }
}
