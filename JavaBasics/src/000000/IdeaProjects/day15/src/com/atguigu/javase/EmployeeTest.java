package com.atguigu.javase;

import com.atguigu.javase.Employee;

public class EmployeeTest {

    public static void main(String[] args) {
        Employee emp1 = new Employee("张三", 30, 100000);
        Employee emp2 = new Employee("李四", 40, 80000000);
        Employee emp3 = new Employee("王五", 50, 250000);

        System.out.println(emp1.toString());
        System.out.println(emp2.toString());
        System.out.println(emp3.toString());
    }
}
