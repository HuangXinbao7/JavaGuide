package com.atguigu.javase.codeexer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {

    @Test
    public void test1() {

        List<Integer> list = new ArrayList<Integer>();  // 基于数组实现

        list.add(20);
        list.add(10);
        list.add(15);
        list.add(8);
        list.add(4);
        list.add(7);
        list.add(30);
        list.add(25);
        list.add(28);
        list.add(10);
        list.add(400);      // 真正的扩容，扩容1.5倍

        Iterator<Integer> iterator = list.iterator();
        list.remove(3);     // 会污染迭代器，导致同步异常

        iterator = list.iterator();     // 重新同步迭代器
        while(iterator.hasNext()){
            System.out.println(iterator.next());    // 检查修改次数
        }
    }
}
