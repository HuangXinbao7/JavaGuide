package com.atguigu.javase.previews;

// 类变量应用举例
public class PersonTest {
    public static void main(String[] args) {
        Person.total = 100;     // 不用创建对象就可以访问静态成员
        System.out.println(Person.total);   // 访问：类名.类属性，类名.类方法

        Person c = new Person();
        System.out.println(c.total);    // 101, 通过对象也可以访问
    }
}
