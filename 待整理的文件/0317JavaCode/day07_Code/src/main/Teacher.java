package main;

/**
 * 成员变量和成员方法
 */
public class Teacher {

    // 成员变量（member）
    String name = "某老师";
    int age;
    String gender = "保密";


    // 成员方法（member）
    public void lesson() {
        System.out.println("老师在上课");
    }

    public void eat(String some) {
        System.out.println("老师在吃 " + some);
    }

    public String say() {
        return "姓名：" + name + ", 年龄：" + age + ", 性别：" + gender;
    }
}
