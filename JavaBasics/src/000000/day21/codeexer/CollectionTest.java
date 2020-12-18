package com.atguigu.javase.codeexer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionTest {

    @Test
    public void test2() {
        Set set = new HashSet();
        for (int i = 0; i < 10; i++) {

        }
    }


    @Test
    public void test1() {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < 10; i++){
            set.add((int)(Math.random() * 20));
        }
        System.out.println("set: " + set);

        List<Integer> list = new ArrayList<Integer>();
        for(Integer obj: set){
            list.add(obj);
        }
        System.out.println("list: " + list);

        for(int i = 0; i < list.size() - 1; i++){
            for(int j = 0; j < list.size() - 1 - i; j++) {
                if(list.get(j) > list.get(j + 1)) {
                    Integer tmp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j + 1, tmp);
                }
            }
        }
        System.out.println("list: " + list);

        int maxVal = list.get(0);
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) > maxVal) {
                maxVal = list.get(i);
            }
        }
    }
}
