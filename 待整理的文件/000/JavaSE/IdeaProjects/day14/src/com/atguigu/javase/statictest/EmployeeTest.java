package com.atguigu.javase.statictest;

public class EmployeeTest {

    public static void main(String[] args) {
        Employee emp1 = new Employee("张三", 20, 5000);
        Employee emp2 = new Employee("李四", 40, 9000);
        Employee emp3 = new Employee("王五", 50, 12000);

        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);

        Employee employee = new Employee();
        System.out.println(employee);
    }


    public static void main1(String[] args) {
        System.out.println(Employee.company);
        Employee.setCompany("尚硅谷");
        System.out.println(Employee.company);

        Employee emp1 = new Employee("张三", 20, 5000);
        Employee emp2 = new Employee("李四", 40, 9000);
        Employee emp3 = new Employee("王五", 50, 12000);

        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);

        System.out.println("*********************");

        // 方法调用者不是对象
        Employee.test();
        // 下面的写法不推荐!!!, 静态方法一定要通过类调用, 不要通过对象调用.
        //emp1.test(); // 对象也能调用静态方法, 虽然是对象在调用, 其实不是, 根据对象找到类, 通过类调用.
    }
}
