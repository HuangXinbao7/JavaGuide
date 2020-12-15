package com.atguigu.javase.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 作业1：
 * 请从命令行参数获取 10个整数字符串,并将它们转为整数并保存到List中，
 * 并按倒序、从大到小的顺序显示出来
 */
public class ListTest {

    // 方法二：调用现成的工具类方法
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < args.length; i++) {
            list.add(Integer.parseInt(args[i]));
        }
        Collections.sort(list);
        Collections.reverse(list);
        System.out.println(list);
    }


    // 方法一
    public static void main1(String[] args) {

        List<Integer> list = new ArrayList<Integer>();

        // 10 45 63 3 24 73 65 2 5 35
        for(int i = 0; i < 10; i++) {
            int n = Integer.parseInt(args[i]);
            list.add(n);
        }
        System.out.println(list);

        // 倒序显示
        for(int i = 0; i < list.size(); i++){
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(i) < list.get(j)){
                    int tmp = list.get(i);
                    list.set(i, list.get(j)) ;
                    list.set(j, tmp);
                }
            }
        }
        System.out.println(list);
    }
}
