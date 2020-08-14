package com.atguigu.javase.homework;

import org.junit.Test;

import java.util.*;

/**
 * 作业3：给定一个字符串, 统计每个字符出现的次数
 * 这是一道谷歌面试题。
 */
public class StringTask {


    /**
     * 思考：用一个数组来解决这个问题。
     */
    @Test
    public void test1() {
        String s = "akakfjakgalkakjkna发达咖啡机";

        int[] arr = new int[65536];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                System.out.println((char)i + ": " + arr[i]);
            }
        }
    }


    // 方法二
    public static void main(String[] args) {

        String s = "akakfjakgalkakjkna发达咖啡机";
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = map.get(c);
            if(count == null) {
                count = 0;
                map.put(c, 1);
            } else {
                map.put(c, ++count);
            }
        }

        // 取出保存所有键对象的Set子集合
        Set<Character> set1 = map.keySet();
        // 获取迭代器
        Iterator<Character> iterator = set1.iterator();
        // 遍历Set集合，打印输出
        while(iterator.hasNext()) {
            Character key = iterator.next();
            Integer val = map.get(key);
            //System.out.println("字符'" + key + "'一共出现了：" + val + "次");
            System.out.println(key + " = " + val + "次");
        }
    }


    // 方法一
    public static void main1(String[] args) {

        // 给定一个字符串
        String s = "akakfjakgalkakjkna发达咖啡机";

        // 创建Map集合对象
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        // 遍历字符串 s
        for(int i = 0; i < s.length(); i++) {
            // 获取字符串s中的每一个字符
            Character c = s.charAt(i);
            // 判断字符c在不在map的key中
            if(map.containsKey(c)) {
                // 如果在，则取出当前key对应的value值，加1
                Integer n = map.get(c) + 1;
                // 然后再put到map中，实现当前字符的统计数增1
                map.put(c, n);
            } else {
                // 如不字符c不在map的key中，则将key=c, value=1 put到map中
                map.put(c, 1);
            }
        }

        // 取出保存所有键对象的Set子集合
        Set<Character> set1 = map.keySet();
        // 获取迭代器
        Iterator<Character> iterator = set1.iterator();
        // 遍历Set集合，打印输出
        while(iterator.hasNext()) {
            Character key = iterator.next();
            Integer val = map.get(key);
            //System.out.println("字符'" + key + "'一共出现了：" + val + "次");
            System.out.println(key + " = " + val + "次");
        }
    }
}
