package com.atguigu.javase.interfacetest;

// 封装一个排序器
public class Sorter {

    // 选择排序
    public static void select(Comparable[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // minIndex 中保存的就是右侧最小值的下标，让它归位，归到基准位置
            Comparable tmp = arr[i];
            arr[i] = arr[minIndex];     // 最关键操作，让最小值归位
            arr[minIndex] = tmp;
        }
    }

    // 通用的冒泡排序。
    // 它可以给任意对象数组排序，前提是对象数组的类必须实现Comparable接口
    // 只需要将参数的数据类型换成接口类型
    // 任何类，只要实现了 compareTo 接口，都可以排序
    public static void bubble(Comparable[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++) {
                //if(arr[j].getScore() > arr[j+1].getScore()) {

                // 对象是怎么比的，这里不知道
                // 其细节在Student类中实现
                if(arr[j].compareTo(arr[j+1]) > 0) {
                    Comparable tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }


    // 冒泡排序1
    public static void bubble1(Student[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++) {
                //if(arr[j].getScore() > arr[j+1].getScore()) {
                /**
                 * 对象是怎么比的，这里不知道
                 * 其细节在Student类中实现
                 */
                if(arr[j].compareTo(arr[j+1]) > 0) {
                    Student tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}
