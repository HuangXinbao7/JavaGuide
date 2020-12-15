package com.xinbao.javase.chap02basesystax;

/**
 * 编写程序,声明一个类TestMethod，
 * 在其中声明一个method方法，
 * 在方法中打印一个20*8的矩形，
 * 在main方法中调用该方法。
 */
public class MethodExer2 {

    public static void method1() {
        // 打印 20*8 的矩形
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 方法重载，打印一个边长为n的正方形并返回正方形周长
    // 在main方法中调用该方法，并打印周长
    public static int method1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        return 4 * n;
    }


    /**
     * 再声明一个方法method1，在方法中打印一个n*m的矩形，并在方法结束后返回矩形周长,
     * 在main方法中调用该方法, 并打印周长
     */
    public static int method1(int n, int m) {
        // 打印 n*m 的矩形
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // 计算周长，并返回
        int l = 2 * (n + m);
        return l;
    }


    public static void main(String[] args) {
        // 在main方法中调用method1方法
        method1();

        // 在main方法中调用method1
        int L = method1(10, 30);
        System.out.println(L);

        // 在main方法中调用method1
        int z = method1(10);
        System.out.println(z);
    }
}
