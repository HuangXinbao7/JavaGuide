package com.atguigu.javase.wrapper;

// 面试题
public class WrapperInterview {

    public static void main(String[] args) {

        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);     // false：因为new了2次对象,i 和 j 是两个对象

        // 变量保存在整型常量池中
        Integer m = 2;
        Integer n = 2;
        System.out.println(m == n);     // true

        // 128 超出 int 大小范围，会在堆中创建新对象
        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);     // false
    }
}
