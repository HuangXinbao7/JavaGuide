package com.atguigu.javase.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 数组：一组相同类型的任意数据的组合实现统一管理
 * 集合：解决批量对象的存储问题。可以看作是一个可变长度的 对象数组 Object[]
 *      1）Collection: 保存的一个一个的对象，无序可重复，不按添加顺序保存对象，对象可重复
 *          boolean add(Object obj) 添加一个新对象，返回布尔
 *          boolean contains(Object obj) 判断是否包含某个对象
 *          boolean remove(Object obj) 从集合中删除指定对象
 *          int size() 获取集合中的元素个数
 *
 *          Set接口：无序不可重复。
 *              HashSet：使用Hash算法实现的Set集合
 *                  去重规则：equals相等，HashCode码也要相同。
 *
 *                  equals 和 hashCode的关系：
 *                      如果两个对象的 equals 为 true，那么两个对象的哈希码必须一样，体现特征性。
 *                      如果两个对象的 equals 为 false，那么两个对象的哈希码必须不同，体现散列性。
 *
 *              TreeSet：使用二叉树实现的Set集合
 *
 *          List接口：有序可重复。按照添加顺序保存数据，可以重复。像数组，有下标的概念。
 *              void add(int index, Object ele) // 在指定下标处插入新元素
 *              Object get(int index)   // 获取指定下标处的对象。使用频率最高。
 *              Object remove(int index)    // 删除指定下标处的对象
 *              Object set(int index, Object ele)    // 替换指定下标处的元素为新元素
 *
 *              ArrayList：基于数组实现的 List 集合。
 *              LinkedList：基于链表实现的 List 集合。
 *              HashList：使用Hash算法实现的 List 集合。
 *
 *      2）Map: 保存一对一对的对象
 *
 */
public class CollectionTest {

    /**
     * Set 集合去重测试
     */
    @Test
    public void test5() {
        Set set = new HashSet();    // 无序不可重复

        Student s1 = new Student(1, "小明", 3,90);
        Student s2 = new Student(2, "小丽", 2,90);
        // s3 对象的属性和s1完全一样
        Student s3 = new Student(1, "小明", 3,90);

        set.add(s1);
        set.add(s2);
        set.add(s3);    // 这个默认情况下不可去重，需要重写 equals方法
        set.add(s1);    // 这个默认情况下可去重

        // 思考：s3 对象的属性和s1完全一样。那么s3能被成功添加到集合中吗？
        // 原因是判断对象是否相等的是 equals() 方法。而默认的equals方法中比较的是对象的地址。
        // s1 和 s3 是两个不同的对象引用。所以equals方法的判断结果是 false。因此s3能被添加到集合中

        // 要想达到去重效果，必须重写 equals方法。在Student类中重写该方法。达到比较内容的目的。
        for (Object tmp: set) {
            System.out.println(tmp);
        }
    }


    /**
     * 练习进阶：创建一个 List 集合，保存10个20内的随机整数，要求不重复。遍历打印
     */
    @Test
    public void exer32() {

        List list = new ArrayList();
        while (list.size() < 10) {
            int n = (int)(Math.random() * 20);
            if(!list.contains(n)) {     // 不包含，才添加
                list.add(n);
            }
        }

        // 使用经典for循环遍历 List
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }


    /**
     * 练习：创建一个 List 集合，保存10个20内的随机整数，遍历打印
     */
    @Test
    public void exer3() {

        List list = new ArrayList();
        while (list.size() < 10) {
            int n = (int)(Math.random() * 20);
            list.add(n);
        }
        for(Object obj: list) {
            System.out.print(obj + " ");
        }
    }


