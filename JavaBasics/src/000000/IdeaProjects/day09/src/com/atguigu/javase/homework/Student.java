package com.atguigu.javase.homework;

/*
写一个类Student, 包含属性id, name, grade, score
*/
public class Student {

    private int id;
    private String name;
    private int grade;
    private double score;

    public Student() {}

    public Student(int id, String name, int grade, double score) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.score = score;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public double getScore() {
        return score;
    }

    public String say(){
        return "学号 : " + id + ", 姓名: " + name + ", 年级: " + grade + ", 分数: " + score;
    }
}