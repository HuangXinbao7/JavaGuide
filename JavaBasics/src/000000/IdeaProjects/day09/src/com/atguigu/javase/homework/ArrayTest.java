package com.atguigu.javase.homework;

public class ArrayTest {

    public static void main(String[] args) {

        int[] arr = new int[20];
        for (int i =0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 200);
        }

        // 遍历
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("***********************");

        // 使用下标的方式找出能被7整除的数的最大和最小
        int maxIndex = -1;      // 表示此时还找到能被7整除的数
        int minIndex = -1;

        for (int i = 0; i < arr.length; i++){
            // 找到能被7整除的数
            if(arr[i] % 7 == 0){
                if (maxIndex == -1){    // 如果是第一个能被7整除的数
                    maxIndex = i;       // 直接刷值
                }else{
                    if(arr[i] > arr[maxIndex]){
                        maxIndex = i;
                    }
                }

                if (minIndex == -1){    // 如果是第一个能被7整除的数
                    minIndex = i;       // 直接刷值
                }else{
                    if(arr[i] < arr[minIndex]){
                        minIndex = i;
                    }
                }
            }
        }
        if(maxIndex != -1){
            System.out.println("能被7整除的最大的数：" + arr[maxIndex]);
        }else {
            System.out.println("没找到能被7整除的数");
        }

        if(minIndex != -1){
            System.out.println("能被7整除的最小的数：" + arr[minIndex]);
        }else {
            System.out.println("没找到能被7整除的数");
        }
    }
}
