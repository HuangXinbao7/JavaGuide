package com.xinbao.javase.chap03array.arrayexer;

import org.junit.Test;

public class LinearArrayExer {

    /**
     * 练习: 创建一个26元素的char数组，保存所有大写字母，并遍历打印输出
     */
    @Test
    public void test1() {
        char[] arr = new char[26];

        for(int i = 0; i < arr.length; i++){
            arr[i] = (char)('A' + i);
        }

        for (char c : arr) {
            System.out.print(c + " ");
        }
    }


    /**
     * 练习2：创建一个36个元素的char数组，前26个保存所有大写字母，后10个保存所有数字字符'0'~'9'，并遍历打印输出
     */
    @Test
    public void test2() {
        char[] arr = new char[36];

        // 数组的处理，前26个保存所有大写字母
        for(int i = 0; i < 26; i++){
            arr[i] = (char)('A' + i);
        }
        // 数组的处理，后10个保存所有数字字符'0'~'9'
        for(int i = 26; i < arr.length; i++){
            arr[i] = (char) (48 + i - 26);
        }
        // 数组的遍历，专门用于访问数组元素
        for (char c : arr) {
            System.out.print(c + " ");
        }
    }


    /**
     * 练习3：使用静态初始化方式各创建一个字符串数组，保存几位同学的名字，遍历打印输出
     */
    @Test
    public void test3() {
        String[] name = new String[]{"小明", "小红", "小丽", "小东"};
        for (String s : name) {
            System.out.println(s);
        }
    }


    /**
     * 找出能被7整除的数的最大和最小
     */
    @Test
    public void test4() {
        int[] ints = new int[20];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int)(Math.random() * 200);
        }

        // 遍历
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
        System.out.println("\n***********************");

        // 使用下标的方式找出能被7整除的数的最大和最小
        int maxIndex = -1;      // 表示此时还没找到能被7整除的数
        int minIndex = -1;

        //
        for (int i = 0; i < ints.length; i++) {
            // 找到能被7整除的数
            if (ints[i] % 7 ==  0) {
                if (maxIndex == -1) {   // 如果是第一个能被7整除的数
                    maxIndex = i;
                }else{
                    if (ints[i] > ints[maxIndex]) {
                        maxIndex = i;
                    }
                }

                //
                if (minIndex == -1) {
                    minIndex = i;
                }else{
                    if (ints[i] < ints[minIndex]){
                        minIndex = i;
                    }
                }
            }
        }

        //
        if(maxIndex != -1){
            System.out.println("能被7整除的最大的数：" + ints[maxIndex]);
        }else {
            System.out.println("没找到能被7整除的数");
        }

        if(minIndex != -1){
            System.out.println("能被7整除的最小的数：" + ints[minIndex]);
        }else {
            System.out.println("没找到能被7整除的数");
        }
    }
}
