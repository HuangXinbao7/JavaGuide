package com.atguigu.javase.array;

import com.atguigu.javase.javabean.Student;

/*
完美数组：           没有空洞的数组
新数组的结构良好：    数组前部分是连续的有效对象，剩余部分的是连续的空洞
新数组的结构糟糕：    有效对象和空洞穿插，不连续
*/
public class StudentTest {

    // 快排
    public static void main(String[] args) {
        Student[] stuArr = new Student[10];
        String[] names1 = {"李", "王", "赵", "张", "刘", "杨", "曹"};
        String[] names2 = {"刚", "伟", "丽", "娜", "琳", "宁", "旭", "阳", "帅"};
        for(int i = 0; i < stuArr.length; i++){
            int id = i + 1;
            int index1 = (int)(Math.random() * 200) % names1.length;
            int index2 = (int)(Math.random() * 200) % names2.length;
            String name = names1[index1] + names2[index2];
            int grade = (int)(Math.random() * 6 + 1);
            double score = (int)(Math.random() * 101);
            stuArr[i] = new Student(id, name, grade, score);
        }
        // 遍历
        for(Student tmp : stuArr){
            System.out.println(tmp.say());
        }
        System.out.println("********************************");
        // 快排
        for (int i = 0; i < stuArr.length - 1; i++){
            // 以i位置为基准位置，找出右侧最小值下标
            int minIndex = i;
            for(int j = i + 1; j < stuArr.length; j++){
                if(stuArr[j].getScore() < stuArr[minIndex].getScore()) {
                    minIndex = j;
                }
            }
            // minIndex中保存了右侧所有数的最小值的下标
            Student tmp = stuArr[i];
            stuArr[i] = stuArr[minIndex];
            stuArr[minIndex] = tmp;
        }
        // 遍历
        for (Student tmp: stuArr){
            System.out.println(tmp.say());
        }
        System.out.println("****************************");
    }


    // 冒泡
    public static void main9(String[] args) {
        Student[] stuArr = new Student[10];
        String[] names1 = {"李", "王", "赵", "张", "刘", "杨", "曹"};
        String[] names2 = {"刚", "伟", "丽", "娜", "琳", "宁", "旭", "阳", "帅"};
        for(int i = 0; i < stuArr.length; i++){
            int id = i + 1;
            int index1 = (int)(Math.random() * 200) % names1.length;
            int index2 = (int)(Math.random() * 200) % names2.length;
            String name = names1[index1] + names2[index2];
            int grade = (int)(Math.random() * 6 + 1);
            double score = (int)(Math.random() * 101);
            stuArr[i] = new Student(id, name, grade, score);
        }
        // 遍历
        for(Student tmp : stuArr){
            System.out.println(tmp.say());
        }
        System.out.println("********************************");
        // 冒泡
        // 练习：按分数排序
        for (int i = 0; i < stuArr.length - 1; i++){
            for(int j = 0; j < stuArr.length - 1 - i; j++){
                // 比较相邻元素j和j+1
                if(stuArr[j].getScore() > stuArr[j + 1].getScore()){
                    Student tmp = stuArr[j];
                    stuArr[j] = stuArr[j + 1];
                    stuArr[j + 1] = tmp;
                }
            }
        }
        // 遍历
        for (Student tmp: stuArr){
            System.out.println(tmp.say());
        }
        System.out.println("****************************");
    }


    public static void main8(String[] args) {
        Student st = new Student(1, "小刚", 4, 80);
        System.out.println(st.say());
    }


