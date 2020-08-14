package homework;

/*
写一个类Student, 包含属性id, name, grade, score
创建一个Student[] 包含20个元素
用循环创建20个学生对象, 要求id从1~20, 姓名随机产生, 年级随机的[1~6], 分数随机的[0~100]分.遍历对象数组, 打印输出
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

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setGrade(int grade){
        this.grade = grade;
    }

    public int getGrade(){
        return grade;
    }

    public void setScore(double score){
        this.score = score;
    }

    public double getScore(){
        return score;
    }

    public String say(){
        return "学号: " + id + ", 姓名：" + name + ", 年级： " + grade + ", 分数：" + score;
    }
}
