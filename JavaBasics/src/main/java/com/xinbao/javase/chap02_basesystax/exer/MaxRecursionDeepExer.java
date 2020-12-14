package com.xinbao.javase.chap02_basesystax.exer;

/**
 * 测试递归调用的次数
 */
public class MaxRecursionDeepExer {
    private int size = 1;

    public void stackLeak () {
        size++;
        stackLeak();
    }

    public static void main(String[] args) {

        MaxRecursionDeepExer ss = new MaxRecursionDeepExer();

        try{
            ss.stackLeak();
        } catch (Throwable e) {
            System.out.println(ss.size);
        }
    }
}
