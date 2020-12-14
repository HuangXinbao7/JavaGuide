package com.atguigu.javase.java8;

import com.atguigu.javase.javabean.Student;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数接口
 */
public class FunctionalInterfaceTest {


    /**
     * 使用匿名内部类和lambda分别完成一个判断器，判断一个学生对象年龄是否是12
     */
    @Test
    public void exer4() {
        Student student = new Student(1, "小明", 12, 88);
        Predicate<Student> predicate1 = new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getGrade() == 3;
            }
        };
        boolean b1 = predicate1.test(student);
        System.out.println(b1);

        Predicate<Student> predicate2 = t -> t.getGrade() == 12;
        boolean b2 = predicate2.test(student);
        System.out.println(b2);

    }


    @Test
    public void test4() {
        Predicate<String> predicate1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.endsWith(".java");
            }
        };
        boolean b1 = predicate1.test("abc");
        System.out.println(b1);

        Predicate<String> predicate2 = t -> t.endsWith(".java");
        boolean b2 = predicate2.test("aaa.java");
        System.out.println(b2);
    }


    /**
     * 使用匿名内部类哈 lambda 分别完成一个转换器，把一个学生对象转换成 Integer 对象
     */
    @Test
    public void exer3() {
        Function<Student, Integer> function1 = new Function<Student, Integer>() {
            @Override
            public Integer apply(Student student) {
                return student.getGrade();
            }
        };
        Function<Student, Integer> function2 = t -> t.getGrade();
    }


    /**
     * 转换器
     */
    @Test
    public void test3() {
        Function<String, Integer> function1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        };
        Integer apply1 = function1.apply("123");
        System.out.println(apply1);

        Function<String, Integer> function2 = s -> Integer.valueOf(s);
        Integer apply = function2.apply("121212");
        System.out.println(apply);
    }



    /**
     * 使用匿名内部类和lambda分别完成一个供给器，供给一个学生对象
     */
    @Test
    public void exer2() {
        Supplier<Student> supplier1 = new Supplier<Student>() {
            @Override
            public Student get() {
                return new Student(1,"小明", 22, 99);
            }
        };
        System.out.println(supplier1.get());

        Supplier<Student> supplier2 = () -> new Student();
        System.out.println(supplier2.get());
    }


    @Test
    public void test2() {
        Supplier<Integer> supplier1 = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int)(Math.random() * 100);
            }
        };
        System.out.println(supplier1.get());

        Supplier<Integer> supplier2 = () -> (int)(Math.random() * 100);
        System.out.println(supplier2.get());
    }


    /**
     * 消费型
     */
    @Test
    public void test1() {
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer1.accept("AAABBB");

        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("AAA");

    }

    @Test
    public void test01() {

    }


}

