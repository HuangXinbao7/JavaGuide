package main;

/**
 * 写一个类 Student
 * 属性：name、age、score，所有属性用 private 修饰
 * 方法：void study()、String say()
 */
public class Student {

    private String name;
    private int age;
    private int score;

    // 构造器重载
    public Student() {
        /*
		this.name = name;
		this.age = age;
		this.score = 80;
		*/
        this("小明", 20, 20);
        System.out.println("Student()...");
    }

    public Student(String name, int age){
        /*
		this.name = name;
		this.age = age;
		this.score = 80;
		*/
        this(name, age, 80);
    }

    public Student(String name, int age, int score){
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        // 优化方法，加个判断。防止数据非法
        if(age > 0 && age < 100){
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public void setScore(int score) {
        if(score < 0 || score > 100) {
            return;
        }
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void study() {
        System.out.println(getName() + " 正在学习");
    }

    public String say() {
        return "姓名：" + name + ", 年龄：" + age + ", 分数：" + score;
    }
}
