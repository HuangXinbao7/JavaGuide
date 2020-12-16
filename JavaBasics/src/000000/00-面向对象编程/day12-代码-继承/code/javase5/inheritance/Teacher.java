package com.atguigu.javase.inheritance;

public class Teacher extends Person {

    double salary;

    public void lesson() {
        System.out.println("老师在上课");
    }

    @Override // 注解 : 一种特殊的注释, 特殊在可以被编译器和VM识别.
    // 这个注解的作用是 告诉编译器, 请帮我做方法覆盖条件的检查, 如果检查过不去,报错
    // 防止出现低级错误
    public String say() {
        return super.say() + ", 工资 : " + salary;
    }
}
