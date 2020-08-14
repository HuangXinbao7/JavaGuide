package com.atguigu.javase.homework;

import org.junit.Test;

/**
 * 作业2：
 * 创建 Set 集合，保存10个随机整数，再把这些数复制到List集合中。
 * 找出最大值，对List集合排序。
 */
public class SetToListTest {

    @Test
    public void test() {
        // 创建 Set 集合，List 集合
        Set set = new HashSet();
        List list = new ArrayList();

        // 保存10个随机整数
        while(set.size() < 10) {
            set.add((int)(Math.random() * 100));
        }

        // 把数据从 Set 复制到 List 集合中
        // 遍历集合不能只用经典for，只能使用增强for
        for(Object obj: set) {
            list.add(obj);
        }


        // 调用现有的API排序
        Object max = Collections.max(list);
        Collections.sort(list);
        System.out.println("max: " + max);
        System.out.println("list: " + list);
    }


    public static void main(String[] args) {

        // 创建 Set 集合，List 集合
        Set set = new HashSet();
        List list = new ArrayList();

        // 保存10个随机整数
        while(set.size() < 10) {
            set.add((int)(Math.random() * 100));
        }

        // 把数据从 Set 复制到 List 集合中
        // 遍历集合不能只用经典for，只能使用增强for
        for(Object obj: set) {
            list.add(obj);
        }

        // 找出最大值
        // 集合中保存的是对象，不应转成 int 型，而是转成 Integer 类
        int maxNum = (Integer)list.get(0);      // 假定第一个对象中的数最大
        for(int i = 0; i < list.size(); i++) {
            if((Integer)list.get(i) > maxNum) {
                maxNum = (Integer)list.get(i);
            }
        }
        System.out.println("最大值：" + maxNum);


        System.out.println("排序前：" + list);
        // 对List集合排序: 选择排序
        for(int i = 0; i < list.size() - 1; i++) {
            for(int j = i + 1; j < list.size(); j++) {
                if((Integer)list.get(i) > (Integer)list.get(j)) {
                    Object tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
        System.out.println("排序后：" + list);
    }
}
