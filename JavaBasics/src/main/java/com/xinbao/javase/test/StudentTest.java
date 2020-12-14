package com.xinbao.javase.test;

//import com.atguigu.javase.javabean.Student;

import com.xinbao.javase.homework.Student;

/**
 * 测试类要求是公共类
 * */
public class StudentTest {

    // 把学生对象数组翻转
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
            int index1 = (int) (Math.random() * 200) % names1.length;   // 取随机姓
            int index2 = (int) (Math.random() * 200) % names2.length;   // 取随机名

            String name = names1[index1] + names2[index2];
            int grade = (int) (Math.random() * 6 + 1);
            double score = (int) (Math.random() * 101);
            stuArr[i] = new Student(id, name, grade, score);
        }

        for (int i = 0; i < stuArr.length; i++) {
            System.out.println(stuArr[i].say());
        }
        System.out.println("*************************************");
        // 把学生对象数组翻转
        for (int i = 0; i < stuArr.length / 2; i++){
            Student tmp = stuArr[i];
            stuArr[i] = stuArr[stuArr.length - 1 - i];
            stuArr[stuArr.length - 1 - i] = tmp;
        }

        for(int i = 0; i < stuArr.length; i++){
            System.out.println(stuArr[i].say());
        }
    }


    // 使用下标的方式找出全校最牛
    public static void main6(String[] args) {
        /*
        创建一个Student[] 包含20个元素
        用循环创建20个学生对象, 要求id从1~20, 姓名随机产生, 年级随机的[1~6], 分数随机的[0~100]分.遍历对象数组, 打印输出
        */
        Student[] stuArr = new Student[20];
        String[] names1 = {"李", "王", "赵", "张", "刘", "杨", "曹"};
        String[] names2 = {"刚", "伟", "丽", "娜", "琳", "宁", "旭", "阳", "帅"};
        for (int i = 0; i < stuArr.length; i++) {
            int id = i + 1;
            int index1 = (int) (Math.random() * 200) % names1.length;   // 取随机姓
            int index2 = (int) (Math.random() * 200) % names2.length;   // 取随机名

            String name = names1[index1] + names2[index2];
            int grade = (int) (Math.random() * 6 + 1);
            double score = (int) (Math.random() * 101);
            stuArr[i] = new Student(id, name, grade, score);
        }

        for (int i = 0; i < stuArr.length; i++) {
            System.out.println(stuArr[i].say());
        }
        System.out.println("***********************");
        // 通过下标找出全校最牛和最菜的学生
        int maxIndex = 0;   // 假设第一个同学最牛
        int minIndex = 0;   // 假设第一个同学最菜

        for (int i = 0; i < stuArr.length; i++){
            if(stuArr[i].getScore() > stuArr[maxIndex].getScore()){
                maxIndex = i;
            }

            if(stuArr[i].getScore() < stuArr[minIndex].getScore()){
                minIndex = i;
            }
        }
        System.out.println("全校最牛：" + stuArr[maxIndex].say());
        System.out.println("全校最菜：" + stuArr[minIndex].say());
    }


    // 找出3年级最高分和最低分
    // 找出3年级谁最牛和最菜
    public static void main5(String[] args) {
        /*
        创建一个Student[] 包含20个元素
        用循环创建20个学生对象, 要求id从1~20, 姓名随机产生, 年级随机的[1~6], 分数随机的[0~100]分.遍历对象数组, 打印输出
        */
        Student[] stuArr = new Student[20];
        String[] names1 = {"李", "王", "赵", "张", "刘", "杨", "曹"};
        String[] names2 = {"刚", "伟", "丽", "娜", "琳", "宁", "旭", "阳", "帅"};
        for (int i = 0; i < stuArr.length; i++) {
            int id = i + 1;
            int index1 = (int) (Math.random() * 200) % names1.length;
            int index2 = (int) (Math.random() * 200) % names2.length;

            String name = names1[index1] + names2[index2];
            int grade = (int) (Math.random() * 6 + 1);
            double score = (int) (Math.random() * 101);
            stuArr[i] = new Student(id, name, grade, score);
        }

        for (int i = 0; i < stuArr.length; i++) {
            System.out.println(stuArr[i].say());
        }
        System.out.println("***************************************");
        // 找出3年级最高分和最低分
        double max3 = -1;    // 初值选择
        double min3 = 101;   // 初值选择

        for (int i = 0; i < stuArr.length; i++) {
            if(stuArr[i].getGrade() == 3){
                if (stuArr[i].getScore() > max3) {
                    max3 = stuArr[i].getScore();
                }
                if(stuArr[i].getScore() < min3){
                    min3 = stuArr[i].getScore();
                }
            }
        }
        if(max3 == -1){
            System.out.println("没有3年级同学");
        }else{
            System.out.println("三年级的最高分：" + max3);
            System.out.println("三年级的最低分：" + min3);
        }
        System.out.println("***************************************");
        // 找出三年级成绩最高和最低的同学信息
        Student maxStudent3 = null;    // 初值选择：表示此时还没有3年级的同学
        Student minStudent3 = null;    // 初值选择：

        for (int i = 0; i < stuArr.length; i++) {
            if (stuArr[i].getGrade() == 3){
                if (maxStudent3 == null) {      // 如果是第一个三年级同学
                    maxStudent3 = stuArr[i];    // 直接刷值
                }else {     // 后面的三年级同学
                    if (stuArr[i].getScore() > maxStudent3.getScore()){
                        maxStudent3 = stuArr[i];
                    }
                }

                if (minStudent3 == null) {      // 如果是第一个三年级同学
                    minStudent3 = stuArr[i];    // 直接刷值
                }else {     // 后面的三年级同学
                    if (stuArr[i].getScore() < minStudent3.getScore()){
                        minStudent3 = stuArr[i];
                    }
                }
            }
        }
        if(maxStudent3 != null) {
            System.out.println("3年级最牛：" + maxStudent3.say());
        }else{
            System.out.println("没有三年级同学");
        }

        if(minStudent3 != null) {
            System.out.println("3年级最差：" + minStudent3.say());
        }else{
            System.out.println("没有三年级同学");
        }
    }

    // 找出全校最高分和最低分
    // 找出全校最牛和最菜的同学
    public static void main4(String[] args) {
        /*
        创建一个Student[] 包含20个元素
        用循环创建20个学生对象, 要求id从1~20, 姓名随机产生, 年级随机的[1~6], 分数随机的[0~100]分.遍历对象数组, 打印输出
        */
        Student[] stuArr = new Student[20];
        String[] names1 = {"李", "王", "赵", "张", "刘", "杨", "曹"};
        String[] names2 = {"刚", "伟", "丽", "娜", "琳", "宁", "旭", "阳", "帅"};
        for (int i = 0; i < stuArr.length; i++){
            int id = i + 1;
            int index1 = (int)(Math.random() * 200) % names1.length;
            int index2 = (int)(Math.random() * 200) % names2.length;

            String name = names1[index1] + names2[index2];
            int grade = (int)(Math.random() * 6 + 1);
            double score = (int)(Math.random() * 101);
            stuArr[i] = new Student(id, name, grade, score);
        }

        for (int i = 0; i < stuArr.length; i++) {
            System.out.println(stuArr[i].say());
        }
        System.out.println("***********************************************");
        // 求全校最高分和最低分
        double max = stuArr[0].getScore();
        double min = stuArr[0].getScore();

        // 最高分、最低分
        for (int i = 0; i < stuArr.length; i++) {
            if (stuArr[i].getScore() > max) {
                max = stuArr[i].getScore();
            }

            if (stuArr[i].getScore() < min) {
                min = stuArr[i].getScore();
            }
        }
        System.out.println("全校最高分：" + max);
        System.out.println("全校最低分：" + min);


        System.out.println("***********************************************");
        // 求全校成绩最高和最低的同学信息
        Student maxStudent = stuArr[0];     // 假设第一位同学成绩最高
        Student minStudent = stuArr[0];     // 假设第一位同学成绩最低
        for(int i = 0; i < stuArr.length; i++) {
            if(stuArr[i].getScore() > maxStudent.getScore()) {
                maxStudent = stuArr[i];
            }

            if(stuArr[i].getScore() < minStudent.getScore()) {
                minStudent = stuArr[i];
            }
        }
        // 打印最牛的同学
        for (int i = 0; i < stuArr.length; i++){
            if(stuArr[i].getScore() == maxStudent.getScore()){
                System.out.println("maxStudent = " + stuArr[i].say());
            }
        }
        // 打印最菜的同学
        for (int i = 0; i < stuArr.length; i++){
            if(stuArr[i].getScore() == minStudent.getScore()){
                System.out.println("minStudent = " + stuArr[i].say());
            }
        }
    }

    // 求3年级的平均分
    public static void main3(String[] args) {
        /*
        创建一个Student[] 包含20个元素
        用循环创建20个学生对象, 要求id从1~20, 姓名随机产生, 年级随机的[1~6], 分数随机的[0~100]分.遍历对象数组, 打印输出
        */
        Student[] stuArr = new Student[20];
        String[] names1 = {"李", "王", "赵", "张", "刘", "杨", "曹"};
        String[] names2 = {"刚", "伟", "丽", "娜", "琳", "宁", "旭", "阳", "帅"};
        for (int i = 0; i < stuArr.length; i++){
            int id = i + 1;
            int index1 = (int)(Math.random() * 200) % names1.length;
            int index2 = (int)(Math.random() * 200) % names2.length;

            String name = names1[index1] + names2[index2];
            int grade = (int)(Math.random() * 6 + 1);
            double score = (int)(Math.random() * 101);
            stuArr[i] = new Student(id, name, grade, score);
        }

        for (int i = 0; i < stuArr.length; i++) {
            System.out.println(stuArr[i].say());
        }

        // 求3年级的平均分
        double sum3 = 0;
        int count3 = 0;
        for (int i = 0; i < stuArr.length; i++){
            if (stuArr[i].getGrade() == 3){
                sum3 += stuArr[i].getScore();
                count3++;
            }
        }
        if (count3 != 0){
            double avg3 = sum3 / count3;
            System.out.println("三年级平均分：" + avg3);
        }else{
            System.out.println("没有三年级同学");
        }
    }

    // 遍历时只打印3年级同学
    public static void main2(String[] args) {
        /*
        创建一个Student[] 包含10个元素
        用循环创建10个学生对象, 要求id从1~10, 姓名"小明", 年级1~6, 分数10~100分.遍历对象数组, 打印输出
        */
        Student[] stuArr = new Student[30];
        for(int i = 0; i < stuArr.length; i++){
            int id = i + 1;
            String name = "小明";
            int grade = i % 6 + 1;
            double score = ((i + 1) * 10) % 101;    // 让未知数落在已知范围内

            stuArr[i] = new Student(id, name, grade, score);
        }

        // 遍历
        for (int i = 0; i < stuArr.length; i++) {
            System.out.println(stuArr[i].say());
        }
        System.out.println("*******************");

        // 遍历时只打印3年级同学
        for (int i = 0; i < stuArr.length; i++) {
            if (stuArr[i].getGrade() == 3){     // 有条件打印
                System.out.println(stuArr[i].say());
            }
        }
    }

    // main + 回车
    public static void main1(String[] args) {

        int n = Integer.parseInt(args[0]);  // 要想有命令行参数，需要编辑主类
        System.out.println(n);
        Student student = new Student(1, "小明", 2,90);
        System.out.println(student.say());  // sout + 回车
    }
}
