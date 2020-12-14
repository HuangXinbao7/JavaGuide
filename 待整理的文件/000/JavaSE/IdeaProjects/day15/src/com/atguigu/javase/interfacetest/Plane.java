package com.atguigu.javase.interfacetest;

/**
 * 写一个类 Udisk,实现(implements) USB接口
 * 并实现其中的所有方法
 * 写测试类,创建对象,使用本态和多态调用接口中的所有方法
 */
// 具体类实现接口
public class Plane implements Flyer {

    @Override
    public void takeOff() {
        System.out.println("起飞");
    }

    @Override
    public void fly() {
        System.out.println("正在飞行");
    }

    @Override
    public void land() {
        System.out.println("降落~~");
    }
}
