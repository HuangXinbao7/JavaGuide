package com.atguigu.javase.homework;

/**
 * 作业4：写自定义泛型类， 测试。
 */
// 自定义泛型类 Person
class Person<X> {

    private String name;
    private int age;
    private X info;

    public Person() {
    }

    public Person(String name, int age, X info) {
        this.name = name;
        this.age = age;
        this.info = info;
    }

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

    public X getInfo() {
        return info;
    }

    public void setInfo(X info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", info=" + info +
                '}';
    }
}


public class GenericTask {

    public static void main(String[] args) {

        // 泛型约束了info属性只能是String类型。
        //Person<String> p1 = new Person<String>("小明", 12, 80);
        // 只有info属性值为String类型时才能创建对象成功
        Person<String> p2 = new Person<String>("小明", 12, "小学生");
        // 只要info属性值为Integer类型时才能创建对象成功
        Person<Integer> p22 = new Person<Integer>("小明明", 12, 90);

        // 如果不使用泛型参数，也是可以创建对象，此时info属性不受约束
        Person p3 = new Person("小芳", 12, 80);
        Person p4 = new Person("小芳", 12, "三年级");
    }
}
