package com.atguigu.javase.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Consumer;

/**
 * Lambda表达式作用：代替匿名内部类对象
 * 前提：java中越来越成熟的推断机制
 * 省略 new T1() {
 *     省略方法的修饰符，方法名
 * }
 * 只保留了参数列表和方法体
 * lambda可以省略以上内容是因为编译器知道它的即可类型，所有根据接口推断
 *
 * lambda只适用于接口中只有一个抽象方法的接口。实现方法时就一条语句。
 * lambda的目的：就是让使用者的关注焦点落在方法上。关注在函数上
 * () -> 方法体
 * 参数：函数的输入
 * 方法体：函数的输出
 */
public class LambdaTest {

    @Test
    public void test04() {
        //Consumer<String, Integer> conSI = (String str, Integer n) -> {System.out.println(str+n);}
    }


    /**
     * Lambda表达式的语法格式
     */
    @Test
    public void test03() {
        // 语法格式一：无参，无返回值
        Runnable r1 = () -> {System.out.println("Hello");};

        // 语法格式二：需要一个参数，但是没有返回值，称为消费型
        Consumer<String> con = (String str) -> {System.out.println(str);};

        // 语法格式三：语法格式二的简写版。
        // 数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
        Consumer<String> con3 = (str) -> {System.out.println(str);};

        // 语法格式四：语法格式三的简写版。
        // Lambda 若只需要一个参数时，参数的小括号可以省略
        // 进一步的，小括号也可以省略。
        Consumer<String> con4 = str -> {System.out.println(str);};

        // 语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
        Comparator<Integer> com = (x, y) -> {
            System.out.println("实现函数式接口方法！");
            return Integer.compare(x, y);
        };

        // 语法格式六：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
        Comparator<Integer> com2 = (x, y) -> Integer.compare(x,y);
    }


    /**
     * 从匿名类到 Lambda 的转换举例2
     */
    @Test
    public void test02() {
        // 原来使用匿名内部类作为参数传递
        TreeSet<String> ts1 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        // Lambda 表达式作为参数传递
        TreeSet<String> ts2 = new TreeSet<>((o1, o2) -> Integer.compare(o1.length(), o2.length()));

        String ab = new String("ab");
    }


    /**
     * 从匿名类到 Lambda 的转换举例1
     */
    @Test
    public void test01() {
        // 匿名内部类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };

        // Lambda 表达式
        Runnable r1 = () -> System.out.println("hello");

        runnable.run();
        r1.run();
    }
}
