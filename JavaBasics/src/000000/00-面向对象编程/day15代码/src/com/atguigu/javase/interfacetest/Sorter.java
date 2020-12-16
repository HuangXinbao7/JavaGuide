package com.atguigu.javase.interfacetest;

public class Sorter {

    /**
     * 通用的冒泡排序, 可以给任意对象数组排序. 前提是对象所属的类必须实现Comparable接口
     * @param arr
     */
    public static void bubble(Comparable [] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) { // 对象怎么比的,这里不知道
                    Comparable tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
