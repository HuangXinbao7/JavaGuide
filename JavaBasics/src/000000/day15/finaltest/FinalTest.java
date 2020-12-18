package com.atguigu.javase.finaltest;

/**
 * final 修饰类，表明这个类是终极类，不允许被子类扩展，不能被继承
 * final 修饰方法，表明这个方法是终极方法，不允许子类重写
 * final 修饰变量，表明这个变量是个终极量，它必须赋值唯一的一次。不赋值不行，多次赋值也不行
 *
 * public static final： 修饰的量，称为全局常量，典型的是 Math.PI
 */
public final class FinalTest {

    public static int totalNumber = 5;
    public final int ID;    // 必须赋值一次
    public FinalTest() {
        ID = ++totalNumber; // 可在构造方法中给final变量赋值
    }

    public static void main (String[] args) {
        FinalTest ft = new FinalTest();
        System.out.println(ft.ID);  // 6

        final int I = 10;   // 声明一个常量 I，立即赋值
        final int J;        // 声明一个常量 J，不赋值
        J = 20;
        //J = 30; // 报错，提示已经被赋值过，不能重复赋值
    }
}
