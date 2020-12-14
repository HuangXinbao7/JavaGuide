package com.xinbao.javase.chap02_basesystax;

import org.junit.Test;

/**
 * 方法
 */
public class MethodTest {

    // 求两个整数的和
    public static int add(int a, int b) {
        System.out.println("add()...");
        int c = a + b;
        return c;
    }

    @Test
    public void test1() {
        System.out.println("main begin");
        int cc = add(2,3);   // 方法调用
        System.out.println(cc);

        // 方法可以多次调用
        System.out.println(add(20, 30));    // 用于返回值的一次性使用
        System.out.println(add(20, 30));

        System.out.println("main end");
    }
}
