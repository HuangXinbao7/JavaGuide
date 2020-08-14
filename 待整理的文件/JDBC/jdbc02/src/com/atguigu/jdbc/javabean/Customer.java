package com.atguigu.jdbc.javabean;

/**
 * Customer 类需要参考 Customer 表创建
 */
public class Customer {

    /*
    mysql> select * from customer;
            +----+------+------+--------+-----------+
                    | id | name | age  | gender | phone     |
            +----+------+------+--------+-----------+
            |  1 | 张三 |   30 | 男     | 123456789 |
            |  2 | 杨哥 |   35 | 男     | 12121212  |
            |  3 | 杨哥 |   35 | 男     | 12121212  |
            +----+------+------+--------+-----------+
            */

    private int id;
    private String name;
    private int age;
    private String gender;
    private String phone;

    public Customer() {
    }

    public Customer(int id, String name, int age, String gender, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
