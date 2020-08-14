package com.atguigu.javase.homework;

import com.atguigu.javase.homework.Student;

public class StudentTest {

    public static void main(String[] args) {
        /*
        创建一个Student[] 包含20个元素
        用循环创建20个学生对象, 要求id从1~20, 姓名随机产生, 年级随机的[1~6], 分数随机的[0~100]分.遍历对象数组, 打印输出
        */
        Student[] stuArr = new Student[20];
        String[] names1 = {"李", "王", "赵", "张", "刘", "杨", "曹"};
        String[] names2 = {"刚", "伟", "丽", "娜", "琳", "宁", "旭", "阳", "帅"};
        for (int i = 0; i < stuArr.length; i++) {
            int id = i + 1;
            int index1 = (int)(Math.random() * 200) % names1.length;   // 取随机姓的下标
            int index2 = (int)(Math.random() * 200) % names2.length;   // 取随机名的下标

            String name = names1[index1] + names2[index2];
            int grade = (int) (Math.random() * 6 + 1);
            double score = (int) (Math.random() * 101);
            stuArr[i] = new Student(id, name, grade, score);
        }

        for (int i = 0; i < stuArr.length; i++) {
            System.out.println(stuArr[i].say());
        }
        System.out.println("***********************");
        // 使用下标的方式找出3年级最牛和最菜的学生
        int maxIndex = -1;   // 表示还没找到三年级
        int minIndex = -1;

        for (int i = 0; i < stuArr.length; i++) {
            //
            if(stuArr[i].getGrade() == 3) {
                if(maxIndex == -1) {    // 如果是第一个三年级同学
                    maxIndex = i;
                }else {
                    if(stuArr[i].getScore() > stuArr[maxIndex].getScore()){
                        maxIndex = i;
                    }
                }

                if(minIndex == -1) {    // 如果是第一个三年级同学
                    minIndex = i;
                }else {
                    if(stuArr[i].getScore() < stuArr[minIndex].getScore()){
                        minIndex = i;
                    }
                }
            }
        }

        if(maxIndex != -1){
            System.out.println("3年级最牛：" + stuArr[maxIndex].say());
        }else{
            System.out.println("没找到三年级学生");
        }

        if(minIndex != -1){
            System.out.println("3年级最牛：" + stuArr[minIndex].say());
        }else{
            System.out.println("没找到三年级学生");
        }
    }
}
