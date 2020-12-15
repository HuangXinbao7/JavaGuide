package org.example.collection.hashmap.map;

/**
 * 定义一个Map接口
 * @author: Ming
 * Date: Created on 2020/9/24 1:34
 */
public interface Map<K, V> {

    // 三个方法
    V put(K k, V v);
    V get(K k);
    int size();

    // 定义要给 Entry 接口
    interface Entry<K, V> {
        // 两个方法
        K getKey();
        V getValue();
    }
}
