package com.xinbao.javase.chap02_basesystax.homework;

/**
 * 第二题附加：
 * 打印高度为n的等腰3角形, 并要求是空心的三角形
 */
public class HomeWork6 {
    public static void main(String[] args){

        //int n = Integer.parseInt(args[0]);
        int n = 10;

        for (int i = 0; i < n; i++) {
            // 打印每一行的前导空格
            for (int j = 0; j < n-i-1; j++) {
                System.out.print(" ");
            }
            // 打印每行空格之后的星号
            for (int k = 0; k < 2*i+1; k++){
                // 判断是不是等腰三角形的腰上的位置，是就打印星号，不是就打印空格
                // 即，每行首尾是星号，中间是空格
                // 且判断是不是最后一行，如果是最后一行，则全部打印星号
                if(k != 0 && k != 2*i && i != n-1) {
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            // 最后一行之前的所有行都换行
            if(i < n-1){
                System.out.println();
            }
        }
    }
}



class HomeWork6_2 {
    public static void main(String[] args){

        //int n = Integer.parseInt(args[0]);
        int n = 10;

        for (int i = 0; i < n; i++) {
            // 打印每一行的前导空格
            for (int j = 0; j < n-i-1; j++) {
                System.out.print(" ");
            }
            // 打印每行空格之后的星号
            for (int k = 0; k < 2*i+1; k++){
                // 判断是不是等腰三角形的腰上的位置，是就打印星号，不是就打印空格
                // 即，每行首尾是星号，中间是空格
                // 且判断是不是最后一行，如果是最后一行，则全部打印星号
                //if(k != 0 && k != 2*i && i != n-1) {

                // 第一行，最后一行，第一列，最后一列打印星号，其他打印空格
                if(i == 0 || i == n-1 || k == 0 || k==2*i) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }

            // 最后一行之前的所有行都换行
            if(i < n-1){
                System.out.println();
            }
        }
    }
}