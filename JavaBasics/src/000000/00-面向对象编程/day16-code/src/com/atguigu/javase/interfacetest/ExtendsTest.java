package com.atguigu.javase.interfacetest;

/**
 * 接口的特点：
 * 用interface来定义。
 * 接口中的所有成员变量都默认是由public static final修饰的。
 * 接口中的所有方法都默认是由public abstract修饰的。
 * 接口没有构造器。
 * 接口采用多继承机制。
 */
interface I1 {}

//class C1 extends I1 {} // 类不能继承接口 ：类和接口不是一路货。C1按理也要继承Object

class C2 {}

//interface I2 extends C2 {} 接口也不能继承类。

interface I3 extends I1 {}

interface I4 {
    public final static int a = 20;
    void test();
}
interface I5 {
    void test();
}
interface I6 {
    void test();
}

// 接口继承只能这样写
interface I7 extends I3, I4, I5, I6 {// 接口可以继承接口，并且可以多继承。
    void test();
}

class C8 implements I7 {

    @Override
    public void test() {
        System.out.println("唯一的体");
    }
}

public class ExtendsTest {
}
