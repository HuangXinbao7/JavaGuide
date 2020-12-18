package com.atguigu.javase.collection;

import java.util.Objects;

public class Student {

    private int id;
    private String name;
    private int grade;
    private int score;

    public Student() {
    }

    public Student(int id, String name, int grade, int score) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", score=" + score +
                '}';
    }

    /**
     * 如果两个对象的 equals 为 true，那么两个对象的哈希码必须一样，体现特征性。
     * 如果两个对象的 equals 为 false，那么两个对象的哈希码必须不同，体现散列性。
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                grade == student.grade &&
                score == student.score &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, grade, score);
    }
}
