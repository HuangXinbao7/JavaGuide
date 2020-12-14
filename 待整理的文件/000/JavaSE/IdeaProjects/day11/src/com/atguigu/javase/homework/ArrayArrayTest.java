package com.atguigu.javase.homework;

public class ArrayArrayTest {

    /**
     * 作业1：
     * 创建一个拥有5个子数组的二维数组, 每个子数组单独创建并赋值
     * 把数组中的所有元素赋值为随机的100以内的整数
     * 遍历数组的数组
     * 找出最大值
     */
    public static void main(String[] args) {

        // 创建一个拥有5个子数组的二维数组，每个子数组稍后单独创建
        int[][] arr1 = new int[5][];

        // 循环创建每个子数组，数组长度取随机的5~10长度
        for (int i = 0; i < arr1.length; i++){
            int len = 5 + (int)(Math.random() * 6);     // 随机的5~10
            arr1[i] = new int[len];
        }
        // 把数组中的所有元素赋值为随机的100以内的整数
        for(int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr1[i].length; j++){
                // 产生随机的100以内的整数
                int data = (int)(Math.random() * 100);
                arr1[i][j] = data;
            }
        }

        // 遍历数组的数组
        for (int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr1[i].length; j++){
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }

        // 找出最大值
        int max = arr1[0][0];   // 假设arr1[0][0] 中的值是最大值
        for(int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr1[i].length; j++){
                if(arr1[i][j] > max){
                    max = arr1[i][j];
                }
            }
        }
        System.out.println("最大值：" + max);
    }
}
