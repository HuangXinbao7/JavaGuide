//package com.atguigu.javase.array;

import org.junit.Test;

import java.util.Arrays;

public class ArrayTest {

    public static void quick(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        // 找key值
        int key = arr[begin];
        int keyIndex = begin;
        for (int i = begin + 1; i < end; i++) {
            if (arr[i] < key) {
                keyIndex++;
                // 交换keyIndex位置和i位置的值
                int tmp = arr[keyIndex];
                arr[keyIndex] = arr[i];
                arr[i] = tmp;
            }
        }
        // 循环结束后, keyIndex及左面保存了所有比key小的值. 开始的位置仍然还是key
        arr[begin] = arr[keyIndex];
        arr[keyIndex] = key; // 此时分区完成,

        quick(arr, begin, keyIndex); // 左子列递归
        quick(arr, keyIndex + 1, end); // 右子列递归
    }

    public static void main9(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) { // 要想给数组元素赋值, 必须经典for
            arr[i] = (int) (Math.random() * 20);
        }
        // 遍历数组
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();

        Arrays.sort(arr); // 底层用的就是快速排序

        //quick(arr, 0, arr.length);
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    public static void main8(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) { // 要想给数组元素赋值, 必须经典for
            arr[i] = (int) (Math.random() * 20);
        }
        // 遍历数组
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
        // i = 0
        // minIndex = 7;
        //0 1  2  3 4  5 6  7
        //8 2 13 18 14 4 12 0
        //0 2 13 18 14 4 12 8
        // 第一循环时, 基准位置就是0, 目标是把最小值放在这个位置
        // 找到最小值下标

        // i = 1
        // minIndex = 1;
        //0 1  2  3 4  5 6  7
        //8 2 13 18 14 4 12 0
        //0 2 13 18 14 4 12 8
        // 第2循环时, 基准位置就是1, 目标是把最小值放在这个位置
        // 找到最小值下标

