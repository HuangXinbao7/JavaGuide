package com.atguigu.javase.annotationtest;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

/**
 * Override 注释
 */
// 定义一个接口
interface Car {
    void run();
}

/**
 * QQ类编译不会有任何问题，BMW类在编译的时候会提示相应的错误。
 */
class QQ implements Car {
    @Override
    public void run() {
        System.out.println("QQ");
    }
}

// BMW类在编译的时候会提示相应的错误，父类中省略了 public abstract 修饰符
class BMW implements Car {
    @Override
    //void run() {
    public void run() {
        System.out.println("BMW");
    }
}

public class OverrideTest {
}
