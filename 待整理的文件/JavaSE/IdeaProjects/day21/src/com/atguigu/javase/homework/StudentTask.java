package com.atguigu.javase.homework;

import com.sun.org.apache.xml.internal.utils.StringToIntTable;
import org.junit.Test;

import java.util.*;

/**
 * 作业2：请把学生名与考试分数录入到Map中，并按分数显示前三名成绩学员的名字。
 */
public class StudentTask {


    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        Student s1 = new Student(1, "小明", 6, 70);
        Student s2 = new Student(2, "小芳", 6, 37);
        Student s3 = new Student(3, "小刚", 6, 96);
        Student s4 = new Student(4, "小美", 6, 56);
        Student s5 = new Student(5, "小红", 6, 89);
        Student s6 = new Student(6, "小丽", 6, 45);
        Student s7 = new Student(7, "小东", 6, 76);

        // 把学生名与考试分数录入到Map中
        map.put(s1.getName(), s1.getScore());
        map.put(s2.getName(), s2.getScore());
        map.put(s3.getName(), s3.getScore());
        map.put(s4.getName(), s4.getScore());
        map.put(s5.getName(), s5.getScore());
        map.put(s6.getName(), s6.getScore());
        map.put(s7.getName(), s7.getScore());
        System.out.println(map);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int n =  o2 - o1;
                // 防止去重
                if (n == 0) {
                    return 1;
                }
                return n;
            }
        };

        // 使用TreeMap把数据倒一下
        Map<Integer, String> map1 = new TreeMap<Integer, String>(comparator);
        // 遍历map，先获取所有的键对象
        Set<String> keys = map.keySet();
        Iterator<String> iterator = keys.iterator();
        while(iterator.hasNext()) {
            String name = iterator.next();
            Integer score = map.get(name);
            map1.put(score, name);
        }

        Set<Map.Entry<Integer, String>> entries = map1.entrySet();
        int count = 0;
        int grade = 0;  // 级别
        int lastScore = 0;
        for(Map.Entry tmp: entries) {
            if((Integer)tmp.getKey() != lastScore) {
                grade++;
                if(grade == 4) {
                    break;
                }
            }
            System.out.println(tmp.getKey() +", "+tmp.getValue());
            lastScore = (Integer)tmp.getKey();
        }

        Set<Map.Entry<String, Integer>> entries1 = map.entrySet();

        Iterator<Map.Entry<String, Integer>> iterator1 = entries1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next().getKey());
        }
    }
}
