package com.xinbao.javase.basesyntax;

import org.junit.Test;

public class CharTest {

    @Test
    public void test2() {

        char c1 = '中';
        System.out.println((int)c1);    // 20013

        c1 = (char)(c1 + 1000);
        System.out.println(c1);     // 刕

        c1 = (char)(c1 + 10000);
        System.out.println(c1);     // 礥
    }


    @Test
    public void test1() {

        char c0 = 0;    // 是空字符
        System.out.println("c0: " + c0);

        // char型中保存的是 Unicode码值，本质是正整数，可以看成是整数
        char c1 = 'a';  // 查表，查到 'a' 对应的码值为 97，所以c1变量中保存的是 97
        char c2 = 'A';  // 大写字母的码值比小写字母的码值小32
        char c3 = '0';  // 数字字符从48开始
        char c4 = '中';  // 字符变量中也可以保存中文，英文保存的是Unicode码值
        System.out.println(c1);
        System.out.println(c2);     // char中保存的是码值，但是打印时，还是打印对应的字符
        System.out.println(c3);
        System.out.println(c4);

        // 本质上来讲，char就是整数
        System.out.println((int)c0);    // 0
        System.out.println((int)c1);    // 97
        System.out.println((int)c2);    // 65
        System.out.println((int)c3);    // 48
        System.out.println((int)c4);    // '中'字对应的数字数 20013

        char c5 = '国';
        c5 = (char)(c5 + 2000);     // 非long整数做运算，结果总是int型
        System.out.println(c5);     // 廍

        char c6 = 100;
        System.out.println(c6);     // 可以直接打印char型变量中的码值整数，其实打印的是码值对应的字符
    }
}
