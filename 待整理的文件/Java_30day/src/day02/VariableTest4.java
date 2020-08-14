package day02;


public class VariableTest4 {
    public static void main(String[] args){

        // 1.编码情况1
        long l1 = 123456;
        System.out.println(l1);
        // 编译失败：过大的整数
        //long l2 = 123456789123456789;
        long l2 = 123456789123456789L;

        // 编译失败
        //float f1 = 12.3;
        float f1 = (float)12.3;

        // 2.编码情况2
        // 整型常量，默认类型为int型
        // 浮点型常量，默认类型为double型
        byte b = 12;
        // 编译失败, 1为int型
        //byte b1 = b + 1;
        // 编译失败, 12.3为double型
        //float f2 = b + 12.3;
    }
}
