package com.atguigu.javase.finaltest;

public class EmployeeTest {

    public static void main(String[] args) {
        Employee employee1 = new Employee("张三", 30, 3000);
        Employee employee2 = new Employee("李四", 40, 4000);
        Employee employee3 = new Employee("王五", 50, 5000);

        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);

        Employee employee = new Employee();
        System.out.println(employee);
    }
}
