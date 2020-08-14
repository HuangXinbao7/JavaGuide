package com.atguigu.javase.java8;

import com.atguigu.javase.javabean.Student;
import com.atguigu.javase.javabean.StudentData;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 *
 */
public class StreamTest {

    /**
     * parallelStream(): 并行流
     */
    @Test
    public void test15() {
        Optional<Double> reduce = StudentData.getList().parallelStream().distinct().map(t -> t.getScore()).reduce((t1, t2) -> t1 + t2);
        Double aDouble = reduce.orElse(9999.9999);
        System.out.println(aDouble);
    }






    /**
     * reduce(二元运算)缩小，规约，二元运算 T test(T t1, T t2)
     *  第一个和第二个
     * 求全校同学的总分
     */
    @Test
    public void test14() {
        Optional<Double> reduce = StudentData.getList().stream().distinct().map(t -> t.getScore()).reduce((t1, t2) -> t1 + t2);
        Double aDouble = reduce.orElse(9999.9999);
        System.out.println(aDouble);
    }



    /**
     * count
     */
    @Test
    public void test13() {
        long count = StudentData.getList().stream().distinct().filter(t -> t.getScore() < 60).count();
        System.out.println(count);

    }



    /**
     * Optional<T> 是一个小容器，
     */
    @Test
    public void test12() {
        Optional<Student> first = StudentData.getList().stream().distinct().filter(t -> t.getScore() == 100).findFirst();
        Student student = first.orElse(new Student());
        System.out.println(student);

    }


    /**
     *
     */
    @Test
    public void test99() {
        StudentData
            .getList()
            .stream()
            .distinct()
            .filter(t -> t.getGrade() == 3)
            .filter(t -> t.getScore() < 60)
            .sorted((t1, t2) -> -(int)(t1.getScore() - t2.getScore()))
            .limit(2)
            .forEach(System.out::println);
    }


    /**
     * map: 打印输出所有学生的姓名
     */
    @Test
    public void test11() {
        //StudentData.getList().stream().distinct().map(t -> t.getName()).forEach(System.out::println);
        //StudentData.getList().stream().distinct().sorted((t1,t2) -> (int)(t1.getScore() - t2.getScore())).forEach(System.out::println);

    }


    /**
     * map 转换器
     */
    @Test
    public void test10() {
        Stream<Double> doubleStream = StudentData.getList().stream().distinct().map(t -> t.getScore());
        doubleStream.forEach(System.out::println);



    }


    /**
     *
     */
    @Test
    public void exer() {
        List<Student> list = StudentData.getList();
        Stream<Student> stream1 = list.stream();
        Stream<Student> stream2 = stream1.filter(t -> t.getGrade() == 3);
        //stream2.forEach(t -> System.out.println(t));
        stream2.forEach(System.out::println);




    }



    /**
     *
     */
    @Test
    public void test5() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add((int)(Math.random() * 200));
        }
        Stream<Integer> stream1 = list.stream();
        Stream<Integer> stream2 = stream1.filter(t -> t > 80);
        stream2.forEach(System.out::println);



    }

    /**
     * 基于散列数据创建流
     */
    @Test
    public void test3() {
        Stream<String> stream = Stream.of("a", "yy", "qq", "123", "bb", "909");
        stream.forEach(System.out::println);
    }


    @Test
    public void test1(){

        //List<Student> list = Student

    }
}
