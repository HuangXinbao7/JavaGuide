package com.xinbao.javase.chap02_basesystax.exer;

/**
 * 打印九九乘法表
 */
public class ForForExer {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " * " + j + " = " + (i * j) + "  ");
            }
            System.out.println();
        }
    }
}
