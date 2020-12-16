package com.atguigu.javase.array;

// 二维数组 : 数组的数组, 它的元素是子数组
public class ArrayArrayTest {

    public static void main(String[] args) {
        // 这种写法更灵活, 可以是声明和初始化分开.
        int[][] arrarr1 = new int[][] {{1, 2, 3, 4}, {9, 2}, {8}};
        // 下面的写法只适用于声明和初始化在同一条语句上
        int[][] arrarr2 = {{9, 2}, {1, 8, 7}, {0}, {5, 4, 3, 2, 1}, {100, 200}};
        //arrarr2 = {{1,2}};
        arrarr2 = new int[][]{{1,2}, {3,4,5}};
    }
    public static void main1(String[] args) {
        int[][] arrarr = new int[4][]; // 创建了拥有4个子数组的数组. 还没有产生子数组
        arrarr[0] = new int[3];
        arrarr[1] = new int[4];
        arrarr[2] = new int[2];
        arrarr[3] = new int[5];
        // 数组中全是0
        for (int i = 0; i < arrarr.length; i++) { // arrarr.length是子数组个数
            int[] child = arrarr[i];
            for (int j = 0; j < child.length; j++) {
                child[j] = (int)(Math.random() * 50);
            }
        }
        // 遍历数组的数组
        for (int[] child : arrarr) {
            for (int tmp : child) {
                System.out.print(tmp + " ");
            }
            System.out.println();
        }

        // 求平均值 :
        int sum = 0;
        int count = 0;
        for (int[] child : arrarr) {
            for (int tmp : child) {
                sum += tmp;
                count++;
            }
        }
        int avg = sum / count;
        System.out.println("avg : " + avg);
    }
}
