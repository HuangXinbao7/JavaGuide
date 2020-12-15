package com.xinbao.javase.chap02basesystax.loopstructure;

/**
 * 死循环
 */
public class EndlessLoopTest {

    public static void main(String[] args) {

        // 无限循环，死循环
        boolean flag = true;
        while (flag) {
            System.out.println("a");
        }
        // while的条件语句如果直接使用true常量，则下面的语句永远不会到达，编译不通过
        // 通过使用变量flag，可以编译通过，但依然是一个死循环
        System.out.println();


        do {
            System.out.println("C");
        } while (flag);
        System.out.println("D");


        // 没有迭代语句的死循环
        for (int i = 0; i<10;) {
            System.out.println('G');
        }

        // 条件语句为true的死循环
        // 使用flag变量替代true，可以骗过编译器
        for (int i = 0; flag; i++) {
            // 无循环体的循环
        }

        for (int i = 0; ; i++) {    // 编译器认定的死循环
            // 无循环体
        }

        //for (;;){  // 编译器认定的死循环
        //    System.out.println("E");
        //}
    }
}
