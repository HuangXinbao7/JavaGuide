package com.atguigu.javase.polymorphism;

class Base {
    int count = 10;

    public void display() {
        System.out.println(this.count);
    }
}

class Sub extends Base {
    int count = 20;

    public void display() {
        System.out.println(this.count);
    }
}

public class TestFieldMethod {

    public static void main(String[] args) {

        Sub s = new Sub();  // 子类对象，s保存的是对象实体的地址
        System.out.println(s.count);    // 20
        s.display();    // 20

        Base b = s;     // 把s中的地址写入b引用变量
        System.out.println(b == s);     // ？？？ 比较的是地址值：true
        System.out.println(b.count);    // 10, 属性不具有多态性
        b.display();    // 20， 方法具有多态性
    }
}
