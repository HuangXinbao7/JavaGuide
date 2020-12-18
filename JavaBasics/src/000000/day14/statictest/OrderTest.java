package com.atguigu.javase.statictest;

// 规则：先父后子，先静后动
class A {
    A() {
        System.out.println("A()");
    }   // 1
    {
        System.out.println("A {}");     // 2
    }
    static {
        System.out.println("A static{}");   // 3
    }
}

class B extends A {
    B() {
        System.out.println("B()");
    }   // 4
    {
        System.out.println("B {}");     // 5
    }
    static {
        System.out.println("B static{}");   // 6
    }
}


public class OrderTest {
    public static void main(String[] args) {
        new B();    // 362514
    }
}