    // 取子数组：把3年级同学取出来
    public static void main7(String[] args) {
        Student[] stuArr = new Student[20];
        String[] names1 = {"李", "王", "赵", "张", "刘", "杨", "曹"};
        String[] names2 = {"刚", "伟", "丽", "娜", "琳", "宁", "旭", "阳", "帅"};
        for(int i = 0; i < stuArr.length; i++){
            int id = i + 1;
            int index1 = (int)(Math.random() * 200) % names1.length;
            int index2 = (int)(Math.random() * 200) % names2.length;
            String name = names1[index1] + names2[index2];
            int grade = (int)(Math.random() * 6 + 1);
            double score = (int)(Math.random() * 101);
            stuArr[i] = new Student(id, name, grade, score);
        }
        // 遍历
        for(Student tmp : stuArr){
            System.out.println(tmp.say());
        }
        System.out.println("********************************");
        // 取子数组
        // 练习：把3年级同学取出来
        // 1 创建新数组，长度和原数组相同，防止全是有效元素
        Student[] newArr = new Student[stuArr.length];
        // 2 声明计数器，初始值为 0，功能有2个：本职奇数，新数组下标控制
        int count = 0;
        // 3 遍历老数组，把符合条件的数据保存到新数组中，保证新数组的结构良好
        for (int i = 0; i < stuArr.length; i++){
            // 4 如果找到符合条件的数据
            if(stuArr[i].getGrade() == 3){
                // 5 把数据保存到新数组，下标由计数器控制
                newArr[count] = stuArr[i];
                // 6 调整计数器
                count++;
            }
        }
        // 7 创建最终数组，长度是计数器当前值
        Student[] finalArr = new Student[count];
        // 8 依次把新数组中的所有有效数据保存到最终数组中，循环次数由计数器控制
        for (int i = 0; i < count; i++){
            finalArr[i] = newArr[i];
        }
        // 遍历最终数组
        for (Student tmp : finalArr){
            if(tmp != null){
                System.out.println(tmp.say());
            }
        }
    }


    // 把学生对象数组扩容
    public static void main6(String[] args) {
        Student[] stuArr = new Student[10];
        String[] names1 = {"李", "王", "赵", "张", "刘", "杨", "曹"};
        String[] names2 = {"刚", "伟", "丽", "娜", "琳", "宁", "旭", "阳", "帅"};
        for(int i = 0; i < stuArr.length; i++){
            int id = i + 1;
            int index1 = (int)(Math.random() * 200) % names1.length;
            int index2 = (int)(Math.random() * 200) % names2.length;
            String name = names1[index1] + names2[index2];
            int grade = (int)(Math.random() * 6 + 1);
            double score = (int)(Math.random() * 101);
            stuArr[i] = new Student(id, name, grade, score);
        }

        // 遍历
        for(Student tmp : stuArr){
            System.out.println(tmp.say());
        }
        System.out.println("********************************");
        // 扩容
        // 1 创建新数组，长度比原数组大
        Student[] newStuArr = new Student[stuArr.length * 3 / 2];
        // 2 依次把老数组中的数据复制到新数组中，以短的数组为准
        for(int i = 0; i < stuArr.length; i++){
            newStuArr[i] = stuArr[i];
        }
        // 3 老引用指向新引用
        stuArr = newStuArr;
        // 遍历扩容后的
        for (Student tmp : stuArr){
            if(tmp != null){
                System.out.println(tmp.say());
            }else{
                // 防止空指针（空洞）
                System.out.println(tmp);
            }
        }
        // 打印扩容后的数组大小
        System.out.println("扩容后的数组长度：" + stuArr.length);
    }

    // 把学生对象数组缩减一半
    public static void main5(String[] args) {
        Student[] stuArr = new Student[20];
        String[] names1 = {"李", "王", "赵", "张", "刘", "杨", "曹"};
        String[] names2 = {"刚", "伟", "丽", "娜", "琳", "宁", "旭", "阳", "帅"};
        for(int i = 0; i < stuArr.length; i++){
            int id = i + 1;
            int index1 = (int)(Math.random() * 200) % names1.length;
            int index2 = (int)(Math.random() * 200) % names2.length;
            String name = names1[index1] + names2[index2];
            int grade = (int)(Math.random() * 6 + 1);
            double score = (int)(Math.random() * 101);
            stuArr[i] = new Student(id, name, grade, score);
        }

        // 遍历
        for(Student tmp : stuArr){
            System.out.println(tmp.say());
        }
        System.out.println("********************************");
        // 把学生对象数组缩减一半
        // 创建新数组，容量比原数组小
        Student[] newStuArr = new Student[stuArr.length / 2];
        // 依次把老数组中的数据复制到新数组中
        for (int i = 0; i < newStuArr.length; i++){
            newStuArr[i] = stuArr[i];
        }
        // 老引用指向新数组
        stuArr = newStuArr;
        // 遍历缩减后的数组
        for (Student tmp : stuArr){
            System.out.println(tmp.say());
        }
        System.out.println("**********************************");
    }

