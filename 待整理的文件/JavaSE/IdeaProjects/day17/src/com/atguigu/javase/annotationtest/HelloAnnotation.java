package com.atguigu.javase.annotationtest;
import java.lang.annotation.*;

/**
 * 写一个自定义注解 HelloAnnotation，包含属性 int num，String value。属性 num 有缺省值 10
 * 再写一个Person类，有属性，有方法，有构造器，在 Person 类中的各地方使用自定义注解。
 */
//@Target({ElementType.TYPE, ElementType.METHOD})   // 只能用在类和方法上
@Retention(RetentionPolicy.RUNTIME)     // 可以停留在运行时
public @interface HelloAnnotation {     // 有public修饰的注解可以跨包使用

    public static final int id = 20;

    public abstract int num() default 10;   // 将来这是一个方法，其本质上也是方法

    public abstract String value(); // 也是方法
}
