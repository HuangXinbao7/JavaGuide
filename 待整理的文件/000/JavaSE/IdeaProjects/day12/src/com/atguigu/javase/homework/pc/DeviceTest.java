package com.atguigu.javase.homework.pc;

// 在测试类中创建2个鼠标, 3个键盘, 分别打印输出
public class DeviceTest {

    public static void main(String[] args) {
        // 2个鼠标
        Mouse m1 = new Mouse();
        m1.setId(1000);
        m1.setName("有线鼠标");
        m1.setFactory("罗技科技");
        m1.setColor("灰色");
        m1.move();

        Mouse m2 = new Mouse();
        m2.setId(1001);
        m2.setName("无线鼠标");
        m2.setFactory("雷柏科技");
        m2.setColor("白色");
        m2.move();


        // 3个键盘
        Keyboard k1 = new Keyboard();
        k1.setId(20002);
        k1.setName("黑爵机械键盘");
        k1.setFactory("黑爵");
        k1.setKeyCount(61);
        k1.type();

        Keyboard k2 = new Keyboard();
        k2.setId(30003);
        k2.setName("C87-机械键盘");
        k2.setFactory("IKBC");
        k2.setKeyCount(87);
        k2.type();

        Keyboard k3 = new Keyboard();
        k3.setId(40004);
        k3.setName("雷柏-V500PRO-机械键盘");
        k3.setFactory("雷柏");
        k3.setKeyCount(104);
        k3.type();
    }
}