    public static void main4(String[] args) {
        Student[] stuArr = new Student[10];
        String[] names1 = {"李", "王", "赵", "张", "刘", "杨", "曹"};
        String[] names2 = {"刚", "伟", "丽", "娜", "琳", "宁", "旭", "阳", "帅"};
        for (int i = 0; i < stuArr.length; i++) {
            int id = i + 1;
            int index1 = (int) (Math.random() * 2000) % names1.length;
            int index2 = (int) (Math.random() * 2000) % names2.length;
            String name = names1[index1] + names2[index2];
            int grade = (int) (Math.random() * 6 + 1); // 随机的1~6
            double score = (int) (Math.random() * 101);
            stuArr[i] = new Student(id, name, grade, score);
        }
        // 遍历
        for (Student tmp : stuArr) {
            System.out.println(tmp.say());
        }
        System.out.println("****************************************");
        // 循环长度/2次, 每次都是交换i位置和length - 1 - i位置
        for (int i = 0; i < stuArr.length / 2; i++) {
            Student tmp = stuArr[i];
            stuArr[i] = stuArr[stuArr.length - 1 - i];
            stuArr[stuArr.length - 1 - i] = tmp;
        }
        // 遍历
        for (Student tmp : stuArr) {
            System.out.println(tmp.say());
        }
        System.out.println("****************************************");
    }


    // 通过下标找最牛和最菜的同学
    public static void main3(String[] args) {
        Student[] stuArr = new Student[20];
        String[] names1 = {"李", "王", "赵", "张", "刘", "杨", "曹"};
        String[] names2 = {"刚", "伟", "丽", "娜", "琳", "宁", "旭", "阳", "帅"};
        for(int i = 0; i < stuArr.length; i++){
            int id = i + 1;
            int index1 = (int)(Math.random() * 200) % names1.length;
            int index2 = (int)(Math.random() * 200) % names2.length;
            String name = names1[index1] + names2[index2];
            int grade = (int)(Math.random() * 6 + 1);
            double score = (int)(Math.random() * 101);
            stuArr[i] = new Student(id, name, grade, score);
        }

        // 遍历
        for(Student tmp : stuArr){
            System.out.println(tmp.say());
        }
        System.out.println("********************************");
        // 通过下标找最牛和最菜的同学
        int maxIndex3 = -1;   // 设置非法下标为一个标志值
        int minIndex3 = -1;
        for(int i = 0; i < stuArr.length; i++){
            if (stuArr[i].getGrade() == 3){
                if (maxIndex3 == -1){
                    maxIndex3 = i;
                    minIndex3 = i;
                }else{
                    if(stuArr[i].getScore() > stuArr[maxIndex3].getScore()){
                        maxIndex3 = i;
                    }
                    if(stuArr[i].getScore() < stuArr[minIndex3].getScore()){
                        minIndex3 = i;
                    }
                }
            }
        }
        if(maxIndex3 == -1){
            System.out.println("没有3年级同学");
        }else{
            System.out.println("3年级最牛：" + stuArr[maxIndex3].say());
            System.out.println("3年级最牛：" + stuArr[minIndex3].say());
        }
    }


