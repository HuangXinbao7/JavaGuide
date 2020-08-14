package com.atguigu.javase.reflect;

/**
 * 写一个 Student 类，用反射的方式创建对象，并打印输出
 */
class Student {

    private String name;
    private int age;
    private String gender;

    public Student() {
    }

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }


    public void study(String content, String room) {
        System.out.println(toString() + " 在学习");
    }

    // 私有方法
    private String study2(String content, String room) {
        return toString() + " 在学习";
    }
}
