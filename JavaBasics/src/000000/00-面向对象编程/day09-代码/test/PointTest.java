package com.atguigu.javase.test;

import com.atguigu.javase.javabean.Point;

/**
 * 面向对象的原则 : 该对象做的事情, 必须自己做, 也是一种封装性
 * 不该对象做的事情, 不要做, 也体现封装性.
 */
public class PointTest {

    public static void main(String[] args) {
        Point point = new Point(3, 4);
        System.out.println(point.say());

        //System.out.println(point.getDistance(10, 20)); 不要多管闲事.
        System.out.println(point.getDistance());
    }
}
