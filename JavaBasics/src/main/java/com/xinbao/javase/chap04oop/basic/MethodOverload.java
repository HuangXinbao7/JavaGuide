package com.xinbao.javase.chap04oop.basic;

/**
 * 方法的重载（overload）
 *  1.定义：在同一个类中，允许存在一个以上的同名方法，只要它们的参数个数或者参数类型不同即可。
 *      "两同一不同":
 *          同一个类、相同方法名
 *          参数列表不同：参数个数不同或参数类型不同
 *  2.举例：
 *      Arrays类中重载的sort() / binarySearch()
 *  3.判断是否是重载：
 *      跟方法的权限修饰符、返回值类型、形参变量名、方法体都没有关系！
 *  4.在通过对象调用方法时，如何确定某一个指定的方法：
 *      方法名 ---> 参数列表
 */
public class MethodOverload {
    public static void main(String[] args) {
        MethodOverload overload = new MethodOverload();

        overload.printArg(1,2);
        overload.printArg(1.1, 2.2);
        overload.printArg("abc", 2);
        overload.printArg(1, "ddd");
    }

    // 如下的4个方法构成了重载
    public void printArg(int i, int j){
        System.out.println(i + "\t" + j);
    }

    public void printArg(double d1, double d2){
        System.out.println(d2 + "\t" + d2);
    }

    public void printArg(String s , int i){
        System.out.println(s + "\t" + i);
    }

    public void printArg(int i, String s){
        System.out.println(i + "\t" + s);
    }
}
