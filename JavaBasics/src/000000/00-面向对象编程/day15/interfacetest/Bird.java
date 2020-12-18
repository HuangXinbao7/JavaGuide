package com.atguigu.javase.interfacetest;

import java.io.Serializable;

// 一个类可以同时继承父类并实现接口, java只支持单继承, 只允许有一个直接父类.
// java是通过接口间接实现多继承.
public class Bird extends Pet implements Flyer, Runnable, Serializable {

    private int flySpeed;

    public Bird() {
    }

    public Bird(String name, int age, double weight, int flySpeed) {
        super(name, age, weight);
        this.flySpeed = flySpeed;
    }

    public int getFlySpeed() {
        return flySpeed;
    }

    public void setFlySpeed(int flySpeed) {
        this.flySpeed = flySpeed;
    }

    @Override
    public String toString() {
        return super.toString() + ", Bird{" +
                "flySpeed='" + flySpeed + '\'' +
                '}';
    }

    @Override
    public void speak() {
        System.out.println("吱吱吱");
    }

    @Override
    public void eat() {
        System.out.println("小鸟吃小虫虫");
    }

    @Override
    public void takeOff() {
        System.out.println("小鸟起飞so easy");
    }

    @Override
    public void fly() {
        System.out.println("天高任鸟飞");
    }

    @Override
    public void land() {
        System.out.println("我就喜欢电线杆");
    }

    @Override
    public void run() {

    }
}
