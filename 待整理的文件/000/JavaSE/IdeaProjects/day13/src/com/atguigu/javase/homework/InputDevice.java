package com.atguigu.javase.homework;


public class InputDevice extends Device {

    public InputDevice() {
        //super();
    }

    // 目的是为了子类方便
    public InputDevice(int id, String name, String factory, double price) {
        super(id, name, factory, price);
    }

    @Override
    public String say() {
        return super.say();
    }
}
