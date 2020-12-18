package com.atguigu.javase.polymorphism;

public class BeiJing extends Chinese {
    public BeiJing() {

    }

    public BeiJing(String name, int age, String gender, String shuxiang) {
        super(name, age, gender, shuxiang);
    }

    public void liuBird() {
        System.out.println("遛鸟");
    }
}
