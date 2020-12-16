package com.xinbao.javase.chap03array.algorithm;

/**
 * 算法的考查：求数值型数组中元素的最大值、最小值、平均数、总和
 *
 * 定义一个int型的一维数组，包含10个元素，分别赋一些随机整数，
 * 然后求出所有元素的最大值，最小值，和值，平均值，并输出出来。
 * 要求：所有随机数都是两位数。
 *
 * 求随机数的方法：
 * [10,99]
 * 公式：(int)(Math.random() * (99 - 10 + 1) + 10)
 */
public class ArrayAlgorithmExer1 {
    public static void main(String[] args) {
        int[] ints = new int[8];

        // 赋值
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int)(Math.random() * (99 - 10 + 1) + 10);
        }

        // 遍历
        for (int anInt : ints) {
            System.out.print(anInt + "\t");
        }
        System.out.println();

        // 求数组元素的最大值
        int maxValue = ints[0];
        for (int i = 1; i < ints.length; i++) {
            maxValue = maxValue > ints[i] ? maxValue : ints[i];
        }
        System.out.println("最大值为：" + maxValue);

        // 求数组元素的最小值
        int minValue = ints[0];
        for(int i = 1;i < ints.length;i++){
            if(minValue > ints[i]){
                minValue = ints[i];
            }
        }
        System.out.println("最小值为：" + minValue);

        // 求数组元素的总和
        int sum = 0;
        for (int anInt : ints) {
            sum += anInt;
        }
        System.out.println("总和为：" + sum);

        // 求数组元素的平均数
        int avgValue = sum / ints.length;
        System.out.println("平均数为：" + avgValue);
    }
}
