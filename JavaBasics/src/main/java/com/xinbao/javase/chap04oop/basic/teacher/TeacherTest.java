package com.xinbao.javase.chap04oop.basic.teacher;

import org.junit.Test;

public class TeacherTest {

    public static void main(String[] args){

        Teacher t1 = new Teacher();
        Teacher t2 = new Teacher();

        t2.name = "宁姐";
        t2.age = 22;
        t2.gender = "女";

        System.out.println(t1.say());
        System.out.println(t2.say());
    }


    public static void main4(String[] args){

        Teacher t1 = new Teacher();
        t1.name = "佟刚";
        t1.age = 40;
        t1.gender = "男";

        System.out.println(t1.say());


        Teacher t2 = new Teacher();
        t2.name = "小宁姐";
        t2.age = 20;
        t2.gender = "女";

        System.out.println(t2.say());


        System.out.println("*******************");
        // 交换两个引用
        Teacher tmp = t1;   // 一个临时引用，保存t1的地址
        t1 = t2;
        t2 = tmp;
        System.out.println(t1.say());
        System.out.println(t2.say());
    }


    /**
     *
     */
    @Test
    public void test3(){

        // t1 是什么？是一个Teacher类型的引用变量，内部保存一个地址
        Teacher t1 = new Teacher();
        // 根据t1引用变量中的地址定位到堆内存中的对象实体，再进一步根据属性名定位空间
        t1.name = "佟刚";
        t1.age = 40;
        t1.gender = "男";

        System.out.println(t1.say());


        Teacher t2 = new Teacher();
        t2.name = "小宁姐";
        t2.age = 20;
        t2.gender = "女";

        System.out.println(t2.say());


        System.out.println("==================");
        // 把t2引用变量中的地址值写入t1引用变量，此时会导致t1中原来的地址被覆盖了，
        // 原来指向的对象就变成了垃圾
        // 垃圾对象：在程序中不再有引用指向的对象。垃圾对象会被清理，清理机制有特定算法
        t1 = t2;
        t1.age = 10;
        System.out.println(t2.say());   // 10
    }

    @Test
    public void test2() {

        // t1 是一个Teacher类型的引用变量，内部保存一个地址
        Teacher t1 = new Teacher();
        // 根据t1引用变量中的地址定位到堆内存中的对象实体，再进一步根据属性名定位空间
        t1.name = "佟刚";
        t1.age = 40;
        t1.gender = "男";

        t1.lesson();
        System.out.println(t1.say());


        Teacher t2 = new Teacher();
        t2.name = "小宁姐";
        t2.age = 20;
        t2.gender = "女";

        t2.lesson();
        System.out.println(t2.say());
    }


    /**
     * 创建对象
     */
    @Test
    public void test1(){
        // 使用已经准备好的类，可以创建对象
        Teacher t = new Teacher();  // 创建一个对象，依据类模板，使用关键字 new
        t.name = "李明";
        t.age = 30;
        t.gender = "男";

        // 对象成员，必须通过 对象.成员 的方法来访问
        System.out.println(t.name);     // 打印对象的属性 name
        System.out.println(t.age);      // 打印对象的属性 age
        System.out.println(t.gender);   // 打印对象的属性 gender

        // 对象方法
        t.lesson();
        t.eat("包子"); // 方法调用：方法名(实参)

        String s = t.say();
        System.out.println(s);
    }
}
