package com.atguigu.javase.homework;

public class ArrayTest {

    public static void test(){
        char[] arrChar = new char[]{'a', 'b', 'c'};
        System.out.println(arrChar);    // char数组“就是”字符串，字符串内部使用 char[]

        int[] arrInt = new int[]{1,2,3};
        System.out.println(arrInt);     // 这里打印的是对象的地址

        double[] arrDouble = new double[]{1.1, 2.2, 3.3};
        System.out.println(arrDouble);  // 这里打印的是对象的地址
    }


    public static void main(String[] args) {
        ArrayTest arrayTest = new ArrayTest();
        // 静态环境中不能直接访问非静态成员
        arrayTest.test();
    }
}
