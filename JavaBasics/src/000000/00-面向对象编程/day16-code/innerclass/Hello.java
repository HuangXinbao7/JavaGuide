package com.atguigu.javase.innerclass;

public class Hello {

    private Hello ref = new Hello();

    public static void main(String[] args) {
        new Hello();
    }
}


