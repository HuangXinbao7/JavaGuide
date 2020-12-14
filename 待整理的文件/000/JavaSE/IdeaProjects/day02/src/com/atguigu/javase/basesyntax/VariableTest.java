package com.atguigu.javase.basesyntax;


import org.junit.Test;

public class VariableTest {


    @Test
    public void test3(){

        byte b1 = 10;
        short s1 = 20;
        int i1 = 30;

        // 任意的long型的整数做匀运算，总是升级为int型
        //s1 = b1 + s1;
        //s1 = (short)b1 + (short)s1;     // 这样也不行
        s1 = (short)(b1 + s1);  // 必须将运算结果转换成short型
        s1 = 20 + 50;   // 右侧如果是常量，编译器是能确定的，所以不用变量类型提升

        long l1 = 40L;
        // 不同类型的变量混合运算，结果总是升级成范围最大的那个数据类型
        // 右侧相当于是3个long型在做运算，结果肯定是 long型
        //i1 = l1 * b1 * s1;
        i1 = (int)l1 * b1 * s1;
        i1 = (int)(l1 * b1 *  s1);

        float f1 = 1.23F;
        double d1 = 2.34D;

        // 不可以，float类型的范围比long型的大，需要强制转换
        //l1 = f1 + l1;
        l1 = (long)(f1 + l1 + b1);
        d1 = d1 * s1 * l1;

    }


    /**
     * 变量声明
     */
    @Test
    public void test2() {

        // 变量声明：数据类型 变量名
        int i1;
        i1 = 100;
        System.out.println(i1);

        int i2 = i1;    // 变量声明的同时赋值
        System.out.println(i2);

        i1 = i1 * i2;
        System.out.println(i1);
    }


    /**
     * 基本数据类型
     *
     * 常量：内容不可修改的量，包括字面量和final修饰的量
     * 赋值符号左边永远是变量
     */
    @Test
    public void test1() {

        // n是变量，100是值，其数据类型是int型
        int n = 100;

        // 整数字面量永远是 int 型
        byte b1 = 10;
        short s1 = 20;  // 编译器优化，20这个常量在short范围内，如果超出 short的范围则无法优化
        short s2 = s1;  // 编译器无法判断变量中的值，因此无法优化

        int i1 = 30;    // 右侧是整数字面量，是用int型4字节保存
        long l1 = 40;    // 右侧是整数字面量，是用int型4字节保存

        //long l2 = 50000000000;     // 右侧的字面量尝试用4字节int来保存，但是存不下，所以报错。
        long l3 = 500000000000L;    // 后缀L的作用是告诉编译器，此字面量用8字节的long存储

        // 浮点数字面量默认数据类型是 double 型
        double d1 = 1.23D;

        float f1 = (float)2.34;     // 浮点数不进行优化
        float f2 = 2.34F;   // F的作用是告诉编译器，此字面量使用4字节的float型来保存

        f1 = i1;    // float 型的范围比int型大，可以写入
        i1 = (int)f1;   // 范围大的量值赋值给范围小的，需要强制转换
        l1 = (short)f1;     //
    }
}
