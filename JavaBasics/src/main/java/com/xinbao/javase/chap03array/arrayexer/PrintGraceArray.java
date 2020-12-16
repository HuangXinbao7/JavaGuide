package com.xinbao.javase.chap03array.arrayexer;

import org.junit.Test;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 打印Java数组最优雅的方式
 */
public class PrintGraceArray {

    /**
     * 为什么不能直接打印数组
     */
    @Test
    public void test1() {
        String [] arr = {"Java", "Scala", "C++"};
        /*
        * 打印结果是：[Ljava.lang.String;@2957fcb0
        * Ljava.lang.String 表示字符串数组的Class名
        * @ 后面的是十六进制的HashCode
        * */
        System.out.println(arr);
    }

    /**
     * 使用 Stream
     * 如果是 JDK8 以上的版本，可以使用 Stream 这种方式来遍历数组，顺带将其打印出来。
     */
    @Test
    public void test2() {
        String [] arr = {"Java", "Scala", "C++"};

        // 方式一，不够优雅，可以简化
        Arrays.asList(arr).stream().forEach(s -> System.out.println(s));

        // 方式二
        Stream.of(arr).forEach(System.out::println);

        // 方式三
        Arrays.stream(arr).forEach(System.out::println);
    }

    /**
     * 使用for循环对数组进行变量顺便打印的方式，甚至 for-each 也行
     */
    @Test
    public void test3() {
        String [] arr = {"Java", "Scala", "C++"};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        for (String s : arr) {
            System.out.println(s);
        }
    }


    /**
     * 使用 Arrays.toString()
     * Arrays.toString() 可以将任意类型的数组转成字符串，包括基本类型数组和引用类型数组
     */
    @Test
    public void test4() {
        String [] arr = {"Java", "Scala", "C++"};

        System.out.println(Arrays.toString(arr));
    }


    /**
     * 使用 Arrays.deepToString()
     * 打印多维数组
     */
    @Test
    public void test5() {
        String[][] deepArray = {{"Java", "Scala"}, {"Hadoop", "Spark", "Flink"}};
        String deepToString = Arrays.deepToString(deepArray);
        System.out.println(deepToString);
    }
}
