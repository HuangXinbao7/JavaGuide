package com.atguigu.javase.codeexer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {

    @Test
    public void test1() {

        Map<Integer, String> map = new HashMap<Integer, String>();  // 空字典
        map.put(9, "nine");     //
        map.put(2, "two");
        map.put(3, "three");
        map.put(8, "eight");
        map.put(4, "four");

        String str = map.put(2, "TWO");     //
        System.out.println(str);
        String str2 = map.put(0, "zero");
        System.out.println(str2);

        System.out.println("size: " + map.size());
        String value = map.get(8);
        System.out.println(value);
        System.out.println(map);
        map.remove(0);
        System.out.println(map);
        System.out.println("************************");
        Set<Integer> set1 = map.keySet();
        Iterator<Integer> iterator = set1.iterator();
        while(iterator.hasNext()){
            Integer key = iterator.next();
            String val = map.get(key);
            System.out.println(key + " >>> " + val);
        }
        System.out.println("*************************");

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for(Map.Entry<Integer, String> tmp: entries) {
            System.out.println(tmp.getKey() + " >>>>>>>>>>> " + tmp.getValue());
        }
    }
}
