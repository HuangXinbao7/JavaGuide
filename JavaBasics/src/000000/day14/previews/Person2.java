package com.atguigu.javase.previews;

// 类方法应用举例
public class Person2 {
    public static int total = 0;    // 类变量：static修饰的静态成员
    // 在static方法内部只能访问类的static属性，不能访问类的非static属性
    public static int getTotalPerson() {
        //id++; // 非法
        return total;
    }
    public static void setTotalPerson(int total){
        //this.total = total; // 非法，在static方法中不能有this，也不能有 super
        total = total;
    }
    private int id;     // 类的私有成员变量
    // 无参构造
    public Person2() {
        total++;
        id = total;
    }


    public static void main(String[] args) {
        System.out.println(Person2.getTotalPerson());   // 0
        Person2 p2 = new Person2();
        System.out.println(p2.getTotalPerson());    // 1

        Person2.setTotalPerson(3);
    }
}
