package day03;

/*
* 思考题
* */
public class AriExer3 {
    public static void main(String[] args){

        // 思考1
        short s1 = 3;
        //s1 = s1 + 2;  // 编译失败
        s1 += 2;        // 编译正常
        System.out.println(s1);

        // 思考2
        int i = 1;
        i *= 0.1;
        // short类型的数0.1自动提升为int型的数值0，i * 0 的结果是0
        System.out.println(i);  // 0
        i++;
        System.out.println(i);  // 1

        // 思考3
        int m = 2;
        int n = 3;
        n *= m++;       // n = n * m++
        System.out.println("m = " + m);     // m = 3
        System.out.println("n = " + n);     // n = 6


        // 思考4
        int n4 = 10;
        /*
        * 这是个复杂的运算，很容易出错
        * 第一个小括号（）的运算结果是10，此时n4的值等于11,
        * 第二个小括号（）的运算结果在n4=11的基础上先自增1，即此时n4的值等12
        * 而赋值运算符左边的操作数 n4 的值等于初始值 10
        * 所以这个赋值运算可以等价于：
        * n4 = n4 + (n4++) + (++n4) 即：
        * n4 = 10 + 10 + 12
        * 所以，n4 = 32
        * */
        n4 += (n4++) + (++n4);
        System.out.println(n4);     // 32
    }
}
