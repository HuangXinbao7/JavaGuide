package com.atguigu.javase;

class Base {
    static String num = "abc";
}

public class Employee extends Base{

    static {
        num = 100;  // 赋值时可以根据右侧的实际值推断，所以不用加限定
        //System.out.println(num);    // 此时无法确定是哪个 num
        System.out.println(Employee.num);   // 要想访问，必须加限定
    }

    private static int num = 1;

    {
        // 在创建对象时执行仅有的一次, 先于构造器执行，它的执行和构造器无关
        System.out.println("non static {}");
    }

    static {
        System.out.println("static...");
        num = 10000;
        System.out.println(num);    // 这里没问题，就近原则
    }

    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee() {
    }

    public Employee(String name, int age, double salary) {
        this.id = num++;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
