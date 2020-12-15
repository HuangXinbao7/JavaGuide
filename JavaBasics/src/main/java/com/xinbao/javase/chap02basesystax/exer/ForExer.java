package com.xinbao.javase.chap02basesystax.exer;

import org.junit.Test;

/**
 * for循环语句练习
 */
public class ForExer {
    public static void main(String[] args) {}

    /**
     * 练习1
     */
    @Test
    public void ForExer1() {
        // 1、打印1~100之间所有奇数的和
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        System.out.println("sum = " + sum);


        // 2、打印1~100之间所有是7的倍数的整数的个数及总和（体会设置计数器的思想）
        int sum2 = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0) {
                sum2 += i;
            }
        }
        System.out.println("sum2 = " + sum2);


        /**
         * 3.输出所有的水仙花数
         *  所谓水仙花数是指一个3位数，其各个位上数字立方和等于其本身。
         *  例如：153 = 1*1*1 + 3*3*3 + 5*5*5
         */
        int x;
        int y;
        int z;
        for (int i = 100; i <= 999 ; i++) {
            x = i / 100;
            y = i % 100 / 10;
            z = i % 10;

            if (i == x*x*x + y*y*y + z*z*z) {
                System.out.println(i);
            }
        }
    }


    /**
     * 编写程序从1循环到150，并在每行打印一个值，
     * 另外在每个3的倍数行上打印出 “3的倍数”,
     * 在每个5的倍数行上打印“5的倍数”,
     * 在每个7的倍数行上打印输出“5的倍数”。
     */
    @Test
    public void ForExer2() {
        for(int i = 1; i <= 150; i++){

            System.out.print(i + "\t\t");

            if(i % 3 == 0){
                System.out.print("3的倍数 ");
            }

            if(i % 5 == 0){
                System.out.print("5的倍数 ");
            }

            if(i % 7 == 0){
                System.out.print("7的倍数 ");
            }

            // 换行
            System.out.println();
        }
    }


    /**
     * 3000米长的绳子，每天减一半。问多少天这个绳子会小于5米？不考虑小数。
     */
    @Test
    public void ForExer3() {
        int days = 0;
        for (int len = 3000; len >= 5; len /= 2) {
            days++;
        }
        System.out.println(days);
    }


    /**
     * 打印如下图形
     * ----*
     * ---* *
     * --* * *
     * -* * * *
     * * * * * *
     * i	j	k
     * 0	4	1     j = 4-i;  k = i+1;
     * 1	3	2
     * 2	2	3
     * 3	1	4
     * 4	0	5
     *  * * * *
     *   * * *
     *    * *
     *     *
     */
    @Test
    public void ForExer4() {
        // 打印上半部分
        for (int i = 0; i < 5; i++) {
            // 输出“-”
            for (int j = 0; j < 4 - i; j++) {
                System.out.print("-");
            }

            // 输出 "* "
            for (int k = 0; k < i + 1; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // 打印中间部分
        // 输出 "i	j	k"
        System.out.println("i\tj\tk");
        for (int i = 0; i < 5; i++) {
            System.out.println(i + "\t" + (4-i) + "\t" + (i+1));
        }

        // 打印下半部分
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            //
            for (int j = 0; j < 4 - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
