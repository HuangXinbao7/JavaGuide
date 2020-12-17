package com.xinbao.javase.chap04oop.basic.exer;

/**
 * 此代码是对StudentTest.java的改进：将操作数组的功能封装到方法中。
 */
public class StudentTestPro {

    public static void main(String[] args) {
        // 声明 Student 类型的数组
        Student[] students = new Student[20];

        // 遍历并赋值
        for (int i = 0; i < students.length; i++) {
            // 给数组元素赋值
            students[i] = new Student();
            // 给Student对象的属性赋值
            students[i].number = (i + 1);
            // 年级：[1,6]
            students[i].state = (int)(Math.random() * (6 - 1 + 1) + 1);
            // 成绩：[0,100]
            students[i].score = (int)(Math.random() * (100 - 0 + 1));
        }

        StudentTestPro test = new StudentTestPro();

        // 遍历学生数组
        test.printStuInfo(students);

        System.out.println("********************");
        // 问题一：打印出3年级(state值为3）的学生信息。
        test.searchState(students, 3);

        System.out.println("********************");
        // 问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
        test.sort(students);

        // 遍历学生信息
        test.printStuInfo(students);
    }


    /**
     * 遍历Student数组的操作
     */
    public void printStuInfo(Student[] stu){
        for (Student student : stu) {
            System.out.println(student.showInfo());
        }
    }


    /**
     * 查找数组中指定年级的学生信息
     * @param stu 要查找的数组
     * @param state 要找的年级
     */
    public void searchState(Student[] stu, int state){
        for (Student student : stu) {
            if (student.state == state) {
                System.out.println(student.showInfo());
            }
        }
    }

    /**
     * 给Student数组排序
     */
    public void sort(Student[] stu){
        for(int i = 0;i < stu.length - 1;i++){
            for(int j = 0;j < stu.length - 1 - i;j++){
                if(stu[j].score > stu[j + 1].score){
                    Student temp = stu[j];
                    stu[j] = stu[j + 1];
                    stu[j + 1] = temp;
                }
            }
        }
    }
}


// 定义Student类
class Student {
    int number;     // 学号
    int state;      // 年级
    int score;      // 成绩

    // 显示学生信息的方法
    public String showInfo() {
        return "学号：" + number + ", 年级：" + state + ", 成绩：" + score;
    }
}