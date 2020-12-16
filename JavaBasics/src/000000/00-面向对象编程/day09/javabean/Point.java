package com.atguigu.javase.javabean;

/**
 * 3.定义一个“点”（Point）类用来表示平面中中的点（有两个坐标）。要求如下：
 *     1）可以生成具有特定坐标的点对象。
 *     2）提供可以设置两个坐标的方法。
 *     3）提供可以计算该“点”距原点距离的平方的方法
 */
public class Point {

    private int x;
    private int y;

    public Point() {}

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public String say() {
        return "x : " + x + ", y : " + y;
    }

    // 这种写法不好, 对象内部已经有数据了, 就不要插手别的数据
    //public int getDistance(int x, int y) {
    public int getDistance() {
        return x * x + y * y;
    }
}
