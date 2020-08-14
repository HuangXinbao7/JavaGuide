package com.atguigu.javase.exception;

/**
 * 写一个 ExceptionTest4 类，在其中声明int divide(int m, int n)方法，该方法可抛出IllegalNumberException异常。
 *      方法的两个参数分别为被除数和除数，返回值为商
 *      如果除数为0，则方法抛出 IllegalNumberException 异常
 * 改写main方法，调用divide方法计算商值打印输出，并捕获可能出现的异常。
 */
public class ExceptionTest4 {

    public static int divide (int m, int n) throws IllegalNumberException {
        if (n == 0) {
            throw new IllegalNumberException("除数为0 错误");
        }
        return m / n;
    }


    public static void main(String[] args) {

        try {
            System.out.println(divide(20, 5));
            System.out.println(divide(20, 0));
        } catch (IllegalNumberException e) {
            e.printStackTrace();
        }

        System.out.println("关键代码");

    }
}
