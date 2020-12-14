package com.atguigu.javase.homework;

import com.atguigu.javase.homework.InputDevice;

public class Keyboard extends InputDevice {

    private int keyCount;

    public Keyboard() {
    }

    public Keyboard(int id, String name, String factory, double price, int keyCount) {
        super(id, name, factory, price);
        this.keyCount = keyCount;
    }

    public int getKeyCount() {
        return keyCount;
    }

    public void setKeyCount(int keyCount) {
        this.keyCount = keyCount;
    }

    @Override
    public String say() {
        return super.say() + ", 按键 : " + keyCount;
    }

    public void type() {
        System.out.println("键盘在敲击...");
    }
}