    @Test
    public void test4() {
        //List list = new List();
        List list = new ArrayList();
        list.add("abc");
        list.add("yyy");
        list.add(new Student(2, "小花", 5, 100));
        list.add("abc");
        list.add("yyy");
        list.add("yyy");
        list.add("yyy");
        list.add(100);

        // 全部删除指定的对象，必须使用循环。且不需要循环体。
        while (list.remove("yyy"));

        System.out.println(list);
        System.out.println("*******************");
        // 使用经典for可以遍历 List
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            System.out.println(obj);
        }
    }


    @Test
    public void test3() {

        //List list = new List();
        List list = new ArrayList();
        list.add("abc");
        list.add("yyy");
        list.add(new Student(2, "小花", 5, 100));
        list.add("abc");
        list.add("yyy");
        list.add(100);
        System.out.println(list);

        System.out.println(list);
        list.add(2, 2000);  // 在指定下标处插入新元素
        System.out.println(list);

        list.set(3, 3000);      // 替换元素
        System.out.println(list);

        list.remove(1);     // 删除指定下边处的元素
        list.remove(Integer.valueOf(100));  // 删除指定对象，需要手动装箱
        System.out.println(list);
    }


    /**
     * 练习进阶：创建一个Set集合，保存10个20以内的随机整数，必须够10个，遍历打印
     */
    // 练习进阶：方法三
    @Test
    public void exer23() {
        Set set1 = new HashSet();
        for(int i = 0; i < 10; ) {
            int n = (int)(Math.random() * 20);
            boolean flag = set1.add(n);     // 返回添加是否成功的状态
            if (flag) {    // 如果成功
                i++;        // 有条件循环
            }
        }

        for (Object tmp: set1) {
            System.out.print(tmp);
        }
    }

    // 练习进阶：方法二
    @Test
    public void exer22() {
        Set set1 = new HashSet();
        for(int i = 0; i < 10; i++) {
            int n = (int)(Math.random() * 20);
            boolean flag = set1.add(n);     // 返回添加是否成功的状态
            if (!flag) {    // 如果添加失败
                i--;        // 本次循环作废，增加一次循环次数
            }
        }

        for (Object tmp: set1) {
            System.out.print(tmp);
        }
    }

    // 练习进阶：方法一
    @Test
    public void exer2() {
        Set set1 = new HashSet();
        // 使用 while循环监视集合中元素的总个数，只要元素个数小于10，就继续添加。
        while (set1.size() < 10) {
            // Math.random() 会得到一个[0,1) 的随机浮点数
            set1.add((int)(Math.random() * 20));
        }

        for(Object obj: set1) {
            System.out.print(obj + " ");
        }
    }


    /**
     * 练习：创建一个Set集合，保存10个20以内的随机整数，遍历打印
     */
    @Test
    public void exer1() {

        Set set1 = new HashSet();
        for(int i = 0; i < 10; i++) {
            // 使用for循环10次。如果生成了重复的随机整数，则会添加失败，导致Set集合中的元素总个数小于10
            set1.add((int)(Math.random() * 20));
        }
        for(Object obj: set1) {
            System.out.print(obj + " ");
        }
    }


    @Test
    public void test1() {

        // 不能直接 new Set();
        Set set1 = new HashSet();   // 不按添加顺序保存对象
        set1.add("abc");
        set1.add("yyy");
        set1.add(new Student(1, "小明", 5, 80));
        set1.add(new Integer(200));
        set1.add(100);  // 自动装箱
        boolean b1 = set1.add("yyy");       // false, 添加失败
        boolean b2 = set1.add(200);         // false, 添加失败
        System.out.println(b1 + ", " + b2);     // false, false
        System.out.println(set1.size());
        System.out.println(set1);

        boolean isContains = set1.contains(100);    // 判断是否包含某个元素
        System.out.println(isContains);

        set1.remove("abc");         // 删除指定元素
        System.out.println(set1);
        System.out.println("***************");

        // 遍历集合
        for(Object tmp: set1) {
            System.out.println(tmp);
        }
    }


    // Set集合测试
    public static void main(String[] args) {

        Set set = new HashSet();
        set.add(new Integer(123));
        // set.add() 方法有返回值，添加成功返回 true
        System.out.println("添加Integer125：" + set.add(125)); // true
        System.out.println("添加Integer125：" + set.add(125)); // false, 添加重复元素

        set.add("abcdef");
        set.add(new String("abcdfghi"));

        System.out.println("Set集合是否为空：" + set.isEmpty());   // false, 表示不为空
        System.out.println("Set集合是否包含123：" + set.contains(123));    // true
        System.out.println("Set集合中的元素个数：" + set.size());
        System.out.println(set);    // 打印集合所有元素

        for(Object o: set) {
            System.out.println("Set集合中的元素：" + o);
        }
    }


    // foreach举例
    // 判断输出结果
    public static void main1(String[] args) {

        String[] str = new String[5];
        for(String myStr: str) {
            myStr = "atguigu";              // myStr 是局部变量
            System.out.println(myStr);      // atguigu
        }
        for(int i = 0; i < str.length; i++) {
            System.out.println(str[i]);     // null
        }
    }
}
