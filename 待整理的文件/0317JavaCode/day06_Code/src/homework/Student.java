package homework;

/*
写一个学生类Student, 属性,name, grade, score, 属性可以有显式赋值,
方法 void study(), void eat(String some), String say()
创建3个学生对象, 分别给他们赋值, 打印输出对象的say
*/
public class Student {

    String name;
    String grade;
    int score;

    public void study() {
        System.out.println(name + "正在学习");
    }

    public void eat(String some) {
        System.out.println("正在吃：" + some);
    }

    public String say() {
        String str = "姓名：" + name + ", 年级：" + grade + ", 分数：" + score;
        return str;
    }


    public static void main(String[] args) {

        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        s1.name = "小明";
        s1.grade = "三年级";
        s1.score = 99;

        s2.name = "小红";
        s2.grade = "初三";
        s2.score = 90;

        s3.name = "小黑";
        s3.grade = "高三";
        s3.score = 98;

        System.out.println(s1.say());
        System.out.println(s2.say());
        System.out.println(s3.say());
    }
}
