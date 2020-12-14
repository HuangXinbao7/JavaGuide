package com.atguigu.javase.abstracttest;

import com.atguigu.javase.abstracttest.Frock;

/***
 * 编写 Shirt 类继承 Frock 类，实现 calcArea 方法，用来计算衬衣所需的布料面积（尺寸*1.3）。
 * 在 TestShirt 类的main方法中：
 * 试着创建 Frock 对象，确认是否允许？
 * 使用本态引用创建 Shirt 对象，并调用 calcArea 方法，打印计算结果。
 * 使用Frock多态引用创建Shirt对象，并调用calcArea方法，打印计算结果
 */
public abstract class Shirt extends Frock {

    public Shirt() {
    }

    public Shirt(int size, String color, double price) {
        super(size, color, price);
    }

    @Override
    public double calcArea() {
        return getSize() * 1.3;
    }
}
