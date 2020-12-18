package com.atguigu.javase.finaltest;


public class FrockTest {

    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());

    }

    // 练习3：
    public static void main4(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());
    }

    // 练习2
    // 在FrockTest 类的main方法中，分别创建三个Frock 对象，并打印三个对象的序列号，验证是否为按100递增
    public static void main3(String[] args) {
        Frock f1 = new Frock(160, "白色", 300);
        Frock f2 = new Frock(170, "黑色", 100);
        Frock f3 = new Frock(180, "红色", 600);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
    }

    // 练习2
    // 在FrockTest 类的main方法中，分别创建三个Frock 对象，并打印三个对象的序列号，验证是否为按100递增
    public static void main2(String[] args) {
        Frock f1 = new Frock();
        Frock f2 = new Frock();
        Frock f3 = new Frock();

        System.out.println(f1.getSerialNumber());   // 100100
        System.out.println(f2.getSerialNumber());   // 100200
        System.out.println(f3.getSerialNumber());   // 100300
    }

    // 练习1
    // 在FrockTest 类的main方法中，分两次调用getNextNum方法，获取序列号并打印输出。
    public static void main1(String[] args) {

        // 调用静态方法
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());
    }
}
