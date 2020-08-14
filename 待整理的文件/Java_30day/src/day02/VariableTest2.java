package day02;

/**
 * 基本数据类型之间的运算规格（不包含boolean类型）：
 * 1.自动类型升级：
 *     当容量小的数据类型变量与容量大的数据类型的变量做运算时，结果自动提升为容量大的数据类型
 *     特别的：当byte、char、short三种类型的变量做运算时，首先转换为int类型
 *
 * 2.强制类型转换：见VariableTest3.java
 *
 * 说明：此时的容量大小指的是，表示数的范围的大和小。比如：float容量要大于long的容量
 */
public class VariableTest2 {
    public static void main(String[] args){
        byte b1 = 2;
        int i1 = 129;
        // 编译不通过
        //byte b2 = b1 + i1;
        int i2 = b1 + i1;
        long l1 = b1 + i1;
        System.out.println(i2);     // 131
        System.out.println(l1);     // 131

        float f = b1 + i1;
        System.out.println(f);      // 131.0

        short s1 = 123;
        double d1 = s1;
        System.out.println(d1);     // 123.0

        //***************特别地*********************
        char c1 = 'a';      // 97
        int i3 = 10;
        int i4 = c1 + i3;
        System.out.println(i4);     // 107

        short s2 = 10;
        //char c3 = c1 + s2;    // 编译不通过

        byte b2 = 10;
        //char c4 = c1 + b2;    // 编译不通过
    }
}
