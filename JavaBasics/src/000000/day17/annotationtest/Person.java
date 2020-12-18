package com.atguigu.javase.annotationtest;

@HelloAnnotation(value = "Person")      // 自定义注解修饰类
class Person {

    @HelloAnnotation(num = 20, value = "name")      // 自定义注解修饰 属性
    private String name;
    private int age;
    private String gender;

    // 自定义注解修饰 构造器
    // 如果属性名叫 value()，可以省略 value =
    @HelloAnnotation("Person 构造器")
    public Person() {
    }

    @HelloAnnotation(value = "Person 全参构造器")    // 自定义注解修饰 构造器
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // 自定义注解修饰 方法
    @HelloAnnotation("getName")
    public String getName() {
        return name;
    }

    // 自定义注解可以修饰局部变量
    public void setName(@HelloAnnotation("name") String name) {
        this.name = name;   // 这是个语句，不能用注解修饰
    }

    public int getAge() {
        @HelloAnnotation("n") int n;    // 自定义注解修饰局部变量
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

    @HelloAnnotation("toString 方法")     // 自定义注解修饰 方法
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
