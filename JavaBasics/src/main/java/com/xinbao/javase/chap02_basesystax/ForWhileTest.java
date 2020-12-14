package com.xinbao.javase.chap02_basesystax;
import java.util.Scanner;


/**
 * 题目：从键盘读入个数不确定的整数，并判断读入的正数和负数的个数，输入为0时结束程序。
 *
 * 说明：
 * 1. 不在循环条件部分限制次数的结构：for(;;) 或 while(true)
 * 2. 结束循环有几种方式？
 *  方式一：循环条件部分返回false
 * 	方式二：在循环体中，执行break
 */
public class ForWhileTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int positiveNumber = 0;     // 记录正数的个数
        int negativeNUmber = 0;     // 记录负数的个数

        // 等价于 while(true){
        for (;;) {
            int number = scan.nextInt();

            // 判断number的正负情况
            if (number > 0) {
                positiveNumber ++;
            }else if(number < 0) {
                negativeNUmber ++;
            }else {
                // 一旦执行 break，就跳出循环
                break;
            }
        }

        System.out.println("输入的正数个数为：" + positiveNumber);
        System.out.println("输入的负数个数为：" + negativeNUmber);
    }
}
