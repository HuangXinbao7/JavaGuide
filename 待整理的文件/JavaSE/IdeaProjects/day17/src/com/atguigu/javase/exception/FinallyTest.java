package com.atguigu.javase.exception;

public class FinallyTest {

    public static int test() {
        int n = 10;
        try {
            return n;
        } finally {
            //++n;
            return  ++n;    // 返回 11
        }
    }


    public static void main(String[] args) {

        System.out.println(test());
    }
}
