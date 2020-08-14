package com.atguigu.javase.annotationtest;

/**
 * Deprecated -->该方法过时(有更好的解决方案)
 */
public class DeprecatedTest {
    @Deprecated     // test() 方法被修饰为过时
    public int test() {
        System.out.println("DeprecatedTest.test() 已被弃用。");
        return 0;
    }

    public void test(int a) {
        System.out.println("TestDeprecated.test(int)");
    }


    public static void main(String[] args) {
        DeprecatedTest dt = new DeprecatedTest();
        dt.test();
        dt.test(100);
    }
}
