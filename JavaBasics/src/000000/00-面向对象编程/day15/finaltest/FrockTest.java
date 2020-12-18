package com.atguigu.javase.finaltest;

import com.atguigu.javase.abstracttest.Shirt;

public class FrockTest {

    public static void main(String[] args) {
        Frock frock = new Shirt(190, "白色", 300);
        System.out.println(frock.calcArea());
    }

    public static void main2(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());

        /*
        Frock f1 = new Frock(180, "白色", 300);
        Frock f2 = new Frock(160, "黑色", 100);
        Frock f3 = new Frock(175, "绿色", 800);
        Frock f4 = new Frock(190, "灰色", 200);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);
         */
    }
}
