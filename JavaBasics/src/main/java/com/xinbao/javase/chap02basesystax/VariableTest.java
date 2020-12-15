package com.xinbao.javase.chap02basesystax;


import org.junit.Test;

public class VariableTest {

    @Test
    public void test08() {
        //1. 整型：byte(1字节=8bit) \ short(2字节) \ int(4字节) \ long(8字节)
        //① byte范围：-128 ~ 127
        //
        byte b1 = 12;
        byte b2 = -128;
        //b2 = 128;//编译不通过
        System.out.println(b1);
        System.out.println(b2);

        // ② 声明long型变量，必须以"l"或"L"结尾
        // ③ 通常，定义整型变量时，使用int型。
        short s1 = 128;
        int i1 = 1234;
        long l1 = 3414234324L;
        System.out.println(l1);

        //2. 浮点型：float(4字节) \ double(8字节)
        //① 浮点型，表示带小数点的数值
        //② float表示数值的范围比long还大

        double d1 = 123.3;
        System.out.println(d1 + 1);
        //③ 定义float类型变量时，变量要以"f"或"F"结尾
        float f1 = 12.3F;
        System.out.println(f1);
        //④ 通常，定义浮点型变量时，使用double型。

        //3. 字符型：char (1字符=2字节)
        //① 定义char型变量，通常使用一对'',内部只能写一个字符
        char c1 = 'a';
        //编译不通过
        //c1 = 'AB';
        System.out.println(c1);

        char c2 = '1';
        char c3 = '中';
        char c4 = 'ス';
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);

        //② 表示方式：1.声明一个字符 2.转义字符 3.直接使用 Unicode 值来表示字符型常量
        char c5 = '\n';//换行符
        c5 = '\t';//制表符
        System.out.print("hello" + c5);
        System.out.println("world");

        char c6 = '\u0043';
        System.out.println(c6);

        //4.布尔型：boolean
        //① 只能取两个值之一：true 、 false
        //② 常常在条件判断、循环结构中使用
        boolean bb1 = true;
        System.out.println(bb1);

        boolean isMarried = true;
        if(isMarried){
            System.out.println("你就不能参加\"单身\"party了！\\n很遗憾");
        }else{
            System.out.println("你可以多谈谈女朋友！");
        }
    }


    /**
     * 编码
     */
    @Test
    public void test07() {
        //1.编码情况1：
        long l = 123213;
        System.out.println(l);
        //编译失败：过大的整数
        //long l1 = 21332423235234123;
        long l1 = 21332423235234123L;


        //****************
        //编译失败
        //float f1 = 12.3;
        float f1 = (float)12.3;
        //2.编码情况2：
        //整型常量，默认类型为int型
        //浮点型常量，默认类型为double型
        byte b = 12;
        //byte b1 = b + 1;//编译失败

        //float f1 = b + 12.3;//编译失败
    }


    /**
     * 强制类型转换：自动类型提升运算的逆运算。
     * 1.需要使用强转符：()
     * 2.注意点：强制类型转换，可能导致精度损失。
     */
    @Test
    public void test06() {
        double d1 = 12.9;
        //精度损失举例1
        int i1 = (int)d1;//截断操作
        System.out.println(i1);

        //没有精度损失
        long l1 = 123;
        short s2 = (short)l1;

        //精度损失举例2
        int i2 = 128;
        byte b = (byte)i2;
        System.out.println(b);//-128
    }


    /**
     * 基本数据类型之间的运算规则：
     * 前提：这里讨论只是7种基本数据类型变量间的运算。不包含boolean类型的。
     * 1. 自动类型提升：
     *     结论：当容量小的数据类型的变量与容量大的数据类型的变量做运算时，结果自动提升为容量大的数据类型。
     * 	byte 、char 、short --> int --> long --> float --> double
     *
     * 	特别的：当byte、char、short三种类型的变量做运算时，结果为int型
     *
     * 2. 强制类型转换：见VariableTest3.java
     *
     *
     * 说明：此时的容量大小指的是，表示数的范围的大和小。比如：float容量要大于long的容量
    */
    @Test
    public void test05() {
        byte b1 = 2;
        int i1 = 129;
        //编译不通过
        //byte b2 = b1 + i1;
        int i2 = b1 + i1;
        long l1 = b1 + i1;
        System.out.println(i2);

        float f = b1 + i1;
        System.out.println(f);

        short s1 = 123;
        double d1 = s1;
        System.out.println(d1);//123.0

        //***************特别地*********************
        char c1 = 'a';//97
        int i3 = 10;
        int i4 = c1 + i3;
        System.out.println(i4);

        short s2 = 10;
        //char c2  = c1 + s2;//编译不通过

        byte b2 = 10;
        //char c3 = c1 + b2;//编译不通过

        //short s3 = b2 + s2;//编译不通过

        //short s4 = b1 + b2;//编译不通过
        //****************************************
    }


    /**
     * 不同类型之间的转换
     */
    @Test
    public void test04(){

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
     * 变量的使用
     * 1. java定义变量的格式：数据类型 变量名 = 变量值;
     *
     * 2. 说明：
     *    变量必须先声明，后使用
     *    变量都定义在其作用域内。在作用域内，它是有效的。换句话说，出了作用域，就失效了
     *    同一个作用域内，不可以声明两个同名的变量
     */
    @Test
    public void test03() {
        //变量的定义
        int myAge = 12;
        //变量的使用
        System.out.println(myAge);

        //编译错误：使用myNumber之前并未定义过myNumber
        //System.out.println(myNumber);

        //变量的声明
        int myNumber;

        //编译错误：使用myNumber之前并未赋值过myNumber
        //System.out.println(myNumber);

        //变量的赋值
        myNumber = 1001;
        //编译不通过
        //System.out.println(myClass);

        //不可以在同一个作用域内定义同名的变量
        //int myAge = 22;
    }

    /**
     * 变量声明
     */
    @Test
    public void test02() {

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
     * 常量：内容不可修改的量，包括字面量和final修饰的量
     * 赋值符号左边永远是变量
     */
    @Test
    public void test01() {

        // n是变量，100是值，其数据类型是int型
        int n = 100;

        // 整数字面量永远是 int 型
        byte b1 = 10;
        short s1 = 20;      // 编译器优化，20这个常量在short范围内，如果超出 short的范围则无法优化
        short s2 = s1;      // 编译器无法判断变量中的值，因此无法优化

        int i1 = 30;        // 右侧是整数字面量，是用int型4字节保存
        long l1 = 40;       // 右侧是整数字面量，是用int型4字节保存

        //long l2 = 50000000000;        // 右侧的字面量尝试用4字节int来保存，但是存不下，所以报错。
        long l3 = 500000000000L;        // 后缀L的作用是告诉编译器，此字面量用8字节的long存储

        // 浮点数字面量默认数据类型是 double 型
        double d1 = 1.23D;

        float f1 = (float)2.34;     // 浮点数不进行优化
        float f2 = 2.34F;           // F的作用是告诉编译器，此字面量使用4字节的float型来保存

        f1 = i1;            // float 型的范围比int型大，可以写入
        i1 = (int)f1;       // 范围大的量值赋值给范围小的，需要强制转换
        l1 = (short)f1;     //
    }
}
