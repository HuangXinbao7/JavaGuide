package com.atguigu.javase.finaltest;

public abstract class Frock {

    public static final int INCREMENT = 100;

    private static int currentNum = 100000;
    public static int getNextNum() {
        return currentNum += INCREMENT;
    }

    static {
        currentNum = 150000;
        System.out.println("static..." + currentNum);
    }

    private final int serialNumber;
    private int size;
    private String color;
    private double price;

    public Frock() {
        this.serialNumber = getNextNum();
    }

    public Frock(int size, String color, double price) {
        this.serialNumber = getNextNum();
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Frock{" +
                "serialNumber=" + serialNumber +
                ", size=" + size +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

    public abstract double calcArea(); // 计算面料面积
}
