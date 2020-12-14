package com.atguigu.javase.abstracttest;

public class Dog extends Pet {

    private String breed;

    public Dog() {
    }

    public Dog(String name, int age, double weight, String breed) {
        super(name, age, weight);
        this.breed = breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return super.toString() + ", 品种：" + breed;
    }

    @Override
    public void speak() {
        System.out.println("汪汪~");

    }

    @Override
    public void eat() {
        System.out.println("啃骨头~");
    }
}
