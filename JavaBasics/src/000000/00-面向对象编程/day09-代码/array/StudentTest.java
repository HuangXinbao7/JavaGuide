package com.atguigu.javase.array;


import com.atguigu.javase.javabean.Student;

/**
 * 测试类要求是公共类.
 */
public class StudentTest {

    public static void main(String[] args) {
         /*创建一个Student[] 包含20个元素
        用循环创建20个学生对象, 要求id从1~20, 姓名随机产生, 年级随机的[1~6], 分数随机的[0~100]分.遍历对象数组, 打印输出*/
        Student[] stuArr = new Student[8];
        String[] names1 = {"李", "王", "赵", "张", "刘", "杨", "曹"};
        String[] names2 = {"刚", "伟", "丽", "娜", "琳", "宁", "旭", "阳", "帅"};
        for (int i = 0; i < stuArr.length; i++) {
            int id = i + 1;
            int index1 = (int) (Math.random() * 2000) % names1.length;
            int index2 = (int) (Math.random() * 2000) % names2.length;
            String name = names1[index1] + names2[index2];
            int grade = (int) (Math.random() * 6 + 1);
            double score = (int) (Math.random() * 101);
            stuArr[i] = new Student(id, name, grade, score);
        }
        for (int i = 0; i < stuArr.length; i++) {
            System.out.println(stuArr[i].say());
        }
        System.out.println("***********************************************");

        // 使用下标的方式找出全校最牛.
        int maxIndex = 0; // 假设第一位同学最牛
        for (int i = 0; i < stuArr.length; i++) {
            if (stuArr[i].getScore() > stuArr[maxIndex].getScore()) { // 如果i位置的同学的分数比最高分位置的同学的分数还高
                maxIndex = i;
            }
        }
        System.out.println("最牛 : " + stuArr[maxIndex].say());
        // 把学生对象数组反转
    }

    public static void main5(String[] args) {
         /*创建一个Student[] 包含20个元素
        用循环创建20个学生对象, 要求id从1~20, 姓名随机产生, 年级随机的[1~6], 分数随机的[0~100]分.遍历对象数组, 打印输出*/
        Student[] stuArr = new Student[8];
        String[] names1 = {"李", "王", "赵", "张", "刘", "杨", "曹"};
        String[] names2 = {"刚", "伟", "丽", "娜", "琳", "宁", "旭", "阳", "帅"};
        for (int i = 0; i < stuArr.length; i++) {
            int id = i + 1;
            int index1 = (int) (Math.random() * 2000) % names1.length;
            int index2 = (int) (Math.random() * 2000) % names2.length;
            String name = names1[index1] + names2[index2];
            int grade = (int) (Math.random() * 6 + 1);
            double score = (int) (Math.random() * 101);
            stuArr[i] = new Student(id, name, grade, score);
        }
        for (int i = 0; i < stuArr.length; i++) {
            System.out.println(stuArr[i].say());
        }
        System.out.println("***********************************************");
        // 找出3年级最高分和最低分.
        double max3 = -1;
        double min3 = 101;
        for (int i = 0; i < stuArr.length; i++) {
            if (stuArr[i].getGrade() == 3) {
                if (stuArr[i].getScore() > max3) {
                    max3 = stuArr[i].getScore();
                }
                if (stuArr[i].getScore() < min3) {
                    min3 = stuArr[i].getScore();
                }
            }
        }
        if (max3 == -1) {
            System.out.println("没有3年级同学");
        } else {
            System.out.println("max3 = " + max3);
            System.out.println("min3 = " + min3);
        }
        // 找出3年级谁最牛
        Student maxStudent3 = null; // 表示此时还没有3年级同学
        for (int i = 0; i < stuArr.length; i++) {
            if (stuArr[i].getGrade() == 3) {
                if (maxStudent3 == null) { // if (第一个3年级同学) {
                    maxStudent3 = stuArr[i]; //不要比了, 直接刷值;
                } else { // 后面的3年级同学
                    if (stuArr[i].getScore() > maxStudent3.getScore()) { // 如果某同学比最牛的同学还牛, 某同学分数高于最牛同学的分数
                        maxStudent3 = stuArr[i];
                    }
                }
            }
        }
        if (maxStudent3 != null) {
            System.out.println("3年级最牛 : " + maxStudent3.say());
        } else {
            System.out.println("没有3年级同学");
        }
    }

