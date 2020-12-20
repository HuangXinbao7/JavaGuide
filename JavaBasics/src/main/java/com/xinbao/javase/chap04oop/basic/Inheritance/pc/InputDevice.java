package com.xinbao.javase.chap04oop.basic.Inheritance.pc;

/**
 * 写一个 InputDevice 类，输入设备，是 Device 类的子类
 */
public class InputDevice extends Device {

    private String keyboard;

    public InputDevice(){}

    // 目的是为了子类方便
    public InputDevice(int id, String name, String factory){
        super(id, name, factory);
    }


    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void say(){
        System.out.println("输入设备有：" + keyboard);
    }
}
