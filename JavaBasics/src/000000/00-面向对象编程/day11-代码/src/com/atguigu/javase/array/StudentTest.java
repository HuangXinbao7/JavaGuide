package com.atguigu.javase.array;

import com.atguigu.javase.javabean.Student;

public class StudentTest {

    public static void main(String[] args) {
        Student[] stuArr = new Student[20];
        for (int i = 0; i < stuArr.length; i++) {
            int id = i + 1;
            String name = "小明";
            int grade = (int)(Math.random() * 6 + 1);
            double score = (int)(Math.random() * 101);
            stuArr[i] = new Student(id, name, grade, score);
        }
        // 遍历
        for (Student tmp : stuArr) { // 这个数组完美吗?
            System.out.println(tmp.say());
        }
        System.out.println("*******************************");
        // 扩容 :
        Student[] newArr = new Student[stuArr.length * 2];
        for (int i = 0; i < stuArr.length; i++) {
            newArr[i] = stuArr[i];
        }
        stuArr = newArr;
        // 遍历
        for (Student tmp : stuArr) { // 这个数组完美吗? 不完美, 结构良好
            if (tmp != null) {
                System.out.println(tmp.say());
            } else {
                System.out.println(tmp);
            }
        }
        System.out.println("*******************************");

        // 取子数组, 取3年级
        Student[] newArr2 = new Student[stuArr.length];
        int count = 0;
        for (int i = 0; i < stuArr.length; i++) {
            if (stuArr[i] != null && stuArr[i].getGrade() == 3) {
                newArr2[count] = stuArr[i];
                count++;
            }
        }
        Student[] finalArr = new Student[count];
        for (int i = 0; i < count; i++) {
            finalArr[i] = newArr2[i];
        }
        for (Student tmp : finalArr) { // 完美吗? 完美
            System.out.println(tmp.say());
        }

    }
}
