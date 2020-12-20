package com.xinbao.javase.chap04oop.basic.Inheritance;

public class NotePad extends Computer {

    int satelite;

    public void navigate() {
        System.out.println("使用平板在导航, CPU : " + getCpu());
    }
}
