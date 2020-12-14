package com.atguigu.javase.object;

import java.util.Objects;

/**
 * toString() 方法
 */
public class Point extends Object {

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

    public String say(){
        return "x: " + x + ", y: " + y;
    }

    /*
    从Object父类中继承的方法。默认的方法是比较地址。
    这个方法写的过于简单，必须在子类中重写！
    public boolean equals(Object obj) {
        return (this == obj);
    }
    */
    @Override
    public boolean equals(Object obj){  // 多态参数方法
        // 重写以后的方法应该满足对象内容的比较.两个对象是this和obj
        // 所谓的内容是对象的所有属性值
        if(obj instanceof Point) {
            Point p = (Point)obj;
            if(this.x == p.x && this.y == p.y) {
                return true;
            }
        }
        return false;
    }

    // 这是Object类中的hashCode方法, 只体现了散列性. 底层是根据对象的物理地址, 进行散列算法得到的
    // public native int hashCode(); 实际执行时 定位的是动态库中的C++代码
    @Override
    public int hashCode() {
        // 方法中要兼顾特征性和散列性, 所有属性必须参与.
        //return Integer.parseInt(x + "000" + y);
        return Objects.hash(x, y);
    }

    // Object类中的toString()方法，需要重写才能满足实际需求
    //public String toString() {
    //    return getClass().getName() + "@" + Integer.toHexString(hashCode());
    //}
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