        // 选择排序 : 以位置为主导, 让恰当的位置保存恰当的值
        for (int i = 0; i < arr.length - 1; i++) {
            // 以i位置为基准位置, 找出包括i位置在内到右面所有数中的最小值的下标
            int minIndex = i; // 找出右面所有数据中的最小值的下标, 初始值是基准位置
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) { // 如果j位置的值小于minIndex位置的值
                    minIndex = j; // 记录j位置
                }
            }
            // minIndex中保存的就是右侧最小值的下标,让它归位, 归到基准位置
            int tmp = arr[i];
            arr[i] = arr[minIndex]; // 最关键操作, 让最小值归位
            arr[minIndex] = tmp;
        }
        // 遍历数组
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    public static void main7(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) { // 要想给数组元素赋值, 必须经典for
            arr[i] = (int) (Math.random() * 20);
        }
        // 遍历数组
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
        //0 1 2 3 4 5  6  7
        //5 0 7 6 9 19 10 18
        // 冒泡思路 : 保证整体左小右大
        for (int j = 0; j < arr.length - 1; j++) { // 外循环纯粹控制趟数
            for (int i = 0; i < arr.length - 1 - j; i++) { // 内循环控制比较交换, 次数会随着趟数的增加而减少
                // 比较i位置和i+1位置的值, 如果左大右小, 交换它俩, 否则不动
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }
        // 遍历数组
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    public static void main6(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) { // 要想给数组元素赋值, 必须经典for
            arr[i] = (int) (Math.random() * 20);
        }
        // 遍历数组
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
        //0 1  2 3  4  5 6  7
        //8 13 8 4 13 8 6 11 : > 13, 13, 11
        // 取子数组 : 把满足条件的一部分数据取出来放到一个新数组中. 把所有奇数取出来
        // 1) 建新数组, 容量和老数组一样, 防止老数组中全是有效元素的情况.
        int[] newArr = new int[arr.length];
        // 2) 声明计数器, 初值是0, 表明没有元素插入. 隐藏的作用是第一个有效元素向下标0位置插入.
            // 作用有2 : a 本职工作:计数(新数组中的有效元素个数). b 指示元素插入新数组的下标值.
        int count = 0; // 它是算法的灵魂!!!
        // 3) 遍历老数组
        for (int i = 0; i < arr.length; i++) {
            // 4) 如果找到符合条件的元素
            if (arr[i] % 2 != 0) {
                // 5) 把符合条件的元素保存在新数组中, 新数组的下标由计数器当前值控制
                newArr[count] = arr[i];
                // 6) 调整计数器
                count++;
            }
        }
        // 7) 创建最终数组, 长度是计数器
        int[] finalArr = new int[count]; // new int[0] 这种写法完全可以.
        // 8) 依次把新数据中的所有有效元素复制到最终数组中.
        for (int i = 0; i < count; i++) {
            finalArr[i] = newArr[i];
        }
        // 遍历最终数组
        for (int i = 0; i < finalArr.length; i++) {
            System.out.print(finalArr[i] + " ");
        }
        System.out.println();
    }

    public static void main5(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) { // 要想给数组元素赋值, 必须经典for
            arr[i] = (int) (Math.random() * 20);
        }
        // 遍历数组
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
        //0 1  2 3  4  5 6  7
        //8 16 4 9 10 18 9 12
        // 扩容
        // 1) 创建新数组, 容量比原来大
        int[] newArr = new int[(int)(arr.length * 1.5)];
        // 2) 依次把老数组中的数据复制到新数组中, 以短的为准
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        // 3) 老引用指向新数组
        arr = newArr;
        // 遍历数组
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();

    }

    public static void main4(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) { // 要想给数组元素赋值, 必须经典for
            arr[i] = (int) (Math.random() * 20);
        }
        // 遍历数组
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
        //0 1  2 3  4  5 6  7
        //8 16 4 9 10 18 9 12
        // 数组缩减
        // arr.length = arr.length / 2; // 这个操作不允许, 因为length是final量, 不允许修改.
        // 1) 创建一个容量小的新数组, 数组中的所有元素都是缺省值
        int[] newArr = new int[arr.length / 2];
        // 2) 依次把老数组中的有效元素复制到新数组中, 复制次数是新数组的长度
        for (int i = 0; i < newArr.length; i++) { // 以短的为准
            newArr[i] = arr[i];
        }
        // 3) 老引用指向新数组, 老数组变垃圾
        arr = newArr; // 把新数组对象的地址刷入老引用变量
        // 遍历数组, 此时遍历的是新数组
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
        // 把学生对象数组也缩减一下.
    }

    public static void main3(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) { // 要想给数组元素赋值, 必须经典for
            arr[i] = (int) (Math.random() * 20);
        }
        // 遍历数组
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
        //0 1  2  3  4  5 6 7
        //1 15 17 1 12 17 6 4
        //0和7交换, 1和6交换, 2和5交换, 从i开始, 7-i
        for (int i = 0; i < arr.length / 2; i++) {
            // 交换i和length - 1 - i位置
            int tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
        // 遍历数组
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();

    }

    public static void main2(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) { // 要想给数组元素赋值, 必须经典for
            arr[i] = (int) (Math.random() * 20);
        }
        // 遍历数组
        for (int tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
        // 0 1 2 3 4 5 6 7
        //18 7 6 2 4 7 8 6
        int max = arr[0];
        for (int tmp : arr) {
            if (tmp > max) {
                max = tmp;
            }
        }
        System.out.println("max = " + max);
        // 找下标
        int maxIndex = 0; // 位置信息
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        System.out.println("arr[maxIndex] = " + arr[maxIndex]);
        // 有条件最大值, 找奇数最大值
        int max2 = 0x80000000;
        for (int tmp : arr) {
            if (tmp % 2 != 0) {
                if (tmp > max2) {
                    max2 = tmp;
                }
            }
        }
        if (max2 == 0x80000000) {
            System.out.println("没有奇数");
        } else {
            System.out.println("奇数最大 : " + max2);
        }
        // 有条件最大值, 找能被7整除的数最大值, 用下标的方式
        int maxIndex2 = -1; // 能被7整除的数现在还不存在!!
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 7 == 0) {
                if (maxIndex2 == -1) {
                    maxIndex2 = i; // 找到了能被7整除的数
                } else {
                    if (arr[i] > arr[maxIndex2]) {
                        maxIndex2 = i;
                    }
                }
            }
        }
        if (maxIndex2 != -1) {
            System.out.println("能被7整除的数 : " + arr[maxIndex2]);
        } else {
            System.out.println("没有能被7整除的数");
        }
    }


    /**
     * 数组的赋值与遍历
     */
    @Test
    public void Test1(){
        int[] arr = new int[8];
        // 要想给数组元素赋值, 必须经典for
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 100);
        }

        // 遍历数组
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            System.out.print(tmp + " ");
        }
        System.out.println();

        // 遍历数组
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            tmp *= 10;  // 影响数组元素值吗?  要想数组元素变化必须arr[下标] = 值
            System.out.println(tmp + " ");
        }
        System.out.println();

        // 遍历数组2种方式 : 1) 经典for循环, 2) 增强型for循环或称为foreach
        /*
        for (数组元素类型 临时变量 : 数组名) {
            访问临时变量
        }
        */
        // 非常安全, 对于数组的访问是只读
        for (int tmp : arr) {
            tmp *= 20;
            System.out.println(tmp + " ");
        }
        System.out.println();
    }
}
