package com.xinbao.javase.chap04oop.basic.teacher;

/**
 * 类(class)和对象(object)是面向对象的核心概念。
 * 类 : 对现实世界事物的描述, 是抽象的, 是概念上的.
 * 用成员变量来描述事物的特征, 数据部分
 * 用成员方法来描述事物的行为, 功能部分
 * 类的本质也是一种新的数据类型, 也称为复合数据类型, Teacher类类型, 和int, char一样.
 */
public class Teacher {

    // 成员变量描述事物的特征
    // 属性如果没有初始化，也会有缺省值，因为对象的创建是JVM负责的
    String name;    // 也称对象属性，或实例变量
    int age;
    String gender;

    // 用成员方法来描述事物的行为
    // 对象方法或实例方法
    public void lesson() {
        System.out.println("老师在上课");
    }

    public void eat(String some) {
        System.out.println("老师在吃" + some);
    }

    // 自我介绍，返回一个字符串，内容是我的所有属性的拼接, 加上一些提醒会更清晰
    public String say() {
        String str = "姓名：" + name + ", 年龄：" + age + ", 性别：" + gender;
        return str;
    }
}
