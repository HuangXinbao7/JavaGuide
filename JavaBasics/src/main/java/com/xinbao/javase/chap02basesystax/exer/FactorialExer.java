package com.xinbao.javase.chap02basesystax.exer;

/**
 * 计算n的阶乘
 * 什么情况下使用递归？一个问题可以分解为一个已知处理和子问题
 * 不是告诉计算该怎么做，而是告诉计算做什么
 */
public class FactorialExer {

    public static int fac(int n) {
        //return n;
        //return fac(n);        // 在方法中调用自身称为递归，无限递归（死归）

        // 有限递归
        if (n == 1) {
            return 1;
        }
        //
        return n * fac(n - 1);
    }


    // 求阶乘的和
    // 求 n!+(n-1)!+...
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return fac(n) + sum(n-1);
    }


    public static void main(String[] args) {
        System.out.println(fac(10));
        System.out.println(sum(10));
    }
}
