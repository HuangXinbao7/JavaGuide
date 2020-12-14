package com.atguigu.javase.java8;

import org.junit.Test;

/**
 * 写一个接口，包含一个抽象方法，void hello(String)
 * 分别使用匿名内部类和lambda完成实现，并测试这个方法
 */

interface I2 {
    void hello(String str);
}

interface test4 {
    void test4(int n, double d, String s);
}

public class LambdaExer {

    @Test
    public void test4(){

    }


    @Test
    public void test1() {
        I2 i21 = new I2() {
            @Override
            public void hello(String str) {
                System.out.println(str);
            }
        };
        i21.hello("fadf");

        // 如果参数类型可以推断，则参数类型可以省，从而参数列表的括号也可以省略
        // 如果方法体中只有一行时，则花括号也可以省略
        I2 i22 = (String str) -> {System.out.println(str);};
        i22.hello("fadf");
    }



}
