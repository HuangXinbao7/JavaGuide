package com.atguigu.javase.abstracttest;

public class Cat extends Pet {

    private String color;

    public Cat() {
    }

    public Cat(String name, int age, double weight, String color) {
        super(name, age, weight);
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return super.toString() + ", 颜色：" + color;
    }

    // 此方法在父类中是完全抽象的, 子类重写时添加了方法体, 这个过程称为实现(implement)
    @Override
    public void speak() {
        System.out.println("喵喵~~");
    }

    // 此方法在父类中是完全抽象的, 子类重写时添加了方法体, 这个过程称为实现(implement)
    @Override
    public void eat() {
        System.out.println("小猫吃鱼干~");
    }
}
