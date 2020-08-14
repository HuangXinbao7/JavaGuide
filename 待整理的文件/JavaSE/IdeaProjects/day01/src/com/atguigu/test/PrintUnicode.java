package com.atguigu.test;

import com.sun.javaws.IconUtil;

public class PrintUnicode {

    public static void main(String[] args) {

        char c1 = '黄';
        char c2 = '新';
        char c3 = '宝';

        System.out.println((int)c1);
        System.out.println((int)c2);
        System.out.println((int)c3);

        c1 = (char)(c1+1);
        System.out.println(c1);
    }
}
