package com.atguigu.javase.inheritance;

public class DeviceTest {

    public static void main(String[] args) {
        Mouse mouse = new Mouse(2, "HP100", "HP", "黑色");
        System.out.println(mouse.say());    // 子类的方法，覆盖方法
        mouse.move();   // 子类的方法，特有方法
        System.out.println(mouse.getName());    // 从父类继承的方法，继承方法
    }
}
