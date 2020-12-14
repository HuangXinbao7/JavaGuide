package com.atguigu.javase.interfacetest;

/**
 * 接口：不同类不同种事物的共同行为抽象为定义，直观的作用是把不同的东西连接起来一同工作
 * 接口中只允许公共抽象方法，全局常量
 * 因为接口中全是抽象方法，由抽象方法组成，具体子类实现所有抽象方法后，相当于实现了接口（父类）
 */
// 接口表达的是一种能力，通常是形容词，也用于表示某种标准规范
public interface Flyer {

    int age = 10;   // 全局变量

    void takeOff(); // 起飞，编译器自动把它变成 public abstract
    void fly();     // 飞翔，编译器自动把它变成 public abstract
    void land();    // 落地，编译器自动把它变成 public abstract
}
