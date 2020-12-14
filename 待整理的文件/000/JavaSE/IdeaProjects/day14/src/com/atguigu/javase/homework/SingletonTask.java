package com.atguigu.javase.homework;

// 单例模式-饿汉式
class Singleton1 {
    private static Singleton1 onlyOne = new Singleton1();

    public static Singleton1 getInstance() {
        return onlyOne;
    }

    private Singleton1() {}

}

// 单例模式-懒汉式
class Singleton2 {
    private static Singleton2 onlyOne = null;

    public static Singleton2 getInstance() {
        if(onlyOne == null) {
            onlyOne = new Singleton2();
        }
        return onlyOne;
    }

    private Singleton2() {}
}

// 测试
public class SingletonTask {

    public static void main(String[] args) {
        Singleton1 s11 = Singleton1.getInstance();
        Singleton1 s12 = Singleton1.getInstance();

        System.out.println(s11 == s12); // true
    }
}
