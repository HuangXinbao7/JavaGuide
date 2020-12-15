package com.xinbao.javase.chap02_basesystax.homework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

/**
 * 编写程序：接收三个命令行字符串并转换为整数分别存入变量num1、num2、num3，
 * 对它们进行排序(使用 if-else if-else),并且从小到大输出。
 */
public class HomeWork2 {
    public static void main(String[] args){

        // 设置运行参数 Program arguments
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);

        if(num1 < num2){
            if(num2 < num3){        // 当 num3 最大时
                System.out.println("从小到大的顺序为：" + num1 + ", " + num2 + ", " + num3);
            }else if(num1 > num3){      // 当 num3 最小时
                System.out.println("从小到大的顺序为：" + num3 + ", " + num1 + ", " + num2);
            }else{      // num3 的大小位于 num1 和 num2 之间
                System.out.println("从小到大的顺序为：" + num1 + ", " + num3 + ", " + num2);
            }
        }else{  // num1 > num2
            if(num3 > num1){        // 当 num3 最大时
                System.out.println("从小到大的顺序为：" + num2 + ", " + num1 + ", " + num3);
            }else if(num3 < num2){      // 当 num3 最小时
                System.out.println("从小到大的顺序为：" + num3 + ", " + num2 + ", " + num1);
            }else{      // num3 的大小位于 num2 和 num1 之间
                System.out.println("从小到大的顺序为：" + num2 + ", " + num3 + ", " + num1);
            }
        }
    }


}
