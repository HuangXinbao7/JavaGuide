package com.atguigu.javase.exception;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnn{
    String value();
}

class A {
    void except() throws Exception { // 这是受检异常， 必须在方法声明中添加throws
        throw new Exception("老师在这里也可以传参数，就报错误，下面那个没有报错，为什么？");
    }

    void err() { // 此方法抛出的是非受检异常, 签名中可以不加throws
        throw new Error("老师这个地方传参是什么意思，这个Error不是系统抛吗？我也可以人为抛吗？");
    }
}

public class test {

    public static void main(String[] args) {

        new A().err();
        try {
            new A().except();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println((int)(Math.random() * 16 + 1));
        // 北京五组
        // sh 3, 4
    }
}
