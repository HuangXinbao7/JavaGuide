package com.atguigu.javase.exception;

/**
 * 异常：在运行时出现的非正常状况，会导致程序崩溃。
 */

// 自定义异常
// 让它继承 Exception，提供2个构造器：一个 String 参数，一个 Throwable 参数
class DividedByZeroException extends Exception {    // 受检异常：必须接受检查处理的异常

    public DividedByZeroException(String message) {
        super(message);     // 最终或追溯到 Throwable
    }

    public DividedByZeroException(Throwable cause) {
        super(cause);       // 最终或追溯到 Throwable
    }
}


public class ExceptionTest {

    // 方法签名必须加上 throws DividedByZeroException
    // throws的作用是提醒可能抛出异常
    public static int divide3(int x, int y) throws DividedByZeroException{
        if (y == 0) {
            // 对于受检异常
            // 如果方法体中有 throw，签名中必须要有 throws
            // 如果签名中有 throws，方法体中不一定需要有 throw
            throw new DividedByZeroException("除数不可以为0 错误！");
        }
        int z = x / y;
        return z;
    }

    // 主方法不要抛出异常，因为它一旦出现问题，栈就废了
    //public static void main(String[] args) throws DividedByZeroException {
    public static void main(String[] args) {
        System.out.println("main begin");

        // 处理受检异常: 在 main 关键字后添加 throws DividedByZeroException，但是不推荐这样使用
        // 捕获异常
        try {
            System.out.println(divide3(10, 5));
            System.out.println(divide3(10, 0));
        } catch (DividedByZeroException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("main end");
    }

    public static int divide(int x, int y) {
        if(y == 0) {
            RuntimeException re = new RuntimeException("除数不可以为0 错误！");
            throw re;   // throw 一旦执行，相当于 return，但是它是带着破坏性的返回
        }
        return x / y;
    }

    public static void main2(String[] args) {
        System.out.println("main begin");

        try {
            //System.out.println(divide(10, 5));
            System.out.println(divide(10, 0));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("main end");     // 不捕获异常，后面的核心代码不能被执行
    }

    public static void main1(String[] args) {
        System.out.println("main begin");

        // ArrayIndexOutOfBoundsException: 0    未传入任何参数就直接执行，保索引越界错误
        // NumberFormatException: For input string: "xx"    输入的参数数据类型不能转换成整数类型
        /**
         * 输入的参数：
         * 164  正常
         * abc  NumberFormatException
         *      ArrayIndexOutOfBoundsException
         */
        int n = Integer.parseInt(args[0]);  // 把命令参数中的第一个字符串转换成真正的整数
        System.out.println("n: " + n);

        System.out.println("main end");
    }
}
