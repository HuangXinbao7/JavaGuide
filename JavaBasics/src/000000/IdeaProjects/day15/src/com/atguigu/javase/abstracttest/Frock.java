package com.atguigu.javase.abstracttest;

/**
 * 写一个抽象类Frock，包含属性尺寸(size),颜色和价格, 并在类中声明抽象方法double calcArea() ，用来计算衣服的布料面积。
 * 通过编写代码来验证抽象类中是否可包含属性、具体方法和构造器
 */
public abstract class Frock {

    private int size;
    private String color;
    private double price;

    public Frock() {
    }

    public Frock(int size, String color, double price) {
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    // 抽象方法
    public abstract double calcArea();  // 用来计算衣服的布料面积
}
