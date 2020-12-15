package com.atguigu.javase.annotationtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解：一种特殊的注释，是一个修饰符，本质上不参与程序的执行，特殊在可以被编译器和VM识别。
 * 如果想让它参与执行必须通过反射方式
 * 注解就是接口，是一种特殊接口
 * 标记型注解：不需要传参的
 * @Override 作用：提醒编译器，帮助做方法覆盖条件的检查。只能修饰方法，不能修饰类，属性，构造器
 * @Depracated 作用：提醒使用者，它所修饰的目标已过时，不建议使用。可以修饰类，属性，构造器，方法，形参，局部变量
 * @SuppressWarnings 作用：提醒编译器，修饰的目标中的编译器警告忽略掉。必须传参。
 *      可以修饰类，属性，方法，构造器，局部变量
 *
 * 元注解：注解的注解，作用是约束注解
 */

// 自定义注解：写法想接口。是一个标记型注解
@interface MyAnnotation {}


// 需要参数的自定义注解，可以修饰类，属性，构造器，方法，形参，局部变量
@interface MyAnnotation2 {
    // 属性的写法想方法，属性也可以有缺省值
    // 声明的时候称为属性，在使用时称为参数
    int id();
    // 属性可以有缺省值，使用 default 关键字
    String name() default "我是缺省值";  // 带缺省值的注解属性
}


// 元注解：注解的注解
// @Target 限定自定义注解可以用在什么地方
// 需要传一个数组，是一个类型数组，ElementType[]
// ElementType 是一个枚举，里面有 TYPE，FIELD, METHOD, ...
    // @Retention 元注解：限定自定义注解可以停留在什么时期，
    // 有3个级别：RetentionPolicy.SOURCE(源码), RetentionPolicy.CLASS(类文件中保留), RetentionPolicy.RUNTIME(运行时，可以反射)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)     // MyAnnotation3 可以被反射处理。默认是 CLASS
@interface MyAnnotation3 {  // 此注解被约束后，就只能用在 类，属性，方法上
    int id() default 100;
    String name() default "我是缺省值";
}


//@Deprecated
@MyTiger("Student类")
class Student {
    private int id;
    private String name;
    private int grade;
    private double score;

    public Student() {
    }

    public Student(int id, String name, int grade, double score) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.score = score;
    }

    @Deprecated
    @SuppressWarnings({"unused", "not-null"})    // 抑制警告
    public int getId() {
        @Deprecated int n;
        String str = null;
        System.out.println(str.length());   // 空指针异常
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
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
                ", grade=" + grade +
                ", score=" + score +
                '}';
    }
}


public class AnnotationTest {

    public static void main(String[] args) {
        Student student = new Student();
    }
}
