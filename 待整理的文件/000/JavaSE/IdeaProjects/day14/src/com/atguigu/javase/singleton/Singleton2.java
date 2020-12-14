package com.atguigu.javase.singleton;

// 单例设计模式-懒汉式
public class Singleton2 {

    // 2 声明私有的静态的属性，是一个引用，用于指向本类对象
    // 先声明类的引用
    // 也需要配合static的方法，用static修饰此类的引用
    private static Singleton2 instance = null;

    // 3 声明公共静态方法，用来获取对象
    public static Singleton2 getInstance() {
        // 3.1 如果类的实例未创建，那些先要创建，然后返回给调用者：本类。
        // 因此，需要 static 修饰
        if(instance == null) {
            instance = new Singleton2();
        }
        // 若有了类的实例，直接返回给调用者
        return instance;
    }

    // 1 封装构造器：将构造器私有化，保证在此类的外部，不能调用本类的构造器
    private Singleton2() {}
}
