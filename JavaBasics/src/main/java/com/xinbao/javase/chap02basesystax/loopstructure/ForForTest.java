package com.xinbao.javase.chap02basesystax.loopstructure;

import org.junit.Test;

/**
 * 嵌套循环的使用
 * 1.嵌套循环：将一个循环结构A声明在另一个循环结构B的循环体中,就构成了嵌套循环
 *
 * 2.
 * 外层循环：循环结构B
 * 内层循环：循环结构A
 *
 * 3. 说明
 * ① 内层循环结构遍历一遍，只相当于外层循环循环体执行了一次
 * ② 假设外层循环需要执行m次，内层循环需要执行n次。此时内层循环的循环体一共执行了m * n次
 *
 * 4. 技巧：
 *    外层循环控制行数，内层循环控制列数
 */
public class ForForTest {

    public static void main(String[] args) {
        //******
        //System.out.println("******");
        for(int i = 1;i <= 6;i++){
            System.out.print('*');
        }
        System.out.println("\n");


        /*
         ******
         ******
         ******
         ******
         */
        for(int j = 1;j <= 4;j++ ){
            for(int i = 1;i <= 6;i++){
                System.out.print('*');
            }
            System.out.println();
        }


        /*			i(行号)		j(*的个数)
         *			1			1
         **			2			2
         ***		3			3
         ****		4			4
         *****		5			5
         */
        for(int i = 1;i <= 5;i++){//控制行数
            for(int j = 1;j <= i;j++){//控制列数
                System.out.print("*");
            }
            System.out.println();
        }


        /*			i(行号)		j(*的个数)   规律：i + j = 5 换句话说：j = 5 - i;
         ****		1			4
         ***		2			3
         **			3			2
         *			4			1
         */
        for(int i = 1;i <= 4;i++){
            for(int j = 1;j <= 5 - i;j++){
                System.out.print("*");
            }
            System.out.println();
        }


        /*
         *
         **
         ***
         ****
         *****
         ****
         ***
         **
         *
         */
        //略



        /*

        ----*
        ---* *
        --* * *
        -* * * *
        * * * * *
         * * * *
          * * *
           * *
            *
        */
        //上半部分
        //下半部分
    }


    /**
     * TestForForLoopBreak
     */
    @Test
    public void ForForLoopBreakTest() {
        l1: for (int i = 0; i < 10; i++) {
            l2: for (int j = 0; j < 4; j++) {
                System.out.println("j: " + j);
                if (j == 1) {
                    // break 中断的是最近的那层循环
                    //break l1;   // 中断标签指示的循环，实现跨循环中断
                    break;
                }
            }
            System.out.println("i: " + i);
        }
    }


    /**
     * continue 中断循环
     */
    @Test
    public void ForForLoopContinueTest() {
        // 打印100以内的所有质数
        l1:
        for (int i = 2; i < 100; i++) {
            // 如果i不是质数，则终止
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    continue;
                }
            }
            System.out.println(i + "是质数");
        }
    }



    @Test
    public void ForForLoopExer() {
        // 打印200以内所有质数
        for (int i = 2; i < 200; i++) {
            // 判断i是否是质数，假设i是质数
            boolean flag = true;

            // 尝试推翻假设，从 2~n-1中只要找到一个数可以整除i
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {   // 如果i被某个j整除，说明i不是质数
                    flag = false;   // 推翻假设
                    break;          // 反例不需要多，一个足以
                }
            }
            if (flag) {
                System.out.println(i + " 是质数");
            }
        }
    }
}
