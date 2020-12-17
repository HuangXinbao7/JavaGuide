package com.xinbao.javase.chap04oop.basic.exer;

/**
 * 自定义数组的工具类
 */
public class CustomArrayUtilTest {

    public static void main(String[] args) {
        CustomArrayUtil arrayUtil = new CustomArrayUtil();
        int[] ints = {32, 34, 32, 5, 3, 54, 654, -98, 0, -53, 5};

        int max = arrayUtil.getMax(ints);
        System.out.println("最大值为：" + max);

        System.out.println("排序前：");
        arrayUtil.print(ints);
        arrayUtil.sort(ints);   // 排序
        System.out.println("排序后：");
        arrayUtil.print(ints);

        System.out.println("查找：");
        int index = arrayUtil.getIndex(ints, 5);
        if(index >= 0){
            System.out.println("找到了，索引地址为：" + index);
        }else{
            System.out.println("未找到");
        }

        arrayUtil.reverse(ints);
        arrayUtil.print(ints);
    }
}
