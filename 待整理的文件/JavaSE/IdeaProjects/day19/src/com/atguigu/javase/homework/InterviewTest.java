package com.atguigu.javase.homework;

import static java.lang.Character.getType;

/**
 * 作业1：面试题
 */
public class InterviewTest {

    public static void main(String[] args) {

        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); // false：i 和 j 是指向不同对象的引用，所以地址不同

        Integer m = 1;  // 直接赋值，自动装箱，创建的对象在GC区，但对象中的value值指向常量区
        Integer n = 1;  // 直接装箱，直接从缓冲区对象数组中取（-128~127）
        System.out.println(m == n); // true：m 和 n 都指向常量池中的同一个数 1

        Integer x = 128;    // 缓冲区对象数组不包含128，所以会new新的对象
        Integer y = 128;
        System.out.println(x == y); // false：128已经超出缓存范围，所以会在堆空间创建新对象保存数据
        System.out.println(128 == y); // true：y 自动拆箱

        // 查看内存地址方法
        System.out.println(System.identityHashCode(x));
        System.out.println(System.identityHashCode(y));
    }
}
