package com.atguigu.javase.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 对象流的实例：对象序列化
 * 类要想被序列化，必须实现 Serializable 接口
 * 没有方法的接口称为标记接口，Serializable就是没有方法的接口
 */
public class ObjectSerializableTest {

    public static void main(String[] args) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("对象序列化");
            oos = new ObjectOutputStream(fos);  // 封装 fos

            // 创建4个对象
            Student s1 = new Student(1, "小明", 2, 80);
            Student s2 = new Student(2, "小丽", 3, 50);
            Student s3 = new Student(3, "小刚", 5, 66);
            Student s4 = new Student(4, "小芳", 4, 78);

            // 序列化对象到文件中
            oos.writeObject(s1);
            oos.writeObject(s2);
            oos.writeObject(s3);
            oos.writeObject(s4);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


/**
 * 创建一个 Student 类
 * 类要想被实例化，必须实现 Serializable 接口
 */
class Student implements Serializable {

    private int id;
    private String name;
    private int grade;
    private double score;   // transient，短暂的，不能被实例化

    public Student() {
    }

    public Student(int id, String name, int grade, double score) {
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
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
}