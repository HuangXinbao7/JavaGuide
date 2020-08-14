package com.atguigu.javase.inheritance;

public class PC extends Computer {

    String keyboard;

    public void code() {
        System.out.println("使用PC写代码, 内存 : " + getMemory());
    }
}
