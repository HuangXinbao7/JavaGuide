package com.xinbao.javase.chap02basesystax;

import org.junit.Test;

public class BooleanTest {

    @Test
    public void test1() {

        boolean b1 = true;
        boolean b2 = false;
        boolean b3 = b1;
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        // 强制类型转换不可以转换整数到布尔
        //boolean b4 = (boolean)1;
    }
}
