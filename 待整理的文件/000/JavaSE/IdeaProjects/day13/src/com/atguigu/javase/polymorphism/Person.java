package com.atguigu.javase.polymorphism;

/**
 * 本类：子类对象的子类形态
 * 多态：
 *      看右面 -> 子类对象的多种父类形态（运行时类型）
 *      看左面 -> 父类类型的引用变量指向多种子类对象（编译时类型）
 *      若编译时类型和运行时类型不一致，就出现多态。
 *
 * 本态引用：子类对象赋值给子类类型的引用变量
 * 多态引用：
 *      1）子类对象赋值给父类类型的引用变量
 *      2）父类类型引用变量指向不同子类对象
 *
 * 多态的概括：把子类对象“当作是”父类对象来使用
 */
public class Person {

    private String name;
    private int age;
    private String gender;

    public Person() {}

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

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

    public String say(){
        return "姓名：" + name +", 年龄："+ age + ", 性别：" + gender;
    }

    // 此方法实际不执行，但是不能去掉，因为多态时编译要用
    // 这是个虚拟方法，唯一的作用是骗过编译器
    public void sayHello() {
        System.out.println("打了个招呼。。。");
    }
}
