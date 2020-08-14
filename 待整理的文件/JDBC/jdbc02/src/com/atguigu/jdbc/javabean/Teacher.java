package com.atguigu.jdbc.javabean;

/**
 *
 */
public class Teacher {

    /*
    +--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| id     | int(11)     | NO   | PRI | NULL    | auto_increment |
| name   | varchar(20) | YES  |     | NULL    |                |
| age    | int(11)     | YES  |     | NULL    |                |
| salary | double      | YES  |     | NULL    |                |
| phone  | varchar(20) | YES  |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+

    * *
    * */

    private int id;
    private String name;
    private int age;
    private double salary;
    private String phone;

    public Teacher() {
    }

    public Teacher(int id, String name, int age, double salary, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", phone='" + phone + '\'' +
                '}';
    }
}
