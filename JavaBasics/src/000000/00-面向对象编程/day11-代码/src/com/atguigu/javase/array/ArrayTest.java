package com.atguigu.javase.array;

public class ArrayTest {

    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20);
        }
        // 遍历
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
        // 选择 : 以位置为主导. 基准位置上放最小值
        for (int i = 0; i < arr.length - 1; i++) {
            // 以i位置为基准位置
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // minIndex就保存了最小值的下标, 把最小值放入基准位置
            swap(arr, i, minIndex);
        }

        // 遍历
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    public static void main2(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20);
        }
        // 遍历
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
        // 冒泡
        // 外循环纯粹的控制趟数, length - 1趟
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {// 内循环负责相邻元素的比较交换, length - 1次, 和外循环成反比
                if (arr[j] > arr[j + 1]) {// j和j+1位置
                    swap(arr, j, j + 1);
                }
            }
        }
        // 遍历
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    private static void swap(int[] arr, int j, int i) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void main1(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 20);
        }
        // 遍历
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
        // 扩容
        int[] newArr = new int[arr.length * 3 / 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr; // 新引用中的地址写入老引用变量.
        // 遍历
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
        // 取子数组, 取所有奇数
        // 1) 创建新数组, 容量和老的一样, 保持新数组的结构良好
        int[] newArr2 = new int[arr.length];
        // 2) 声明计数器, 初值为0
        int count = 0;
        // 3) 遍历老数组
        for (int i = 0; i < arr.length; i++) {
            // 4) 如果找到符合条件的元素
            if (arr[i] % 2 != 0) {
                // 5) 把元素赋值到新数组中, 下标由计数器当前值控制
                newArr2[count] = arr[i];
                // 6) 调整计数器
                count++;
            }
        }
        // 7) 创建最终数组, 长度是计数器
        int[] finalArr = new int[count];
        // 8) 依次把新数组中的所有有效元素复制到最终数组中
        for (int i = 0; i < count; i++) {
            finalArr[i] = newArr2[i];
        }

        for (int tmp : finalArr) {
            System.out.print(tmp + " ");
        }
        System.out.println();

    }
}
