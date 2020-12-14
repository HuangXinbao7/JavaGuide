package com.xinbao.javase.chap02_basesystax;

import com.sun.javaws.IconUtil;
import org.junit.Test;

import java.util.Scanner;

/**
 * break和continue关键字的使用
 *              使用范围			        作用(不同点)		    相同点
 * break:	    switch-case等循环结构中	结束当前循环		    关键字后面不能声明执行语句
 * continue:	循环结构中			    结束当次循环			关键字后面不能声明执行语句
 */
public class BreakContinueTest {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i % 4 == 0) {
                break;  // 123
                //continue;
                //System.out.println(i);
            }
            System.out.println(i);
        }


        /**
         *
         */
        label:for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 10; j++) {
                if (j % 4 == 0) {
                    //break;//默认跳出包裹此关键字最近的一层循环。
                    //continue;

                    //break label;//结束指定标识的一层循环结构
                    continue label;//结束指定标识的一层循环结构当次循环
                }
                System.out.println(j);
            }
            System.out.println("================");
        }
    }


    /**
     * 中断循环
     */
    @Test
    public void BreakTest() {
        int n = 100;
        Scanner scan = new Scanner(System.in);

        // 从命令参数接收一个n，使得一个本来应该循环100次的循环，实际循环n次。
        System.out.println("请输入一个数字N：");
        int nn = scan.nextInt();


        // break 可以中断循环的执行，break中断的力度大，把整个循环终止了
        for(int i = 0; i < 100; i++) {
            System.out.println(i);
            if(i == n - 1) {
                break;
            }
        }
    }
    

    /**
     * continue 中断循环
     */
    @Test
    public void ContinueTest() {
        for (int i =0; i < 20; i++) {
            if(i % 2 == 0) {
                continue;
            }
            System.out.println(i);
        }
    }


    @Test
    public void ContinueTest2() {
        // 打印100以内的所有能被13整除的数
        l1: for (int i = 13; i < 100; i++) {
            // 如果i不能被13整除，则中断当次循环
            if (i % 13 != 0) {
                continue l1;
            }
            System.out.println(i);
        }
    }
}
