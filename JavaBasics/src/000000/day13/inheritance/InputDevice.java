package com.atguigu.javase.inheritance;

public class InputDevice extends Device {

    public InputDevice() {
        super();
    }

    // 目的是为了类方便
    public InputDevice(int id, String name, String factory) {
        super(id, name, factory);
    }
}
