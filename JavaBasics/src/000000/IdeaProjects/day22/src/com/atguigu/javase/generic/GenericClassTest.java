package com.atguigu.javase.generic;

/**
 * 自定义泛型类
 */
class Person<T> {

    // 使用T类型定义变量
    private T info;

    // static 的方法中不能声明泛型
    //public static void show(T t) {
    //}

    // 使用T类型定义构造器
    public Person() {
    }

    public Person(T info) {
        this.info = info;
    }

    // 使用T类型定义一般方法
    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    // 不能再try-catch中使用泛型定义
    //try {}
    //catch (T t) {}
}


public class GenericClassTest {

}