    // 找出3年级最牛
    public static void main2(String[] args) {
        Student[] stuArr = new Student[20];
        String[] names1 = {"李", "王", "赵", "张", "刘", "杨", "曹"};
        String[] names2 = {"刚", "伟", "丽", "娜", "琳", "宁", "旭", "阳", "帅"};
        for(int i = 0; i < stuArr.length; i++){
            int id = i + 1;
            int index1 = (int)(Math.random() * 200) % names1.length;
            int index2 = (int)(Math.random() * 200) % names2.length;
            String name = names1[index1] + names2[index2];
            int grade = (int)(Math.random() * 6 + 1);
            double score = (int)(Math.random() * 101);
            stuArr[i] = new Student(id, name, grade, score);
        }

        // 遍历
        for(Student tmp : stuArr){
            System.out.println(tmp.say());
        }
        System.out.println("********************************");
        // 找出3年级最牛
        Student maxStudent3 = null; // 3年级最牛还不存在
        for (Student tmp : stuArr){
            if (tmp.getGrade() == 3){
                if (maxStudent3 == null){
                    maxStudent3 = tmp;
                }else{
                    if(tmp.getScore() < maxStudent3.getScore()){
                        maxStudent3 = tmp;
                    }
                }
            }
        }
        if(maxStudent3 != null){
            System.out.println("3年级最牛：" + maxStudent3.say());
        }else{
            System.out.println("没有3年级同学");
        }

        // 找3年级最牛，用下标的方式
        int maxIndex3 = -1;     // 3年级最牛还不存在
        for (int i = 0; i < stuArr.length; i++){
            if (stuArr[i].getGrade() == 3){
                if (maxIndex3 == -1){
                    maxIndex3 = i;
                }else{
                    if(stuArr[i].getScore() > stuArr[maxIndex3].getScore()){
                        maxIndex3 = i;
                    }
                }
            }
        }
        if(maxIndex3 != -1){
            System.out.println("3年级最牛：" + stuArr[maxIndex3]);
        }else{
            System.out.println("没有3年级同学");
        }

        // 用下标的方式找3年级最菜
        int minIndex3 = 0;      // 可以有效防止越界
        int count = 0;
        for(int i = 0; i < stuArr.length; i++){
            if(stuArr[i].getGrade() == 3){
                count++;
                if(stuArr[minIndex3].getGrade() != 3){
                    minIndex3 = i;
                }else{
                    if(stuArr[i].getScore() < stuArr[minIndex3].getScore()){
                        minIndex3 = i;
                    }
                }
            }
        }
        if(stuArr[minIndex3].getGrade() != 3){
            System.out.println("没有3年级");
        }else{
            System.out.println("3年级最菜：" + stuArr[minIndex3].say());
        }
    }


    // 找出最高分
    public static void main1(String[] args) {
        Student[] stuArr = new Student[20];
        String[] names1 = {"李", "王", "赵", "张", "刘", "杨", "曹"};
        String[] names2 = {"刚", "伟", "丽", "娜", "琳", "宁", "旭", "阳", "帅"};
        for(int i = 0; i < stuArr.length; i++){
            int id = i + 1;
            int index1 = (int)(Math.random() * 200) % names1.length;
            int index2 = (int)(Math.random() * 200) % names2.length;
            String name = names1[index1] + names2[index2];
            int grade = (int)(Math.random() * 6 + 1);
            double score = (int)(Math.random() * 101);
            stuArr[i] = new Student(id, name, grade, score);
        }

        // 遍历
        for(Student tmp : stuArr){
            System.out.println(tmp.say());
        }
        System.out.println("********************************");
        // 找出最高分
        double maxScore = stuArr[0].getScore();
        for (Student tmp : stuArr){
            if (tmp.getScore() > maxScore){
                maxScore = tmp.getScore();
            }
        }
        System.out.println("maxScore = " + maxScore);

        // 找出全校最牛
        Student maxStudent = stuArr[0];
        for (Student tmp : stuArr){
            if(tmp.getScore() < maxStudent.getScore()){
                maxStudent = tmp;
            }
        }
        System.out.println("maxStudent: " + maxStudent.say());

        // 使用下标的方式找最大
        int maxIndex = 0;
        for (int i = 0; i < stuArr.length; i++){
            if(stuArr[i].getScore() > stuArr[maxIndex].getScore()){
                maxIndex = i;
            }
        }
        System.out.println("stuArr[maxIndex]: "+ stuArr[maxIndex].say());
    }
}
