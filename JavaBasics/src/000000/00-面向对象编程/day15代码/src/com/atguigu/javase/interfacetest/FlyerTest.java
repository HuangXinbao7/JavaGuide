package com.atguigu.javase.interfacetest;

public class FlyerTest {

    public static void main(String[] args) {
        Pet pet = new Bird("小飞", 2, 0.25, 30);
        pet.speak();
        pet.eat();
        // 多态 : 把子类对象 "当成是" 父类对象来看待
        if (pet instanceof Flyer) {
            Flyer flyer = (Flyer) pet; // 这里能造型吗? 永远只看对象实体!!!!!
            flyer.takeOff();
            flyer.fly();
            flyer.land();
        }
    }

    public static void main2(String[] args) {
        System.out.println("hello");
        //Flyer flyer = new Flyer();
        Flyer f = new Plane(); // 接口类型也可以应用多态. 接口只能多态.
        f.takeOff();
        f.fly();
        f.land();
    }
}
