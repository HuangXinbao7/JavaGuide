package com.atguigu.javase.statictest;

// 子类继承父类的所有成员（构造器除外）
// static 关键字避免乱用
// 因为静态方法调用简单，所以称为工具方法，如果一个类中全是工具方法，这个类称为工具类
class Base {

    static int no = 10;
    int id = 20;

    static void test1() {
        System.out.println("Base static test1()");
    }

    void test2() {
        System.out.println("Base test2()");
    }
}

class Sub extends Base {

    static int no = 100;
    int id = 200;

    // 子类中同名静态方法和父类中的静态方法是共存的关系，没有多态性
    static void test1() {
        System.out.println("Sub static test1()");
    }

    // 只有子类中的非静态方法才有多态性
    void test2() {
        System.out.println("Sub test2()");
    }
}


public class ExtendsTest {

    public static void main(String[] args) {
        System.out.println(Base.no);    // 10
        // 因为静态方法调用简单，所以称为工具方法, 如果一个类中全是工具方法, 这个类称为工具类
        Base.test1();   // Base static test1()

        Sub s = new Sub();
        System.out.println(s.id);   // 200,
        Base b = s;
        System.out.println(b.id);   // 20 属性没有多态性，属性没有覆盖效果

        b.test2();      // Sub test2()  虚拟方法调用
        b.test1();      // Base static test1()  静态方法

    }
}
