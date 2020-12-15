package com.atguigu.javase.previews;

public class CircleTest {

    public static void main(String[] args) {
        Circle c1 = new Circle(2.0);
        Circle c2 = new Circle(3.0);

        System.out.println(c1.getArea());
        System.out.println(c2.getArea());
    }
}
