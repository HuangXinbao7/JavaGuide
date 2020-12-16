package com.xinbao.javase.chap03array.arrayexer;

import org.junit.Test;

public class TwoDimensionalArrayExer {

    /**
     * 求二维数组中所有元素的和
     */
    @Test
    public void exer1() {
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int sum = 0;

        // 方法一
        for(int i = 0;i < ints.length;i++){
            for(int j = 0;j < ints[i].length;j++){
                sum += ints[i][j];
            }
        }
        System.out.println("总和为：" + sum);

        // 方法二
        sum = 0;
        for (int[] anInt : ints) {
            for (int i : anInt) {
                sum += i;
            }
        }
        System.out.println("总和为：" + sum);
    }







}
