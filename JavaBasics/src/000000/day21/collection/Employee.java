package com.atguigu.javase.collection;

/**
 * 练习1：写一个类 Employee，有姓名、年龄、工资 属性
 */
public class Employee implements Comparable {

    private String name;
    private int age;
    private double salary;

    public Employee() {
    }

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        // 造型有风险，需要先判断
        if(!(o instanceof Employee)) {
            throw new RuntimeException("对象不可比较");
        }
        return this.age - ((Employee) o).getAge();
    }
}
