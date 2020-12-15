package org.example.collection;


import org.example.collection.hashmap.map.HashMap;
import org.example.collection.hashmap.map.Map;

/**
 * @author: Ming
 * Date: Created on 2020/9/24 0:44
 */
public class APP {

    public static void main(String[] args) {
        //HashMap<String, String> map = new HashMap<>();
        Map<String, String> map = new HashMap<String, String>();
        //APP map = new APP();
        map.put("zs", "张三");
        map.put("ls", "李四");
        map.put("ww", "王五");
        map.put("zl", "赵六");

        //
        System.out.println(map.get("zs"));
    }

    // 模拟 put 方法
    public void put(String key, String value) {
        System.out.printf("key: %s，hash值: %s，存储位置: %s\r\n", key, key.hashCode(), Math.abs(key.hashCode() % 15));
    }
}
