package com.atguigu.javase.test;

public class ChineseTest {

    public static void main(String[] args) {
        // 创建一个字符数组, 保存所有汉字.
        char first = '一';
        char last = '龥';
        char[] chinese = new char[last - first + 1];
        for (int i = 0; i < chinese.length; i++) {
            chinese[i] = (char)(first + i);
        }
        // 遍历
        for (int i = 0; i < chinese.length; i++) {
            System.out.print(chinese[i] + " ");
            if (i % 20 == 19) {
                System.out.println();
            }
        }
        System.out.println(chinese.length);
    }
}
