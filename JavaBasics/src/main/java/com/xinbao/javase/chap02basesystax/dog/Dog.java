package com.xinbao.javase.chap02basesystax.dog;

/**
 * 练习：写一个类 Dog
 * 属性：名字，年龄，体重
 * 方法：void shout(), void eat(String some), String say(); // 返回对象详细信息
 * 再写一个DogTest测试类，在主方法中创建一个Dog对象，给这个Dog对象的所有属性赋值，打印输出所有属性值，再调用它的所有方法。
 */
public class Dog {
    // 属性
    String name;
    int age;
    int weight;

    public void shout(){
        System.out.println("汪汪~~");
    }

    public void eat(String some) {
        System.out.println("狗狗在吃 " + some);
    }

    public String say() {
        String str = "够名：" + name + ", 年龄：" + age + ", 体重：" + weight;
        return str;
    }
}
