package com.atguigu.javase.test;

public class ArrayTest {

    public static void main(String[] args) {

        char[] c = new char[1];

        System.out.println(c[0]);
        System.out.println('\u0000');
        System.out.println(c[0] == '\u0000');

        boolean[] b = new boolean[1];
        System.out.println(b[0]);

        float[] f = new float[1];
        System.out.println(f[0]);

        int bb[][] = {{1,2}, {3,4}};
        int cc[][] = {{1,2},{3,4}};

        int aac[][] = new int[8][8];

        // 数组定义方式的多样性
        int []d[] = new int[5][5];


    }
}
