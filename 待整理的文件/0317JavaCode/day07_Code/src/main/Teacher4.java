package main;

/**
 * 一个类的完整写法：
 * 1 写属性，考虑封装
 * 2 写构造器，一般情况下写2个构造器
 * 3 提供 get/set方法
 * 4 提供 say 方法
 * 5 最后考虑其他普通方法
 */
public class Teacher4 {

    // 1 写属性，考虑封装
    private String name = "某老师";    // 字符串类型的属性如果没有显式赋值，默认值是 null
    private int age;                  // int型的缺省值是 0
    private String gender = "保密";


    // 2 写构造器，一般情况下写2个构造器：无参构造器和全参构造器
    // 如果只能留一个构造器，那么就留无参构造器
    public Teacher4(){
        // 构造器之间的间接调用
        this("小明", 17, "男");
    }

    public Teacher4(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    // 3 提供 get/set方法
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }


    // 4 提供 say 方法
    public String say() {
        return "姓名：" + name + ", 年龄：" + age + ", 性别：" + gender;
    }

    // 5 最后考虑其他普通方法
    public void lesson(){
        System.out.println(name + "老师在上课");
    }
}
