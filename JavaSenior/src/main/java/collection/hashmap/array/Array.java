package org.example.collection.hashmap.array;

/**
 * @author: Ming
 * Date: Created on 2020/9/24 0:51
 */
public class Array {

    /**
     * 数组：采用一段连续的存储单元来存储数据。
     * 特点：指定下标O(1) 删除插入O(N) 数组：查询快，插入慢
     * @param args
     */
    public static void main(String[] args) {
        // java中使用 [] 表示数组
        Integer[] integers = new Integer[10];
        integers[0] = 0;
        integers[1] = 1;
        integers[4] = 2;

        System.out.println(integers[4]);
    }
}
