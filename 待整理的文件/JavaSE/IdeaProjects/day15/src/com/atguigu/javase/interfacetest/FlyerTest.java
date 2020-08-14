package com.atguigu.javase.interfacetest;

public class FlyerTest {

    public static void main(String[] args) {
        Pet pet = new Bird("小飞", 2, 0.25, 30);
        pet.speak();
        pet.eat();

        // 多态
        if(pet instanceof Flyer) {
            Flyer flyer = (Flyer)pet;   // 造型，造型只看对象实体！
            flyer.takeOff();
            flyer.fly();
            flyer.land();
        }
    }


    public static void main1(String[] args) {
        System.out.println("Hello");
        Flyer f = new Plane();  // 接口类型也可以应用多态，接口只能多态
        f.takeOff();
        f.fly();
        f.land();
    }
}
