package com.atguigu.javase.inheritance;

public class PersonTest {

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.say());
    }

    public static void main3(String[] args) {
        Student student = new Student(); // 创建子类对象时, 父类构造器也执行了.
        System.out.println(student.say());
    }

    public static void main2(String[] args) {
        Teacher teacher = new Teacher();
        teacher.setName("佟刚");
        teacher.setAge(40);
        teacher.setGender("男");
        teacher.salary = 20000;

        System.out.println(teacher.say());
    }

    public static void main1(String[] args) {
        Student student = new Student();
        //student.name = "小明"; // 继承
        student.setName("小明");
        //student.age = 20; // 所有权
        student.setAge(20);
        //student.gender = "男";
        student.setGender("男");
        student.school = "atguigui"; // 特有

        //System.out.println(student.name);
        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student.getGender());
        System.out.println(student.school);
        student.study();

        //System.out.println(student.super.say()); // 绝对不行, 在测试类永远无法调用到父类的被覆盖方法
        // 重写的概念是指从第三方角度来看.
        System.out.println(student.say()); // 对于测试类来说, 它只有一个say()
        // 对于测试类来说, 它有两个gender在共存.
    }
}
