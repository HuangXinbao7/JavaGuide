package com.atguigu.javase.collection;

import org.junit.Test;
import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * Map<k, v>：保存一对一对的具有映射关系的对象。像一个字典。
 *      可以简单的看作是两个子集合的组合。
 *      也可以看做是特殊的Entry对象的Set集合。
 *
 * 方法：
 * v put(k key, v value)    放入Map集合中一对映射。相当于写词条
 * v get(k key)             根据键对象获取对应的值对象。相当于查词典。
 * v remove(k key)          删除给定的键，并同时删除值
 * int size()               获取条目个数
 * Set keySet();            获取保存所有键对象的Set子集合
 * Set entrySet()           获取保存所有条目对象的Set集合
 *
 * 实现子类：
 *      HashMap：使用哈希算法实现的Map集合，线程不安全，效率高。
 *      TreeMap：基于二叉搜索树实现的Map集合。
 *      Hashtable 和 HashMap一模一样，是古老的，线程安全，效率低
 *          Properties 属性处理器，键是属性名，值是属性值，所有默认键值都是字符串
 *
 *
 */
public class MapTest {


    /**
     * Collections：工具类
     */
    @Test
    public void test3() {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++) {
            list.add((int)(Math.random() * 20));
        }
        System.out.println(list);

        Collections.sort(list);     // sort()方法底层使用归并排序
        System.out.println(list);

        Collections.reverse(list);  // 反转
        System.out.println(list);

        Collections.shuffle(list);  // 乱序
        System.out.println(list);
    }


    /**
     * 属性类
     */
    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\com\\atguigu\\javase\\collection\\myPropertiesFile"));

        String name = properties.getProperty("name");   // 根据属性名获取属性值
        System.out.println(name);

        // 设置属性键值
        properties.setProperty("name", "Nicky");
        properties.setProperty("password", "123456");

        // 文件输出流，写入文件
        FileOutputStream fileOutputStream = new FileOutputStream("src\\com\\atguigu\\javase\\collection\\myPropertiesFile");
        properties.store(fileOutputStream, "comment");
    }


    /**
     * Map练习：
     * 编写程序，在main方法中创建Map集合（使用泛型），用来存放圆的半径（key）和面积（value）；
     * 以半径为key，面积为value，将半径1-50的圆面积数据(直接取整)保存其中；
     * 将Map中的半径数据取至Set集合中；
     * 遍历Set集合的半径，逐一从Map中取出对应的面积值，并将半径和面积打印出来。
     */
    @Test
    public void exer1(){

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 1; i < 51; i++) {
            int area = (int)(Math.PI * i * i);
            map.put(i, area);
        }

        // 遍历 map
        // Map中的半径数据取至Set集合中
        Set<Integer> set1 = map.keySet();
        // 获取set1集合的迭代器
        Iterator<Integer> iterator = set1.iterator();
        // 遍历Set集合的半径
        while(iterator.hasNext()) {
            Integer key = iterator.next();  // 拿到 半径
            Integer val = map.get(key);     // 从Map中取出对应的面积值
            System.out.println("key ==> " + val);   // 并将半径和面积打印出来
        }
    }


    /**
     * Map
     */
    @Test
    public void test1() {

        Map<Integer, String> map = new HashMap<Integer, String>();  // 空词典
        map.put(9, "nine");
        map.put(2, "two");  // put时，没有老值，返回null
        map.put(3, "three");
        map.put(8, "eight");
        map.put(4, "four");
        map.put(2, "TWO");  // 相同键put时，会有新值覆盖老值得过程，并返回老值
        map.put(0, "Zero");

        System.out.println("size: " + map.size());  // 6

        String value = map.get(8);
        System.out.println(value);      // eight

        System.out.println(map);

        map.remove(0);  // 删除条目
        System.out.println(map);

        // Map集合的遍历
        // 获取保存所有键对象的Set子集合
        Set<Integer> set1 = map.keySet();
        Iterator<Integer> iterator = set1.iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            String val = map.get(key);
            System.out.println(key + ">>>" + val);
        }
        System.out.println("****************************");

        // 获取保存所有条目对象的Set集合
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> tmp: entries) {
            System.out.println(tmp.getKey() + "<<<" + tmp.getValue());
        }
    }
}
