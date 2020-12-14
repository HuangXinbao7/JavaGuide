package com.atguigu.javase.java8;

/**
 * Java8新特性：接口的变化
 */
interface A {
    void test();    // 抽象方法

    // java8以后支持静态方法和缺省方法，向抽象类靠拢。
    static void test3() {
        System.out.println("");
    }

    // java8以后的缺省方法有了方法体，为了升级接口的无奈之举
    default void test2() {
        System.out.println("test2()...");
    }
}

public class InterfaceTest {

}

// @FunctionalInterface 检查接口是不是函数式接口
@FunctionalInterface
interface MyNumber{
    public double getValue();
}

// 函数式接口中使用泛型
@FunctionalInterface
interface MyFunc<T> {
    public T getValue();
}
