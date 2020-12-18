package com.atguigu.javase.inheritance;

// 子类继承父类的写法是用关键字 extends 是扩展, 在父类的基础上进行扩展.
public class Student extends Person {
    /*
    String name;
    int age;
    String gender;

    public String say() {
        return "姓名 : " + name + ", 年龄 : " + age + ", 性别 : " + gender;
    }*/
    //String gender; // 同名属性是和父类共存的
    String school; // 子类特有成员.

    public Student() { // 缺省构造器, 无参, 无普通语句
        //super(); // 这个语句是编译器硬加的. 作用就是隐式调用父类的无参构造器
        //super("小明", 20, "男"); // 可以使用super(...) 显式调用父类的有参构造器
        this("小明", 20, "男", "尚硅谷"); // 显式调用其他构造, 间接调用父类构造
        System.out.println("Student()...."); // 3
    }

    // 子类全参(包括父类所有属性和子类属性)
    public Student(String name, int age, String gender, String school) {
        super(name, age, gender); // 显式调用父类有参构造器
        //setName(name);
        //setAge(age);
        //setGender(gender);
        this.school = school;
        System.out.println("Student(全)..."); // 4
    }

    public void study() {
        //System.out.println(name + "学生在学习"); // 继承的属性可以直接使用
        System.out.println(super.getName() + "学生在学习" + school); // 继承的私有属性必须间接使用
        System.out.println(this.getName() + "学生在学习"); // 继承的私有属性必须间接使用
    }

    // 方法重写, 因为父类方法不能满足需要, 所以改进之!!
    @Override public String say() {
        //return "姓名 : " + getName() + ", 年龄 : " + getAge() + ", 性别 : " + getGender() + ", 学校 : " + school;
        // super调用的好处是它会随着父类的变化而变化 , 而不需要修改子类
        return super.say() + ", 学校 : " + school; // super.say() 在子类中把父类被覆盖的方法再显式的调用一下.
    }

}
