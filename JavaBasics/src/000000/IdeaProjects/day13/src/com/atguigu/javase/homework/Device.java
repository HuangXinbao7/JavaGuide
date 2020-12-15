package com.atguigu.javase.homework;

/*
写一个类Device 设备, id, name, factory
写一个类 InputDevice 输入设备.
写一子类Mouse, 特有属性是 String color, 特有方法 void move()
写一子类Keyboard, 特有属性是 int keyCount, 特有方法 void type()
在测试类中创建2个鼠标, 3个键盘, 保存在一个数组中

给Device类添加一个属性price表示价格.
给数组排序
*/
public class Device {

    private int id;
    private String name;
    private String factory;
    private double price;

    public Device() {
    }

    public Device(int id, String name, String factory, double price) {
        this.id = id;
        this.name = name;
        this.factory = factory;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String say() {
        return "ID : " + id + ", 名称 : " + name + ", 厂家 : " + factory + ", 价格：" + price;
    }
}
