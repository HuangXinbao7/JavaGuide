package com.xinbao.javase.chap03_array;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;
import org.junit.Test;

/**
 * 二维数组
 * 1.理解：
 * 可以看成是一维数组中又作为另一个一维数组中的元素而存在。
 * 其实，从数组底层的运行机制来看，其实没有多维数组。因为二维数组是逻辑上的定义。
 *
 * 2.二维数组的使用:
 *   ① 二维数组的声明和初始化
 *   ② 如何调用数组的指定位置的元素
 *   ③ 如何获取数组的长度
 *   ④ 如何遍历数组
 *   ⑤ 数组元素的默认初始化值 :见 ArrayTest3.java
 *   ⑥ 数组的内存解析 :见 ArrayTest3.java
 *
 * 3.二维数组的规范
 *  规范：二维数组分为外层数组的元素，内层数组的元素
 *  	int[][] arr = new int[4][3];
 *  	外层元素：arr[0],arr[1]等
 *  	内层元素：arr[0][0],arr[1][2]等
 */
public class TwoDimensionalArray {
    public static void main(String[] args) {
        // 1 二维数组的声明和初始化
        int arr1[][];   // 声明空的二维数组，方式一
        int[][] arr2;   // 声明空的二维数组，方式二，推荐

        int[][] ints1 = {{1, 2, 3}, {4, 5}, {6, 7, 8}};     // 静态初始化
        String[][] strings1 = new String[3][2];             // 动态初始化1
        String[][] strings2 = new String[3][];              // 动态初始化2

        // 错误情况
        //String[][] strings3 = new String[][];
        //String[3][4] strings4 = new String[][];
        //int[][] ints2 = new int[4][3]{{1,2,3},{4,5},{6,7,8}};

        // 正确写法还有：
        int[] ints3[] = new int[][]{{1, 2, 3}, {4, 5}, {6, 7, 8}};
        int[] ints4[] = {{1, 2, 3}, {4, 5}, {6, 7, 8}};


        // 2 如何调用数组的指定位置的元素
        System.out.println(ints1[0][1]);
        ints1[0] = new int[3];
        System.out.println(ints1[0][1]);


        // 3 如何获取数组的长度
        System.out.println(ints1.length);
        System.out.println(strings1.length);
        //System.out.println(arr2.length);    // 未初始化的数组不能获取长度


        // 4 如何遍历数组：需要使用双层for循环
        int[] ints5[] = new int[][]{{1, 2, 3}, {4, 5}, {6, 7, 8}};
        // 使用普通循环
        for(int i = 0; i < ints5.length; i++) {
            for (int j = 0; j < ints5[i].length; j++) {
                System.out.print(ints5[i][j] + " ");
            }
            System.out.println();
        }
        // 使用增强for循环
        for (int[] ints : ints5) {
            for (int anInt : ints) {
                System.out.print(anInt+ " ");
            }
        }
    }


    /**
     * 5 数组元素的默认初始化值
     *  针对于初始化方式一：比如：int[][] arr = new int[4][3];
     *     外层元素的初始化值为：地址值
     *     内层元素的初始化值为：与一维数组初始化情况相同
     */
    @Test
    public void test5() {
        int[][] ints1 = new int[4][3];
        System.out.println(ints1[0]);       // [I@6504e3b2
        System.out.println(ints1[0][0]);    // 0

        float[][] floats = new float[4][3];
        System.out.println(floats[0]);      // [F@515f550a
        System.out.println(floats[0][0]);   // 0.0

        String[][] strings = new String[4][2];
        System.out.println(strings[1]);         // [Ljava.lang.String;@626b2d4a
        System.out.println(strings[1][1]);      // null

        double[][] doubles = new double[4][];
        System.out.println(doubles[1]);         // null
    }


    /**
     *  针对于初始化方式二：比如：int[][] arr = new int[4][];
     *  	外层元素的初始化值为：null
     *     内层元素的初始化值为：不能调用，否则报错。
     *
     *  ⑥ 数组的内存解析
     */
    @Test
    public void test6() {

    }
}
