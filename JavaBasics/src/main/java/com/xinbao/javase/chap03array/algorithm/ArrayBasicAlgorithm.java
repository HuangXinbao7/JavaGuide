package com.xinbao.javase.chap03array.algorithm;

import org.junit.Test;

/**
 * 数组的基本算法
 */
public class ArrayBasicAlgorithm {

    /**
     * 翻转数组：循环数组长度的一半，首尾交换
     */
    public void test8() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 20);
        }

        // 遍历
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();

        // 反转, 头变尾,
        // 翻转数组：循环数组长度的一半，首尾交换
        for (int i = 0; i < arr.length / 2; i++){
            // 交换i位置和arr.length - 1 - i 位置的值
            int tmp = arr[i];   // 临时变量必须使用数组元素类型
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }

        // 遍历
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }


    /**
     * 找最大值: 找最大值的位置(下标)
     * 使用下标的方式找出最小值
     */
    @Test
    public void test7() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 20);
        }

        // 遍历
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();

        // 找最大值：通过最大值的下标
        int maxIndex = 0;   // 假设下标为0的元素的值最大
        int minIndex = 0;   // 假设下标为0的元素的值最大
        for (int i = 0; i < arr.length; i++){
            if(arr[i] > arr[maxIndex]){     // 如果i位置的元素值大于maxIndex位置的元素值
                maxIndex = i;
            }
            if(arr[i] < arr[minIndex]){     // 如果i位置的元素值小于minIndex位置的元素值
                minIndex = i;
            }
        }
        System.out.println("最大值：" + arr[maxIndex]);
        System.out.println("最小值：" + arr[minIndex]);
    }


    /**
     * 能被7整除的数的最大值
     * 能被7整除的数的最小值
     */
    @Test
    public void test6() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 20);
        }

        // 遍历
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();

        // 找最大值
        int max = 0x80000000 ; // 1000 0000 0000 0000 0000 0000 0000 0000 // 无法直接获取某个元素的值.
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        System.out.println("max = " + max);

        // 最小值
        int min = 0x7FFFFFFF;// 0111 1111 ....;
        for (int value : arr) {
            if (value < min) {
                min = value;
            }
        }
        System.out.println("min = " + min);

        // 能被7整除的数的最大值
        int max7 = 0x80000000;   // 让它的值最小，这样只要是整数就一定会比它大，从而刷新它的值
        for (int value : arr) {
            if (value % 7 == 0) {
                if (value > max7) {
                    max7 = value;
                }
            }
        }
        if (max7 == 0x80000000){
            System.out.println("没有能被7整除的数");
        }else{
            System.out.println("能被7整除的最大值：" + max7);
        }

        // 能被7整除的数的最小值
        int min7 = 0x7FFFFFFF;   // 让它的值最大，这样只要是整数就一定会比它小，从而刷新它的值
        for (int value : arr) {
            if (value % 7 == 0) {
                if (value < min7) {
                    min7 = value;
                }
            }
        }
        if (min7 == 0x7FFFFFFF){
            System.out.println("没有能被7整除的数");
        }else{
            System.out.println("能被7整除的最小值：" + min7);
        }
    }


    /**
     * 找最大值和最小值
     */
    @Test
    public void test5() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 20);
        }

        // 遍历
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();

        // 找最大值
        int max = arr[0];   // 先假设第一个元素的值最大
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        System.out.println("max = " + max);

        // 找最小值
        int min = arr[0];
        for (int value : arr) {
            if (value < min) {
                min = value;
            }
        }
        System.out.println("min = " + min);
    }


    /**
     * 求所有能被7整除的数的平均值
     * 求能被5整除的数的平均值
     */
    @Test
    public void test4() {

        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 20);
        }

        // 遍历
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();

        // 求所有能被7整除的数的平均值
        int sum = 0;
        int count = 0;  // 计数
        for (int value : arr) {
            if (value % 7 == 0) {
                sum += value;
                count++;
            }
        }
        if (count == 0) {
            System.out.println("没有能被7整除的数");
        }else{
            int avg = sum / count;
            System.out.println("avg: " + avg);
        }

        // 求能被5整除的数的平均值
        sum = 0;
        count = 0;
        for (int value : arr) {
            if (value % 5 == 0) {
                sum += value;
                count++;
            }
        }
        if (count == 0){
            System.out.println("没有能被5整除的数");
        }else{
            int avg = sum / count;
            System.out.println("avg: " + avg);
        }
    }



    /**
     * 求平均值，先求和
     */
    public void test3() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * 20);
        }

        // 遍历
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();

        // 求平均值，先求和
        double sum = 0;
        for (int value : arr) {
            sum += value;
        }
        double avg = sum / arr.length;
        System.out.println("avg: " + avg);
    }


    /**
     * 随机数
     */
    public void test2() {

        double random1 = Math.random(); // [0~1) 随机浮点数
        System.out.println(random1);

        // 100以内的随机浮点数
        double random2 = Math.random() * 100;
        System.out.println(random2);

        // 100以内的随机整数
        int random3 = (int)(Math.random() * 100);
        System.out.println(random3);

        // 练习：产生一个随机的 [30, 70) 之间的整数
        // 思路：30 加上40以内的随机整数
        //int random4 = 30 + (int)(Math.random() * 40);
        int random4 = (int)(Math.random() * 40 + 30);
        System.out.println(random4);
    }


    /**
     * 数组的声明和创建
     */
    @Test
    public void test1() {
        // 数组的声明和创建，元素类型[] 数组名 = new 元素数据类型[长度];
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 2 * i + 1;     // 赋值
        }

        // 遍历
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();

        // 求和
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        System.out.println("sum: " + sum);

        // 求平均值
        int avg = sum / arr.length;
        System.out.println("avg: " + avg);
    }
}
