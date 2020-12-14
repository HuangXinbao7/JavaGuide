package com.atguigu.javase.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
@interface Ann {
    int id() default 10;
    int num = 20; // 全局常量
}


@Ann
public class AnnotationTest {

    public static void main(String[] args) throws InterruptedException {
        Ann annotation = AnnotationTest.class.getAnnotation(Ann.class);
        System.out.println(annotation.num);
        synchronized ("") {
            "".wait(3000);
            System.out.println("after wait");
        }
    }
}
