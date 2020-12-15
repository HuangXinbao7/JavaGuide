package com.xinbao.javase.chap02basesystax;

/**
 * 递归测试
 */
public class RecursionTest {

    private static int count = 0;

    public static int binomial() {
        return recursion(10);
    }

    public static int recursion(int k) {
        count ++;
        System.out.println("count: " + count + " k: " + k);
        if (k <= 0) {
            return 0;
        }
        return recursion(k-1) + recursion(k-2);
    }

    public static int fac(int k) {
        if (k <= 0) {
            return 0;
        }
        return fac(k-1) + fac(k-2);
    }


    public static void main(String[] args) {
        int t = binomial();
        //int t = fac(5);
        System.out.println(t);
    }
}
