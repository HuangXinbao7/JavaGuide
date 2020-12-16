package com.atguigu.javase.homework;

public class ArrayTest {

    public void test(){
        char[] arr = new char[]{'a','b','c'};
        System.out.println(arr); // char数组“就是”字符串， 字符串内部使用char[]

        int[] arr1 = new int[]{1,2,3};
        System.out.println(arr1);

        double[] arr2 = new double[]{1.1,2.2,3.3};
        System.out.println(arr2);
    }

    public static void main(String[] args) {
        ArrayTest arrayTest = new ArrayTest();
        arrayTest.test(); // 静态环境中不能直接访问非静态成员
    }
}
