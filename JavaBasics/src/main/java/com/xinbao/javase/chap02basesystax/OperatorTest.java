package com.xinbao.javase.chap02basesystax;

import org.junit.Test;

public class OperatorTest {

    /**
     * 运算符之六：三元运算符
     * 1.结构：(条件表达式) ? 表达式1 : 表达式2
     * 2.说明
     * 	条件表达式的结果为boolean类型
     *  根据条件表达式真或假，决定执行表达式1，还是表达式2
     *  	如果表达式为true，则执行表达式1。
     *   	如果表达式为false，则执行表达式2。
     *  表达式1和表达式2要求是一致的。
     *  三元运算符可以嵌套使用
     *
     * 3. 凡是可以使用三元运算符的地方，都可以改写为if-else
     * 反之，不成立。
     *
     * 4. 如果程序既可以使用三元运算符，又可以使用if-else结构，那么优先选择三元运算符。原因：简洁、执行效率高。
     */
    @Test
    public void TernaryOperatorTest() {
        // 获取两个整数的较大值
        int m = 12;
        int n = 5;
        int max = (m > n) ? m : n;
        System.out.println(max);

        double num = (m > n) ? 2 : 1.0;
        System.out.println(num);


        n = 12;
        // 三元运算符的嵌套使用
        String maxStr = (m > n)? "m大" : ((m == n)? "m和n相等" : "n大");
        System.out.println(maxStr);


        // 获取三个数的最大值
        int n1 = 10;
        int n2 = 20;
        int n3 = 30;

        int max1 = (n1 > n2) ? n1 : n2;
        int max2 = (max1 > n3) ? max1 : n3;
        System.out.println("三个数中的最大值为：" + max2);

        //不建议
        int max3 = (((n1 > n2)? n1 : n2) > n3)? ((n1 > n2)? n1 : n2) : n3;
        System.out.println("三个数中的最大值为：" + max3);

        //三元运算符转换为 if-else
        if(m > n){
            System.out.println(m);
        }else{
            System.out.println(n);
        }
    }


    /**
     * 运算符之五：位运算符（了解）
     *
     * 结论：
     * 1 位运算符操作的都是整型的数据
     * 2 <<：在一定范围内，每向左移1位，相当于 * 2
     *   >>：在一定范围内，每向右移1位，相当于 / 2
     */
    public void BitOperatorTest() {
        int i = 2;
        System.out.println("i << 2 ==> " + (i << 2));
        System.out.println("i << 3 ==> " + (i << 3));
        System.out.println("i << 9 ==> " + (i << 9));

        int m = 12;
        int n = 5;
        System.out.println("m & ==> " + (m & n));
        System.out.println("m | ==> " + (m | n));
        System.out.println("m ^ ==> " + (m ^ n));


        // 练习：交换两个变量的值
        int num1 = 10;
        int num2 = 20;
        System.out.println("num1 = " + num1 + ", num2 = " + num2);

        // 方式一：定义临时变量的方式
        // 推荐的方式
        int temp = num1;
        num1 = num2;
        num2 = temp;

        // 方式二：好处：不用定义临时变量
        // 弊端：① 相加操作可能超出存储范围 ② 有局限性：只能适用于数值类型
        //num1 = num1 + num2;
        //num2 = num1 - num2;
        //num1 = num1 - num2;

        //方式三：使用位运算符
        //有局限性：只能适用于数值类型
        //num1 = num1 ^ num2;
        //num2 = num1 ^ num2;
        //num1 = num1 ^ num2;

        System.out.println("num1 = " + num1 + ", num2 = " + num2);
    }


