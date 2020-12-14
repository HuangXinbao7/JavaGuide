package com.atguigu.javase.generic;

import org.junit.Test;

/**
 * Java泛型基础
 */
public class GenericBase {


    /**
     * 泛型方法：就像类型声明，方法的声明也可以被泛型化 —— 带有一个或者多个类型参数。
     *
     * 写一个方法，用一个Object的数组和一个collection作为参数，
     * 完成把数组中所有object放入collection中的功能
     */
    // 可以使用任意集合来调用这个方法，只要其元素的类型是数组的元素类型的父类。
    static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for(T o: a) {
            //c.add(o);   // 编译器报错
            c.add(o);
        }
    }

    @Test
    public void test5() {
        Object[] oa = new Object[100];
        Collection<Object> co = new ArrayList<Object>();
        fromArrayToCollection(oa, co);  // T 指 Object

        String[] sa = new String[20];
        Collection<String> cs = new ArrayList<String>();
        fromArrayToCollection(sa, cs);  // T 指 String
        fromArrayToCollection(sa, co);  // T 指 Object

        Integer[] ia = new Integer[100];
        Float[] fa = new Float[100];
        Number[] na = new Number[100];
        Collection<Number> cn = new ArrayList<Number>();

        // T 指 Integer类，cn是Number类，可以赋值成功
        fromArrayToCollection(ia, cn);

        // T 指 Float 类，cn是 Number 类，可以赋值成功
        fromArrayToCollection(fa, cn);

        // T 指 Number 类，cn是 Number 类，可以赋值成功
        fromArrayToCollection(na, cn);

        // T 指 Float 类，co 是 Object 类，可以赋值成功
        fromArrayToCollection(na, co);

         //T 指 Number 类，cs 是 String 类，编译报错
        //fromArrayToCollection(na, cs);
    }


    /**
     * 考虑一个简单的画图程序，它可以花各种图形，比如矩形和圆形。
     * 为了在程序中表示这些形状，可以定义如下的类继承结构
     * */
    public abstract class Shape{
        public abstract void draw(Canvas c);
    }


    /**
     * 圆
     */
    public class Circle extends Shape {

        private int x, y, radius;

        @Override
        public void draw(Canvas c) {
            //...
        }
    }


    /**
     * 矩形
     */
    public class Rectangle extends Shape {

        private int x, y, width, height;

        @Override
        public void draw(Canvas c) {
            //...
        }
    }

    /**
     * 定义一个画布
     */
    public class Canvas {
        public void draw(Shape s) {
            s.draw(this);
        }
    }

    public void drawAll(List<? extends Shape> shapes){
        for(Shape s: shapes){
            s.draw(new Canvas());
        }
    }


    /**
     * 泛型的通配符
     * 实例：考虑写一个程序来打印一个集合中的所有元素
     */
    // Collection<?> 发音为 collection of unknown
    public void printCollection(Collection<?> c) {
        for(Object e: c) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    @Test
    public void test4() {

        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++) {
            list.add((int)(Math.random() * 100));
        }
        printCollection(list);
    }



    /**
     * 定义简单的泛型
     * 类型参数在整个类的声明中可用，几乎是所有可以使用其他普通类型的地方
     * 当一个泛型声明被调用，实际类型参数取代形式类型参数
     *
     * 一个命名的习惯：推荐使用简练的名字作为形式类型参数的名字（可以是单个字符）。最后避免小写字母
     */
    @Test
    public void test3() {
        Set<Integer> set = new HashSet<Integer>();
    }


    /**
     * test1 的泛型版本
     */
    @Test
    public void test2() {
        // List<Integer>：List是一个带一个类型参数的泛型接口。本例中的类型参数是 Integer
        List<Integer> myIntList = new ArrayList<Integer>();       // 创建一个List集合对象
        myIntList.add(new Integer(100));    // 添加一个整数

        // 有了泛型的约束，这里就不需要进行类型转换了
        // 泛型的类型参数取代了类型转换
        Integer i = myIntList.iterator().next();
        System.out.println(i);
    }


    /**
     * 没有使用泛型的典型用法
     */
    @Test
    public void test1() {
        List myIntList = new ArrayList();       // 创建一个List集合对象
        System.out.println(myIntList);
        System.out.println(myIntList.size());

        myIntList.add(new Integer(100));    // 添加一个整数
        System.out.println(myIntList.get(0));   // 打印

        // 这一行的类型转换有些繁琐。
        // 通常情况下，程序员知道一个特定的 list 里边放的是什么类型的数据。
        // 但是，这个类型转换是必须的（essential，必要的。不能省略）
        // 编译器只能保证 iterator 返回的是 Object类型。
        // 为了保证对 Integer 类型变量赋值的类型安全，必须进行类型转换
        Integer i = (Integer)myIntList.iterator().next();
        System.out.println(i);
    }
}
