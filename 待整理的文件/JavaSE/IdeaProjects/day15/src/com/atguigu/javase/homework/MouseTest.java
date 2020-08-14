package com.atguigu.javase.homework;

/**
 * 写测试类,创建对象,使用本态和多态调用抽象类中的和接口中的所有方法
 */
public class MouseTest {

    public static void main(String[] args) {
        // 本态
        Mouse m = new Mouse();
        m.startup();
        m.shutdown();
        m.connect();
        m.work();
        m.disconnect();
        System.out.println("**************************");

        // 多态
        if(m instanceof USB) {
            USB u = (USB)m;
            u.connect();
            u.work();
            u.disconnect();
        }
    }
}
