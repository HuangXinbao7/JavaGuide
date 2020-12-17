package com.xinbao.javase.chap04oop.basic.exer;

/**
 * 自定义数组的工具类
 */
public class CustomArrayUtil {

    // 求数组的最大值
    public int getMax(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    // 求数组的最小值
    public int getMin(int[] arr) {
        int minValue = arr[0];
        for (int value : arr) {
            if (minValue > value) {
                minValue = value;
            }
        }
        return minValue;
    }

    // 求数组的总和
    public int getSum(int[] arr) {
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return sum;
    }

    // 求数组的平均值
    public int getAvg(int[] arr) {
        return getSum(arr) / arr.length;
    }

    // 如下的两个同名方法构成了重载
    // 反转数组
    public void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    public void reverse(String[] arr){}

    // 复制数组
    public int[] copy(int[] arr) {
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }
        return arr1;
    }

    // 数组排序
    public void sort(int[] arr) {
        // 冒泡排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
                    //swap(arr, j, j + 1);      // 调用自定义的swap方法
                }
            }
        }
    }

    // 交换数组中指定两个位置元素的值
    public void swap(int[] arr, int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 遍历数组
    public void print(int[] arr) {
        for (int value : arr) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }

    // 查找指定元素(索引)
    public int getIndex(int[] arr, int dest) {
        // 线性查找
        for (int i = 0; i < arr.length; i++) {
            if (dest == arr[i]) {
                return i;
            }
        }
        return -1;  // 返回一个负数，表示没有找到
    }
}
