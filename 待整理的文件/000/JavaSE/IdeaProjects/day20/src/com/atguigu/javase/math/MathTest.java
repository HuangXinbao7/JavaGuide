package com.atguigu.javase.math;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MathTest {

    /**
     * 定点数：用于商业计算
     */
    @Test
    public void test3() {
        // 定点数
        BigDecimal bd1 = new BigDecimal("33410571303971531517175175133219876543214876543");
        BigDecimal bd2 = new BigDecimal("33410571303971531517175175133219876543214876543");

        BigDecimal multiply = bd1.multiply(bd2);
        System.out.println(multiply);
    }


    @Test
    public void test2() {
        BigInteger b1 = new BigInteger("347739719479137479324837249132749813794732749237497328473274923748132479237497");
        BigInteger b2 = new BigInteger("347739719479137479324837249132749813794732749237497328473274923748132479237497");

        BigInteger add = b1.add(b2);
        System.out.println(add);

        BigInteger multiply = b1.multiply(b2);
        System.out.println(multiply);
    }


    @Test
    public void test1() {

        int rand = (int)(Math.random() * 100);
        System.out.println(rand);

        double d = 3.5;
        int n = (int)d;
        System.out.println(n);  // 3

        System.out.println(Math.round(3.5));    // 4
        System.out.println(Math.round(-3.5));   // -3
        System.out.println(Math.round(-3.4));   // -3
        System.out.println(Math.round(-3.6));   // -4
    }
}