    /**
     * 运算符之四：逻辑运算符
     * & && | || ! ^
     *
     * 说明：
     * 1.逻辑运算符操作的都是boolean类型的变量
     */
    public void LogicalOperatorTest() {

        //区分& 与 &&
        //相同点1：& 与  && 的运算结果相同
        //相同点2：当符号左边是true时，二者都会执行符号右边的运算
        //不同点：当符号左边是false时，&继续执行符号右边的运算。&&不再执行符号右边的运算。
        //开发中，推荐使用&&
        boolean b = false;
        int num1 = 10;
        if(b & (num1++ > 0)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        System.out.println("num1 = " + num1);

        int num2 = 10;
        if(b && (num2++ > 0)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        System.out.println("num2 = " + num2);


        // 区分| 与 ||
        //相同点1：| 与 || 的运算结果相同
        //相同点2：当符号左边是false时，二者都会执行符号右边的运算
        //不同点3：当符号左边是true时，|继续执行符号右边的运算，而||不再执行符号右边的运算
        //开发中，推荐使用||
        boolean b2 = true;
        int num3 = 10;
        if(b2 | (num3++ > 0)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        System.out.println("num3 = " + num3);


        boolean b4 = true;
        int num4 = 10;
        if(b4 || (num4++ > 0)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        System.out.println("num4 = " + num4);
    }


    /**
     * 运算符之三：比较运算符
     * ==  !=  >  <  >= <=  instanceof
     *
     * 结论：
     * 1.比较运算符的结果是boolean类型
     * 2.区分 ==  和  =
     */
    @Test
    public void CompareTest() {

        int i = 10;
        int j = 20;

        System.out.println(i == j);//false
        System.out.println(i = j);//20

        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b2 == b1);//false
        System.out.println(b2 = b1);//true
    }



    /**
     * 运算符之二：赋值运算符
     * = += -= *= /= %=
     */
    @Test
    public void AssigningOperatorTest() {
        // 赋值符号：=
        //int n1 = 10;

        // 连续赋值
        int i2, j2;
        i2 = j2 = 10;
        int i3 = 10, j3 = 20;

        // +=
        int num1 = 10;
        num1 += 2; 					// num1 = num1 + 2;
        System.out.println(num1);	//12

        // %=
        int num2 = 10;
        num2 %= 5;					// num2 = num2 % 5;
        System.out.println(num2);

        short s1 = 10;
        //s1 = s1 + 2;	//编译失败
        s1 += 2;		//结论：不会改变变量本身的数据类型
        System.out.println(s1);


        //开发中，如果希望变量实现+2的操作，有几种方法？(前提：int num = 10;)
        //方式一：num = num + 2;
        //方式二：num += 2; (推荐)

        //开发中，如果希望变量实现+1的操作，有几种方法？(前提：int num = 10;)
        //方式一：num = num + 1;
        //方式二：num += 1;
        //方式三：num++; (推荐)


        // 练习1
        int i = 1;
        i *= 0.1;
        System.out.println(i);	// 0
        i++;
        System.out.println(i);	// 1

        // 练习2
        int m = 2;
        int n = 3;
        n *= m++; // n = n * m++;
        System.out.println("m=" + m);	// 3
        System.out.println("n=" + n);	// 6

        // 练习3
        int n1 = 10;
        n1 += (n1++) + (++n1);	//n1 = n1 + (n1++) + (++n1);
        System.out.println(n1);	//32
    }



    /**
     * 运算符之一：算术运算符
     */
    @Test
    public void ArithmeticOperatorTest() {

        // 除号
        int num1 = 12;
        int num2 = 5;
        int result1 = num1 / num2;
        System.out.println(result1);    // 2
        int result2 = num1 / num2 * num2;
        System.out.println(result2);    // 10
        double result3 = num1 / num2;
        System.out.println(result3);    // 2.0

        double res4 = num1 / num2 + 0.0;        // 2.0
        double res5 = num1 / (num2 + 0.0);      // 2.4
        double res6 = (double)num1 / num2;      // 2.4
        double res7 = (double)(num1 / num2);    // 2.0


        /**
         * %：取余
         * 结果的符号与被模数的符号相同
         * 开发中，经常使用%来判断能否被除尽的情况。
         */
        int m1 = 12;
        int n1 = 5;
        System.out.println("m1 % n1 = " + m1 % n1);

        int m2 = -12;
        int n2 = 5;
        System.out.println("m2 % n2 = " + m2 % n2);

        int m3 = 12;
        int n3 = -5;
        System.out.println("m3 % n3 = " + m3 % n3);

        int m4 = -12;
        int n4 = -5;
        System.out.println("m4 % n4 = " + m4 % n4);


        /**
         * 自增自减运算
         * (前)++ :先自增1，后运算
         * (后)++ :先运算，后自增1
         */
        int a1 = 10;
        int b1 = ++a1;
        System.out.println("a1 = " + a1 + ",b1 = " + b1);

        int a2 = 10;
        int b2 = a2++;
        System.out.println("a2 = " + a2 + ",b2 = " + b2);

        int a3 = 10;
        ++a3;//a3++;
        int b3 = a3;

        //注意点：
        short s1 = 10;
        //s1 = s1 + 1;//编译失败
        //s1 = (short)(s1 + 1);//正确的
        s1++;//自增1不会改变本身变量的数据类型
        System.out.println(s1);

        //问题：
        byte bb1 =127;
        bb1++;
        System.out.println("bb1 = " + bb1);

        //(前)-- :先自减1，后运算
        //(后)-- :先运算，后自减1
        int a4 = 10;
        int b4 = a4--;//int b4 = --a4;
        System.out.println("a4 = " + a4 + ",b4 = " + b4);
    }
}
