package com.atguigu.javase.test;


class Student {
    public void study() {
        System.out.println("学习");
    }
}

class StudentDemo {
    public Student getStudent() {
        return new Student();
    }
}


public class Test1 {

    public int n = 100;

    public static void main(String[] args) {

        StudentDemo sd = new StudentDemo();
        Student s = sd.getStudent();
        s.study();
    }
}
