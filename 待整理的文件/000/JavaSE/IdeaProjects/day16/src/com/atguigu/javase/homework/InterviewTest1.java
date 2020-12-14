package com.atguigu.javase.homework;

/**
 * 面试题1：排错
 */
interface A {
    // 注释掉接口中属性定义
    int x = 0;
}

class B {
    int x = 1;
}


class C extends B implements A {
    public void pX() {
        System.out.println(super.x);      // 报错：对x的引用不明确
    }

    public static void main(String[] args) {
        new C().pX();
    }
}


public class InterviewTest1 {}
