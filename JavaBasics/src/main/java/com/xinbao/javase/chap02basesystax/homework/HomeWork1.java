package com.xinbao.javase.chap02basesystax.homework;

/**
 * int n1 = 0x5C;
 * int n2 = 0xDA;
 * 根据定义的n1和n2，输出它们的 &, |, ^
 */
public class HomeWork1 {
    public static void main(String[] args){

        int n1 = 0x5C;
        int n2 = 0xDA;

        /*
         * n1 & n2 => 0x5C & 0xDA =>
         * 0000 0000 0000 0000 0000 0000 0101 1100 &
         * 0000 0000 0000 0000 0000 0000 1101 1010 =
         * 0000 0000 0000 0000 0000 0000 0101 1000 => 0x58
         */
        System.out.println(n1 & n2);


        /*
         * n1 | n2 => 0x5C | 0xDA =>
         * 0000 0000 0000 0000 0000 0000 0101 1100 |
         * 0000 0000 0000 0000 0000 0000 1101 1010 =
         * 0000 0000 0000 0000 0000 0000 1101 1110 => 0xDE
         */
        System.out.println(n1 | n2);


        /*
         * n1 ^ n2 => 0x5C ^ 0xDA =>
         * 0000 0000 0000 0000 0000 0000 0101 1100 ^
         * 0000 0000 0000 0000 0000 0000 1101 1010 =
         * 0000 0000 0000 0000 0000 0000 1000 0110 => 0x86
         */
        System.out.println(n1 ^ n2);
    }
}
