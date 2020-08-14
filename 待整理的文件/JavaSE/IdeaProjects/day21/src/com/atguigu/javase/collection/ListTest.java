package com.atguigu.javase.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {

    @Test
    public void test1() {
        List<Integer> list = new ArrayList<Integer>();  // 基于数组实现
        list.add(20);   // 第一次添加元素时， 数组初始化成10个元素
        list.add(42);
        list.add(342);
        list.add(546);
        list.add(6);
        list.add(270);
        list.add(6);
        list.add(9);
        list.add(68);
        list.add(476);
        list.add(100);      // 真正的扩容， 扩容1.5倍

        Iterator<Integer> iterator = list.iterator();
        list.remove(3);     // 会污染迭代器, 会导致同步异常

        iterator = list.iterator(); // 迭代器被污染过后，需要重新获取迭代器
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
