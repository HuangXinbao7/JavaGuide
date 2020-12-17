package com.xinbao.javase.chap04oop.basic.exer;

/**
 * 练习1
 * 要求：
 * (1)创建Person类的对象，设置该对象的name、age和sex属性，
 * 调用study方法，输出字符串“studying”，
 * 调用showAge()方法显示age值，
 * 调用addAge()方法给对象的age属性值增加2岁。
 * (2)创建第二个对象，执行上述操作，体会同一个类的不同对象之间的关系。
 */
public class PersonTest {

    public static void main(String[] args) {

        Person person = new Person();

        person.name = "Tom";
        person.age = 18;
        person.sex = 1;

        person.study();
        person.showAge();

        int newAge = person.addAge(2);
        System.out.println(person.name + "的新年龄为：" + newAge);
        System.out.println(person.age); // 20


        // *************************
        Person p2 = new Person();
        p2.showAge();   // 0
        p2.addAge(10);
        p2.showAge();   // 10

        person.showAge();
    }
}
