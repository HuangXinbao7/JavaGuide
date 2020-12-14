package com.atguigu.javase.inheritance;

public class PersonTest {

    public static void main(String[] args) {
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

        System.out.println(student.say());
        student.study();

    }
}
