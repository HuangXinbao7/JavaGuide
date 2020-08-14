package com.atguigu.jdbc.javabean;

/**
 *
 */
public class Student {

    /*mysql> desc student;
+---------+-------------+------+-----+---------+----------------+
| Field   | Type        | Null | Key | Default | Extra          |
+---------+-------------+------+-----+---------+----------------+
| id      | int(11)     | NO   | PRI | NULL    | auto_increment |
| name    | varchar(20) | YES  |     | NULL    |                |
| age     | int(11)     | YES  |     | NULL    |                |
| mobile  | varchar(20) | YES  |     | NULL    |                |
| address | varchar(50) | YES  |     | NULL    |                |
| score   | double      | YES  |     | NULL    |                |
+---------+-------------+------+-----+---------+----------------+
6 rows in set (0.00 sec)*/
    private int id;
    private String name;
    private int age;
    private String mobile;
    private String address;
    private double score;

    public Student() {
    }

    public Student(int id, String name, int age, String mobile, String address, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.address = address;
        this.score = score;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", score=" + score +
                '}';
    }
}
