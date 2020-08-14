package com.atguigu.javase.wrapper;

import org.junit.Test;      // 导入测试类库

/**
 * 库：多个jar构成
 * jar：是罐子，里面保存的都是豆子（javabean）
 * 测试方法要求：所属的类必须是公共类，并且不要有任何构造器，方法必须公共非静态，无返回值，无参。
 *
 * 包装类：把基本数据包装成对象。面向对象，一切皆对象。
 * 所谓包装就是把基本值作为包装类对象的属性
 *
 * 装箱：把基本值装到对象中。
 *      new Xxxx(xxx);
 *      new Xxx("xxx");
 *      Xxx.valueOf(xxx);
 *      Xxx.valueOf("xxx");
 *
 * 拆箱：把包装类对象中的基本值取出来
 *      Xxx.parseXxx("xxx");
 *
 * 把字符串转换成基本值
 *      Xxx.parseXxx("xxx");
 * 把基本值转换成字符串
 *      "" + xxx;
 *      String.valueOf(xxx);
 */
public class WrapperTest {

    @Test
    public void test4() {
        // Boolean
        boolean b1 = false;
        Boolean obj1 = new Boolean(b1);
        Boolean obj2 = b1;

        String s = "true";
        boolean b2 = Boolean.parseBoolean(s);
        Boolean obj3 = new Boolean(s);

        obj1.booleanValue();    // 拆箱
        Long l = 23849234829384234L;
        Float f = 2.345F;
    }

    @Test
    public void test3() {
        // Double
        Double obj1 = new Double(2.34);
        Double obj2 = 9.33;

        double d1 = obj1.doubleValue();
        double d2 = obj2;

        String string = "123.456";
        double d3 = Double.parseDouble(string);
        Double obj3 = new Double(string);

        Double.valueOf(string);
    }

    /**
     * 声明两个字符串，内容是两个整数，把第1个转成基本类型的整数再装箱
     * 第2个直接把字符串变成包装类对象。
     * 使用手工拆箱求和，使用自动拆箱求积。
     */
    @Test
    public void exer1() {

        // 声明两个字符串，内容是两个整数，把第1个转成基本类型的整数再装箱
        String s1 = "1234";
        String s2 = "20";
        int i = Integer.parseInt(s1);   // 转成整型
        Integer obj1 = new Integer(i);  // 装箱

        // 第2个直接把字符串变成包装类对象
        Integer obj2 = new Integer(s2);

        // 使用手工拆箱求和，使用自动拆箱求积。
        int sum = obj1.intValue() + obj2.intValue();
        System.out.println(sum);

        int multi = obj1 * obj2;
        System.out.println(multi);
    }


    // 测试方法的使用
    @org.junit.Test
    public void test2() {
        System.out.println("test2");
        // 包装，创建包装类对象
        Integer obj1 = new Integer(100);    // 手工装箱
        Integer obj2 = 200;     // 自动装箱，编译器会变成Integer.valueOf(200)

        System.out.println(obj1);
        System.out.println(obj2);

        Object obj3 = 300;
        int n1 = obj1.intValue();   // 手工拆箱
        int n2 = obj2;      // 自动拆箱。编译器会变成：obj2.intValue();
    }


    // 测试方法的使用
    @Test
    public void test1() {
        System.out.println("test1");
    }



    //public static void main(String[] args) {}

    // 包装类用法举例
    public static void main5(String[] args) {

        // 装箱:包装类使得一个基本数据类型的数据变成了类。
        // 有了类的特点，可以调用类中的方法。
        int i = 500;
        Integer t = new Integer(i);

        String s = t.toString();    // s = "500", t 是类，有 toString() 方法
        String s1 = Integer.toString(314);  // s1 = "314", 将数字转换成字符串
        System.out.println(s1.length());        // 调用类的方法
        String s2 = "4.56";
        double ds = Double.parseDouble(s2);     // 将字符串转换成数字
        System.out.println(ds);


        // 拆箱:将数字包装类中内容变为基本数据类型
        int j = t.intValue();   // j = 500, intValue() 方法是取出包装类中的数据

        // 包装类在实际开发中应用得最多的在于字符串变为基本数据类型
        String str1 = "30";
        String str2 = "30.33";
        int x = Integer.parseInt(str1);     // 将字符串转换成 int 型
        float f = Float.parseFloat(str2);   // 将字符串转换成 float 型
    }

    // 基本数据类型转换成字符串
    public static void main4(String[] args) {

        // 调用字符串重载的 valueOf()方法
        String fStr = String.valueOf(2.34f);
        System.out.println(fStr);

        // 更直接的方式
        String intStr = 5 + "";
        System.out.println(intStr);
    }

    // 字符串转换成基本数据类型
    public static void main3(String[] args) {

        // 通过包装类的构造器实现
        int i = new Integer("12");
        System.out.println(i);

        // 通过包装类的 parseXxx（String s）静态方法
        Float f = Float.parseFloat("12.123");
        System.out.println(f);
    }

    // 拆箱
    public static void main2(String[] args) {

        Integer t3 = new Integer(1000);

        // 手动拆箱
        int i = t3.intValue();
        System.out.println(i);

        // 自动拆箱
        int ii = t3;
        System.out.println(ii);
    }

    // 装箱
    public static void main1(String[] args) {

        // 通过包装类的构造器实现
        int i = 100;
        Integer t1 = new Integer(i);
        Integer t2 = 500;

        System.out.println(t1);
        System.out.println(t1);

        // 通过字符串参数构造包装类对象
        Float f = new Float("4.56");
        Long l = new Long("asdf");      // 报错：NumberFormatException
    }
}
