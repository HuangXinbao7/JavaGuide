package com.atguigu.javase.homework;

import com.atguigu.javase.collection.Student;

import java.util.HashSet;
import java.util.Set;

/**
 * 作业3：
 * 写自定义类Person, 属性name, age, gender
 * 创建HashSet集合, 添加几个对象, 对象中有一些是属性完全相同的, 默认能否去重???
 * 如果想要达到去重的效果, 如何做?
 */
public class HashSetTest {

    public static void main(String[] args) {

        Set set = new HashSet();    // 无序不重复

        Person s1 = new Person("小明", 28, "男");
        Person s2 = new Person("小红", 22, "女");
        Person s3 = new Person("小明", 28, "男");

        set.add(s1);
        set.add(s2);
        set.add(s3);    // s3 对象的属性和s1完全一样

        // 思考：s3 对象的属性和s1完全一样。那么s3能被成功添加到集合中吗？
        // 默认情况下不能去重
        // 原因是判断对象是否相等使用的是 equals() 方法。而默认的equals方法中比较的是对象的地址。
        // s1 和 s3 是两个不同的对象引用。所以equals方法的判断结果是 false。因此s3能被添加到集合中

        // 要想达到去重效果，必须重写 equals方法。
        // 在Student类中重写该方法后。能达到比较对象内容的目的。
        for(Object obj: set) {
            System.out.println(obj);
        }
    }
}
