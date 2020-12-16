package com.atguigu.javase.inheritance;

/**
 * 继承 : 从现有类创建子类, 现有类称为父类(体现顺序), 基类(子类以父类为基础), 超类.
 * 子类一旦继承父类, 就会继承父类的所有成员(构造器除外). 进而可以简化子类的写法, 并且让类和类之间关系更紧密.
 * Java中只支持单继承 : 一个子类只能有一个直接父类
 * java中是支持多层继承 : 一个子类可以有多个间接父类.
 *
 * 子类可以继承父类的私有成员. 但是只是有所有权, 没有直接使用权.
 * 在父类中提供公共的get/set方法就可以让子类间接访问了
 */
public class Person {

    private String name; // 成员一旦私有修饰, 只能在本类中访问.
    private int age;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String say() {
        return "姓名 : " + name + ", 年龄 : " + age + ", 性别 : " + gender;
    }
}
