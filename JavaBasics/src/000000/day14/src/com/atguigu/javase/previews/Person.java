package com.atguigu.javase.previews;

// 类变量应用举例
public class Person {
    private int id;     // 类的私有成员变量
    public static int total = 0;    // 类变量：static修饰的静态成员
    // 无参构造
    public Person() {
        total++;
        id = total;
    }


    public static void main(String[] args) {
        Person Tom = new Person();
        Tom.id = 0;
        total = 100;    // 不用创建对象就可以访问静态成员

        Person.total = 200;     // 不用创建对象就可以访问静态成员
        System.out.println(Person.total);   // 访问：类名.类属性，类名.类方法

        Person c = new Person();
        System.out.println(c.total);    // 201, 通过对象也可以访问
    }
}
