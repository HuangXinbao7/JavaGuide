package com.atguigu.javase.interfacetest;

/**
 * 接口的特点：
 * 用 interface 来定义
 * 接口中所有成员变量都默认是由 public static final 修饰的
 * 接口中的所有方法都默认是由 public abstract 修饰的
 * 接口没有构造器
 * 接口采用多继承机制
 */
interface I1 {}

// 类不能继承接口：
// 原因：类和接口不是一路货。C1按理也要继承Object，而接口是不继承 Object的
//class C1 extends I1 {}

class C2 {}
// 接口也不可以继承类
//interface I2 extends C2 {}

interface I3 extends I1 {}  // 接口可以继承接口

interface I4 {
    public static final int a = 20;
    public final static int b = 200;
    void test();
}
interface I5 {
    void test();
}
interface I6 {
    void test();
}

// 接口可以继承接口，且可以多继承。原因是接口中都是抽象方法，最终的方法实体在子类中
// 接口的继承以及多继承的语法格式只能这样写
interface I7 extends I3, I4, I5, I6 {
    void test();
}

class C8 implements I7 {
    @Override
    public void test() {
        System.out.println("唯一的方法体。");
    }
}


public class ExtendsTest {
}
