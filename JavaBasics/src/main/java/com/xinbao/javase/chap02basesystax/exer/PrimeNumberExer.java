package com.xinbao.javase.chap02basesystax.exer;

import org.junit.Test;

public class PrimeNumberExer {

    /**
     * 100以内的所有质数的输出。
     * 质数：素数，只能被1和它本身整除的自然数。-->从2开始，到这个数-1结束为止，都不能被这个数本身整除。
     * 最小的质数是：2
     */
    @Test
    public void test1() {
        boolean isFlag = true;  // 标识i是否被j除尽，一旦除尽，修改其值

        for (int i = 2; i <= 100; i++) {    // 遍历100以内的自然数
            for (int j = 2; j < i; j++) {   // j被i去除
                if (i % j == 0) {           // i被j除尽
                    isFlag = false;
                }
            }
            //
            if (isFlag == true) {
                System.out.println(i);
            }

            // 重置 isFlag
            isFlag = true;
        }
    }


    /**
     * 100000以内的所有质数的输出。实现方式的优化1
     */
    @Test
    public void test2() {
        boolean isFlag = true;  // 标识i是否被j除尽，一旦除尽，修改其值
        int count = 0;          // 记录质数的个数
        // 获取当前时间距离1970-01-01 00:00:00 的毫秒数
        long start = System.currentTimeMillis();

        // 遍历100000以内的自然数
        for (int i = 2; i <= 100000; i++) {
            // 优化二：对本身是质数的自然数是有效的。
            //for(int j = 2;j < i;j++){
            for(int j = 2;j <= Math.sqrt(i);j++){   // j被i去除
                if(i % j == 0){                     // i被j除尽
                    isFlag = false;
                    break;  // 优化一：只对本身非质数的自然数是有效的。
                }
            }
            //
            if(isFlag){
                //System.out.println(i);
                count ++;
            }
            // 重置isFlag
            isFlag = true;
        }

        // 获取当前时间距离1970-01-01 00:00:00 的毫秒数
        long end = System.currentTimeMillis();
        System.out.println("质数的个数为：" + count);
        System.out.println("所花费的时间为：" + (end - start)); // 17110 - 优化一：break:1546 - 优化二：13
    }


    /**
     * 100000以内的所有质数的输出。实现方式的优化2
     */
    @Test
    public void test3() {
        int count = 0;  // 记录质数的个数
        // 获取当前时间距离1970-01-01 00:00:00 的毫秒数
        long start = System.currentTimeMillis();

        label:
        for(int i = 2; i <= 100000; i++){           // 遍历100000以内的自然数
            for(int j = 2;j <= Math.sqrt(i);j++){   // j被i去除
                if(i % j == 0){                     // i被j除尽
                    continue label;
                }
            }
            // 能执行到此步骤的，都是质数
            count++;
        }

        // 获取当前时间距离1970-01-01 00:00:00 的毫秒数
        long end = System.currentTimeMillis();
        System.out.println("质数的个数为：" + count);
        System.out.println("所花费的时间为：" + (end - start));//17110 - 优化一：break:1546 - 优化二：13
    }
}
