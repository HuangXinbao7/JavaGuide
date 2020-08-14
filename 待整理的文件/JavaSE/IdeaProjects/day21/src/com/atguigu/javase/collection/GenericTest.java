package com.atguigu.javase.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *  * 泛型 ：
 *  * 1. 解决元素存储的安全性问题
 *  * 2. 解决获取数据元素时，需要类型强转的问题
 */
// 自定义泛型类：灵活，安全。兼容Object
// 泛型参数：在创建对象时才能确定具体类型。
// 泛型参数和对象相关，与类无关
// 如果在创建对象时不指定泛型类型，默认是Object类型
class Person<X> {   // <X> 表示泛型，x是某种类型，具体是什么还不确定。像一个参数。
    private String name;
    private X info;

    public Person() {
    }

    public Person(String name, X info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public X getInfo() {
        return info;
    }

    public void setInfo(X info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", info=" + info +
                '}';
    }
}

/**
 * 泛型：
 * 解决元素存储的安全性问题
 * 解决获取数据元素时，需要类型强转的问题
 */
public class GenericTest {

    @Test
    public void test3() {
        //
        Person<Integer> p1 = new Person<Integer>("张三", 30);
        Integer info1 = p1.getInfo();

        Person<String> p2 = new Person<>("李四", "女");
        String info2 = p2.getInfo();

        Person p3 = new Person("王五", true);     // 类型不安全
        Object info3 = p3.getInfo();
    }


    @Test
    public void tet2() {
        // Person类中的info属性类型不安全
        Person p1 = new Person("张三", 30);
        Person p2 = new Person("张三", "男");
        Person p3 = new Person("张三", true);

        Object info1 = p1.getInfo();
        Object info2 = p2.getInfo();

    }


    @Test
    public void test1() {

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add((int)(Math.random() * 20));
        }
        //list.add("abc");    // 泛型约束不能乱加对象
        System.out.println(list);
        Integer integer = list.get(0);
        System.out.println(integer);

        List<Double> dList = new ArrayList<>();
        dList.add(3.45);
        dList.add((double)5);
    }
}
