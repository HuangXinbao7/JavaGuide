package com.xinbao.javase.chap02basesystax;

import org.junit.Test;


public class BinaryTest {

    @Test
    public void test1() {

        int num1 = 0b110;
        int num2 = 110;
        int num3 = 0127;
        int num4 = 0x110A;

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("num3 = " + num3);
        System.out.println("num4 = " + num4);


        byte b1 = (byte)0x80;       // 十六进制的整数字面量，编译器不优化
        byte b2 = (byte)0x7F;
        System.out.println(b1);     // -128
        System.out.println(b2);     // 127

        short s1 = (short)0x8000;
        short s2 = (short)0x7FFF;
        System.out.println(s1);     // -32768
        System.out.println(s2);     // 32767

        int i1 = 0x80000000;
        int i2 = 0x7FFFFFFF;
        System.out.println(i1);     // -2147483648
        System.out.println(i2);     // 2147483647

        long l1 = 0x8000000000000000L;
        long l2 = 0x7FFFFFFFFFFFFFFFL;
        System.out.println(l1);     // -9223372036854775808
        System.out.println(l2);     // -9223372036854775807
    }
}
