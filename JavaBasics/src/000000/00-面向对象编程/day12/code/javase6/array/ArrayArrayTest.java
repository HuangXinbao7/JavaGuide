package com.atguigu.javase.array;

/**
 * 二维数组 : 数组的数组, 它的元素是子数组, 所以它的length是有几个子数组的意思
 * 声明方式 :
 *      int[][] a
 *      int[] a[]
 *      int a[][]
 */
public class ArrayArrayTest {

    public static void main(String[] args) {
        //定义数组int[6][7] a[3][4]前得元素个数 : 25个
        // 0 : 0, 1, 2, 3, 4, 5, 6
        // 1 : 0, 1, 2, 3, 4, 5, 6
        // 2 : 0, 1, 2, 3, 4, 5, 6
        // 3 : 0, 1, 2, 3, 4, 5, 6
        // 4 : 0, 1, 2, 3, 4, 5, 6
        // 5 : 0, 1, 2, 3, 4, 5, 6

        /*
        * 下列数组定义正确的是
        * int[][] = new int[][]; 这个不对, new 至少第一维中长度要给定
        * int b[8][8] = new int[][]; 声明时绝对不能给长度
        * int c[][] = new int[8][8]; // 对的
        * int[] d [] = new int[5][5]; // 对的
        * */

        int[][] a = new int [5][4]; //

    }

    public static void main3(String[] args) {
        int[][] arrarr = new int[3][];
        arrarr[0] = new int[] {1, 3, 4};
        arrarr[1] = new int[] {};
        arrarr[2] = new int[4];
        // 1, 3, 4
        // 空
        // 0, 0, 0, 0


        // 静态方式1, 比较灵活, 可以适用于声明和赋值分开的情况
        int[][] arrarr2;
        arrarr2 = new int[][] {{1, 9}, {7, 3, 4}, {8, 2, 5, 4, 1}};

        // 静态方式2, 这种写法只适用于声明和初始化在同一条语句 上的情况
        int[][] arrarr3 = {{1,2}, {3, 4, 5}};

        System.out.println(arrarr2[1].length); // 3

        // 在定义int a[5][4] 后, 下列选项对a引用正确 的是
        //a[2][4] 子数组下标越界
        //a[1,3] 写法错误
        //a[5][0] 取子数组越界
        //a[3][2] 这个是对的

    }

    public static void main2(String[] args) {
        int[][] yanghui = new int[20][];
        for (int i = 0; i < yanghui.length; i++) {
            yanghui[i] = new int[i + 1]; // 每行的数据个数和行数相关
            for (int j = 0; j < yanghui[i].length; j++) {
                yanghui[i][0] = 1;
                yanghui[i][i] = 1;
                if (j > 0 && j < i) {
                    yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j];
                }
            }
        }
        for (int[] child : yanghui) {
            for (int tmp : child) {
                System.out.print(tmp + " ");
            }
            System.out.println();
        }
    }

    public static void main1(String[] args) {
        int[][] arrarr = new int[10][];
        for (int i = 0; i < arrarr.length; i++) {
            arrarr[i] = new int[i + 1]; //
            for (int j = 0; j < arrarr[i].length; j++) {
                arrarr[i][j] = (int)(Math.random() * 100);
            }
        }
        // 遍历
        for (int i = 0; i < arrarr.length; i++) {
            for (int j = 0; j < arrarr[i].length; j++) {
                System.out.print(arrarr[i][j] + " ");
            }
            System.out.println();
        }

        // 找出最大值
        int max = arrarr[0][0];
        for (int[] child : arrarr) {
            for (int tmp : child) {
                if (tmp > max) {
                    max = tmp;
                }
            }
        }
        System.out.println("max = " + max);
    }
}
