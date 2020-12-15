package com.atguigu.javase.test;

public class Test2 {

    public static void main(String[] args) {
        System.out.print("请输入杨辉三角的行数：");
        int n = 10;

        int[][] arrays = new int[n][];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = new int[i + 1];
            //左边打印空格，打印等腰三角形
            for(int k = 0; k<= n-i; k++ ){
                System.out.print(" ");
            }
            for (int j = 0; j < arrays[i].length; j++) {

                if (i == 0 || j == 0 || i == j) {
                    arrays[i][j] = 1;
                } else {
                    arrays[i][j] = arrays[i - 1][j] + arrays[i - 1][j - 1];
                }

                System.out.print(arrays[i][j] + " ");
            }
            System.out.println();
        }
    }
}
