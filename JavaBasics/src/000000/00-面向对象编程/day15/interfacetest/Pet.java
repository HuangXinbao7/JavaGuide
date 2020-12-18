package com.atguigu.javase.interfacetest;

//public abstract class Pet implements Flyer { // 抽象类也可以实现接口, 并可以对其中的抽象方法不予以理会.
public abstract class Pet {

    private String name;
    private int age;
    private double weight;

    public Pet() {
    }

    public Pet(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    public abstract void speak();

    public abstract void eat();
}