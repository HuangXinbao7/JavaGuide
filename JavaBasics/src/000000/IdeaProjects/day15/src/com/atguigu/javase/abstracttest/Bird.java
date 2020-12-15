package com.atguigu.javase.abstracttest;

public class Bird extends Pet {

    // Bird 类的特有属性
    private int flySpeed;

    public Bird() {
    }

    public Bird(String name, int age, int weight, int flySpeed) {
        super(name, age, weight);
        this.flySpeed = flySpeed;
    }

    public int getFlySpeed() {
        return flySpeed;
    }

    public void setFlySpeed(int flySpeed) {
        this.flySpeed = flySpeed;
    }

    @Override
    public String toString() {
        return super.toString() + ", 飞行速度：" + flySpeed;
    }

    // 必须重写父类中的抽象方法
    // 此方法在父类中是完全抽象的, 子类重写时添加了方法体, 这个过程称为实现(implement)
    @Override
    public void speak() {
        System.out.println("布谷布谷。。。");
    }

    // 必须重写父类中的抽象方法
    // 此方法在父类中是完全抽象的, 子类重写时添加了方法体, 这个过程称为实现(implement)
    @Override
    public void eat() {
        System.out.println("吃小虫。。。");
    }
}
