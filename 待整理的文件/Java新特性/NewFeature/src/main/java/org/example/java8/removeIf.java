package org.example.java8;

import java.util.ArrayList;

/**
 * Java8新特性 removeIf 方法
 * 作用：删除集合中符合条件的成员
 * @author: Ming
 * Date: Created on 2020/9/22 23:01
 */
public class removeIf {

    public static void main(String[] args) {

        // 创建一个动态数组
        ArrayList<String> sites = new ArrayList<>();

        sites.add("Google");
        sites.add("Baidu");
        sites.add("Bing");
        sites.add("Sogou");

        System.out.println("ArrayList: " + sites);

        // 删除名称中带有 "B" 字符的元素
        // e -> e.contains("B") 是匿名函数 lambda 的表达式
        sites.removeIf(e -> e.contains("B"));
        System.out.println("删除后的 ArrayList: " + sites);
    }
}
