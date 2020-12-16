package com.atguigu.javase.abstracttest;

public class PetTest {

    public static void main(String[] args) {
        //Pet pet = new Pet();
        // 多态 : 把子类对象"看作是" 父类类型的对象
        // 当我们看到一个引用类型是抽象类时, 绝对是多态引用!!!
        Pet pet = new Cat("小黄", 3, 5, "黄色");
        pet.speak(); // 虚拟方法调用

        Pet[] arr = new Pet[6]; // 只是new Pet引用数组, 不是new Pet对象
    }
}
