package com.xinbao.javase.chap02_basesystax;

/**
 * 编写程序，定义三个重载方法并调用。方法名为mOL。
 * 三个方法分别接收一个int参数、两个int参数、一个字符串参数。
 * 第一个方法执行平方运算并输出结果，第二个方法执行相乘并输出结果，第三个方法执行输出字符串信息。
 * 在主类的main ()方法中分别用参数区别调用三个方法。
 */
public class MethodExer1 {

    // 第一个方法执行平方运算并输出结果
    public static void mOL(int a){
        int p = a * a;
        System.out.println(p);
    }

    // 第二个方法执行相乘并输出结果
    public static void mOL(int a, int b){
        int c = a * b;
        System.out.println(c);
    }

    // 第三个方法执行输出字符串信息
    public static void mOL(String c){
        System.out.println(c);
    }

    public static void main(String[] args) {

        int a = 10;
        int b = 20;
        String s = "abcde";

        mOL(a);
        mOL(a, b);
        mOL(s);
    }
}
