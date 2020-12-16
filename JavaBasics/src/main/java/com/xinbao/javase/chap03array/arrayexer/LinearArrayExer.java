package com.xinbao.javase.chap03array.arrayexer;

import org.junit.Test;

public class LinearArrayExer {

    /**
     * 练习: 创建一个26元素的char数组，保存所有大写字母，并遍历打印输出
     */
    @Test
    public void test1() {
        char[] arr = new char[26];

        for(int i = 0; i < arr.length; i++){
            arr[i] = (char)('A' + i);
        }

        for (char c : arr) {
            System.out.print(c + " ");
        }
    }

    /**
     * 练习2：创建一个36个元素的char数组，前26个保存所有大写字母，后10个保存所有数字字符'0'~'9'，并遍历打印输出
     */
    @Test
    public void test2() {
        char[] arr = new char[36];

        // 数组的处理，前26个保存所有大写字母
        for(int i = 0; i < 26; i++){
            arr[i] = (char)('A' + i);
        }
        // 数组的处理，后10个保存所有数字字符'0'~'9'
        for(int i = 26; i < arr.length; i++){
            arr[i] = (char) (48 + i - 26);
        }
        // 数组的遍历，专门用于访问数组元素
        for (char c : arr) {
            System.out.print(c + " ");
        }
    }

    /**
     * 练习2：使用静态初始化方式各创建一个字符串数组，保存几位同学的名字，遍历打印输出
     */
    @Test
    public void test3() {
        String[] name = new String[]{"小明", "小红", "小丽", "小东"};
        for (String s : name) {
            System.out.println(s);
        }
    }
}
