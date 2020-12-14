package com.atguigu.javase.inheritance;

// 子类继承父类的写法是用关键字 extends 是扩展, 在父类的基础上进行扩展.
public class Student extends Person {
    /*
    String name;
    int age;
    String gender;

    public String say() {
        return "姓名 : " + name + ", 年龄 : " + age + ", 性别 : " + gender;
    }*/
    String school; // 子类特有成员.

    public void study() {
        //System.out.println(name + "学生在学习"); // 继承的属性可以直接使用
        System.out.println(getName() + "学生在学习"); // 继承的私有属性必须间接使用
    }
}
