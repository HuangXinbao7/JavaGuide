package com.atguigu.javase.statictest;

/**
 * 练习1：
 * 编写上衣Frock类，不继承任何父类。包含尺寸（大小）、颜色、价格等属性。
 * 在上衣类Frock中覆盖toString方法，用来返回 frock的详细信息。
 * 在Frock类中声明私有的静态属性currentNum，初始值为100000，作为衣服出厂的序列号起始值。
 * 声明公有的静态方法getNextNum，作为生成上衣唯一序列号的方法。每调用一次，将currentNum增加100，并作为返回值。
 * 在FrockTest 类的main方法中，分两次调用getNextNum方法，获取序列号并打印输出。
 *
 * 练习2：
 * 在Frock类中声明serialNumber属性，并提供对应的get方法
 * 在Frock类的构造器中，通过调用getNextNum方法为Frock对象获取唯一序列号
 */
public class Frock {

    // 静态的声明放在前面
    private static int currentNum = 100000;     // static修饰的
    public static int getNextNum(){
        return currentNum += 100;
    }

    /**
     * 在Frock类中声明静态语句块，语句块中将currentNum的初始值设为150000，作为衣服出厂的序列号起始值，并打印输出该值。
     * 执行FrockTest 类的main方法，分别创建三个Frock 对象，验证静态语句块是否只执行一次，以及序列号起始值是否已调整
     */
    static {
        currentNum = 150000;
        System.out.println("static... " + currentNum);
    }

    private int serialNumber;
    private int size;
    private String color;
    private double price;


    public Frock() {}

    public Frock(int size, String color, double price) {
        serialNumber = getNextNum();
        this.size = size;
        this.color = color;
        this.price = price;
        //this.serialNumber = serialNumber;
    }


    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
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

    // 覆盖toString方法
    @Override
    public String toString() {
        return "Frock{" +
                "serialNumber=" + serialNumber +
                ", size=" + size +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
