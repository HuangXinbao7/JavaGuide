package com.xinbao.javase.chap03_array;

import org.junit.Test;

/**
 * 一维数组
 * 1.数组的理解：数组(Array)，是多个相同类型数据按一定顺序排列的集合，并使用一个名字命名，
 * 并通过编号的方式对这些数据进行统一管理。
 *
 * 2.数组相关的概念：
 *  数组名
 *  元素
 *  角标、下标、索引
 *  数组的长度：元素的个数
 *
 * 3.数组的特点：
 * 1）数组是有序排列的
 * 2）数组属于引用数据类型的变量。数组的元素，既可以是基本数据类型，也可以是引用数据类型
 * 3）创建数组对象会在内存中开辟一整块连续的空间
 * 4）数组的长度一旦确定，就不能修改。
 *
 * 4.数组的分类：
 *   ① 按照维数：
 *      一维数组、二维数组、等等
 *   ② 按照数组元素的类型：
 *      基本数据类型元素的数组、引用数据类型元素的数组
 *
 * 5.一维数组的使用
 *   ① 一维数组的声明和初始化
 *   ② 如何调用数组的指定位置的元素
 *   ③ 如何获取数组的长度
 *   ④ 如何遍历数组
 *   ⑤ 数组元素的默认初始化值
 *   ⑥ 数组的内存解析 ：见ArrayTest1.java
 */
public class LinearArrayTest {
    public static void main(String[] args) {
        // 1 一维数组的声明和初始化
        int[] ids;      // 声明
        // 静态初始化：数组的初始化和数组元素的赋值操纵同时进行，即一步完成声明和赋值操作
        ids = new int[]{1,2,3,4,5};
        // 动态初始化：数组的初始化
        String[] names = new String[5];

        //int[] arr1 = new int[];
        //int[5] arr2 = new int[5];
        //int[] arr3 = new int[3]{1,2,3};

        // 正确的写法
        int[] arr4 = {1,2,3,4};     // 类型推断

        // 总结：数组一旦初始化，其长度就确定了。


        // 2 调用数组的指定位置的元素：通过角标的方式调用。
        // 数组的角标（也称为索引）从0开始，到数组的长度-1结束。
        names[0] = "张三";
        names[1] = "李四";
        names[2] = "王五";
        names[3] = "赵六";


        // 3 获取数组长度：属性 length
        System.out.println(names.length);
        System.out.println(ids.length);


        // 4 遍历数组
        // 增强for循环
        for (String name : names) {
            System.out.println(name);
        }
    }


    /**
     * 5 数组元素的默认初始化值
     *  数组元素是整型：         0
     *  数组元素是浮点型：       0.0
     *  数组元素是char型：      0或'\u0000'，而非'0'
     *  数组元素是boolean型：   false
     *  数组元素是引用数据类型：  null
     */
    @Test
    public void test5() {
        int[] arr1 = new int[5];
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        short[] arr2 = new short[5];
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

        float[] arr3 = new float[5];
        for(int i = 0;i < arr3.length;i++){
            System.out.print(arr3[i] + " ");
        }
        System.out.println();

        char[] arr4 = new char[4];
        for(int i = 0; i < arr4.length; i++){
            System.out.print(arr4[i] + " ");
        }
        System.out.println();
        if(arr4[0] == 0){
            System.out.print("arr4[0] == 0");
        }
        System.out.println();

        boolean[] arr5 = new boolean[5];
        System.out.println(arr5[0]);

        String[] arr6 = new String[5];
        System.out.println(arr6[0]);
        if(arr6[0] == null){
            System.out.println("arr6[0] == null");
        }
    }


    /**
     * 6 数组的内存解析
     */
    @Test
    public void test6() {

    }
}
