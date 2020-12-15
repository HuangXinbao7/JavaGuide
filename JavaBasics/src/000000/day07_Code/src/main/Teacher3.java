package main;

/**
 * 构造器重载：构造器的连环调用
 */
public class Teacher3 {

    private String name = "某老师";    // 字符串类型的属性如果没有显式赋值，默认值是 null
    private int age;                  // int型的缺省值是 0
    private String gender = "保密";


    // 在无参构造器中调用有参构造器
    // this(...) 特殊调用必须是构造器中的第一行
    public Teacher3(){
        this("小明", 18, "男");
    }

    public Teacher3(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String say() {
        return "姓名：" + name + ", 年龄：" + age + ", 性别：" + gender;
    }
}
