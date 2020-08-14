package com.atguigu.javase.homework;

import com.atguigu.javase.homework.InputDevice;

public class Mouse extends InputDevice {

    private String color;

    public Mouse() {
        super();
    }

    // 全参
    public Mouse(int id, String name, String factory, double price, String color) {
        super(id, name, factory, price); // 不能调用间接父类构造, 直接父类不能继承
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String say() {
        return super.say() + ", 颜色 : " + color;
    }

    public void move() {
        System.out.println("鼠标在移动");
    }

    //@Override
    //public boolean equals(Object obj) {
    //    if(obj instanceof Mouse &&  == obj.id ) {
    //
    //    }
    //}


}
