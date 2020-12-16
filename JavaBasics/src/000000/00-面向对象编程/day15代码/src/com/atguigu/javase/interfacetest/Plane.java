package com.atguigu.javase.interfacetest;
/*
写一个类Udisk,实现(implements) USB接口
并实现其中的所有方法
写测试类,创建对象,使用本态和多态调用接口中的所有方法*/

public class Plane implements Flyer { // 具体类实现接口

    @Override
    public void takeOff() {
        System.out.println("飞机要起飞了, 需要折腾好长时间.");
    }

    @Override
    public void fly() {
        System.out.println("飞机不能乱飞, 有航线");
    }

    @Override
    public void land() {
        System.out.println("绝大多数的事都是飞机着陆时发生...");
    }
}
