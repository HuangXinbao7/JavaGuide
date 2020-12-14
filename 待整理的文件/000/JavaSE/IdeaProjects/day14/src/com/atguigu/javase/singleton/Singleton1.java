package com.atguigu.javase.singleton;

// 单例设计模式-饿汉式
public class Singleton1 {

    // 2 声明私有的静态对象，类型是引用，指向唯一对象，只能在类的内部访问
    private static Singleton1 onlyOne = new Singleton1();

    // 3 声明公共静态方法，用于获取唯一对象
    // getSingle() 为 static，不用创建对象即可访问
    // 通过这个静态方法间接访问类内部创建的对象
    public static Singleton1 getSingle() {
        return onlyOne;
    }
    // 1 封装构造器，private 修饰的构造器，封死外部的new操作，不能在类的外部创建该类的对象，只能在内部new对象
    private Singleton1() {}
}