    public static void main4(String[] args) {
         /*创建一个Student[] 包含20个元素
        用循环创建20个学生对象, 要求id从1~20, 姓名随机产生, 年级随机的[1~6], 分数随机的[0~100]分.遍历对象数组, 打印输出*/
        Student[] stuArr = new Student[20];
        String[] names1 = {"李", "王", "赵", "张", "刘", "杨", "曹"};
        String[] names2 = {"刚", "伟", "丽", "娜", "琳", "宁", "旭", "阳", "帅"};
        for (int i = 0; i < stuArr.length; i++) {
            int id = i + 1;
            int index1 = (int) (Math.random() * 2000) % names1.length;
            int index2 = (int) (Math.random() * 2000) % names2.length;
            String name = names1[index1] + names2[index2];
            int grade = (int) (Math.random() * 6 + 1);
            double score = (int) (Math.random() * 101);
            stuArr[i] = new Student(id, name, grade, score);
        }
        for (int i = 0; i < stuArr.length; i++) {
            System.out.println(stuArr[i].say());
        }
        System.out.println("***********************************************");
        // 找出全校最高分和最低分.
        double max = stuArr[0].getScore();
        double min = stuArr[0].getScore();
        for (int i = 0; i < stuArr.length; i++) {
            if (stuArr[i].getScore() > max) { // 如果某同学的分数比最高分还高
                max = stuArr[i].getScore();
            }

            if (stuArr[i].getScore() < min) {
                min = stuArr[i].getScore();
            }
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        // 只到了最高分, ?? 我想找谁最牛, 谁最差...
        Student maxStudent = stuArr[0]; // 假设第一位同学最牛
        for (int i = 0; i < stuArr.length; i++) {
            if (stuArr[i].getScore() > maxStudent.getScore()) { // 如果某同学比最牛的同学还牛, 某同学分数高于最牛同学的分数
                maxStudent = stuArr[i];
            }
        }

        for (int i = 0; i < stuArr.length; i++) {
            if (stuArr[i].getScore() == maxStudent.getScore()) {
                System.out.println("maxStudent = " + stuArr[i].say());
            }
        }

        Student minStudent = stuArr[0];
        for (int i = 1; i < stuArr.length; i++) {
            if (stuArr[i].getScore() < minStudent.getScore()) {
                minStudent = stuArr[i];
            }
        }
        System.out.println("最差 : " + minStudent.say());
    }

    public static void main3(String[] args) {
        /*
        写一个类Student, 包含属性id, name, grade, score
        创建一个Student[] 包含20个元素
        用循环创建20个学生对象, 要求id从1~20, 姓名随机产生, 年级随机的[1~6], 分数随机的[0~100]分.遍历对象数组, 打印输出
        */
        Student[] stuArr = new Student[10];
        String[] names1 = {"李", "王", "赵", "张", "刘", "杨", "曹"};
        String[] names2 = {"刚", "伟", "丽", "娜", "琳", "宁", "旭", "阳", "帅"};
        for (int i = 0; i < stuArr.length; i++) {
            int id = i + 1;
            int index1 = (int)(Math.random() * 2000) % names1.length;
            int index2 = (int)(Math.random() * 2000) % names2.length;
            String name = names1[index1] + names2[index2];
            int grade = (int)(Math.random() * 6 + 1);
            double score = (int)(Math.random() * 101);
            stuArr[i] = new Student(id, name, grade, score);
        }
        for (int i = 0; i < stuArr.length; i++) {
            System.out.println(stuArr[i].say());
        }
        // 求全校平均分
        double sum = 0;
        for (int i = 0; i < stuArr.length; i++) {
            sum += stuArr[i].getScore(); // 对象不能直接累加
        }
        double avg = sum / stuArr.length;
        System.out.println("全校平均分 : " + avg);

        // 求3年级的平均分
        double sum3 = 0; // 用于求3年级所有同学的总分
        int count3 = 0; // 用于计数, 总共有几个3年级同学.
        for (int i = 0; i < stuArr.length; i++) {
            if (stuArr[i].getGrade() == 3) {
                sum3 += stuArr[i].getScore();
                count3++;
            }
        }
        if (count3 != 0) {
            double avg3 = sum3 / count3;
            System.out.println("三年级平均分 : " + avg3);
        } else {
            System.out.println("没有三年级同学");
        }
        // NaN : Not A Number, 0.0 / 0.0
        //System.out.println(1.0 / 0); // Infinity 无限大
    }

    public static void main2(String[] args) {
        /*
        写一个类Student, 包含属性id, name, grade, score
        创建一个Student[] 包含10个元素
        用循环创建10个学生对象, 要求id从1~10, 姓名"小明", 年级1~6, 分数10~100分.遍历对象数组, 打印输出
        */
        Student[] stuArr = new Student[30];
        for (int i = 0; i < stuArr.length; i++) {
            int id = i + 1;
            String name = "小明";
            int grade = i % 6 + 1;
            double score = ((i + 1) * 10) % 101; // 让未知数落在已知范围内
            stuArr[i] = new Student(id, name, grade, score);
        }

        // 遍历
        for (int i = 0; i < stuArr.length; i++) {
            System.out.println(stuArr[i].say());
        }
        System.out.println("*************************************");
        // 遍历时只打印3年级同学
        for (int i = 0; i < stuArr.length; i++) {
            if (stuArr[i].getGrade() == 3) { // 有条件打印
                System.out.println(stuArr[i].say());
            }
        }
    }
    // main 回车
    public static void main1(String[] args) {
        int n = Integer.parseInt(args[0]); // 要想有命令行参数, 需要编辑主类
        System.out.println(n);
        Student student = new Student(1, "小明", 2, 90);
        System.out.println(student.say()); // sout 回车
    }
}
