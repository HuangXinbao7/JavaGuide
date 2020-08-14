package com.atguigu.javase.singleton;

/**
 * 饿汉式单例：声明的同时马上创建对象，适用于创建对象简单快速
 *      封装构造器
 *      声明私有静态属性，是一个引用，让它指向唯一对象
 *      声明公共静态方法，用以获取唯一对象的引用地址
 *
 * 懒汉式单例：声明时不创建对象，第一次真的要调用方法获取对象时才创建唯一对象
 *      封装构造器
 *      声明私有静态属性，是一个引用，并不赋值
 *      声明公共静态方法，在方法中只有第一次调用时才创建唯一对象
 */
public class SingleTest {

    public static void main(String[] args) {
        Singleton1 s1 = Singleton1.getSingle();     // 访问静态方法，获取单例对象
        Singleton1 s2 = Singleton1.getSingle();
        // 获取的两个单例对象是一致的
        if (s1 == s2) {
            System.out.println("s1 is equals to s2");
        }
    }
}
