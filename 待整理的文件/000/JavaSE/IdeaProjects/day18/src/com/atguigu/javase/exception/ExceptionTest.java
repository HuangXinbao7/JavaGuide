package com.atguigu.javase.exception;

/**
 * 异常处理
 * 1 捕获
 * 2 抛出
 * 3 捕获后再抛出：在实际项目开发中用此方法最多。便于所有异常统一处理
 *
 * 选择：什么时候捕获，什么时候抛出？
 *      被调用的方法（它的异常不影响栈）应该抛出，目的是及时要给调用者一个异常信号；
 *      入口方法（决定栈的存留的方法。如：主线程方法main和子线程方法run）中应该使用捕获，因为一旦它出现异常，会导致栈作废。
 */
public class ExceptionTest {

    // 受检异常必须使用 throws MyException
    public static int divide(int x, int y) throws MyException {
        try{
            return x / y;
        } catch(ArithmeticException e) {
            MyException me = new MyException(e);    // 把已知异常包装到自定义异常类
            throw me;   // 抛出
        }
    }

    public static void main(String[] args) {
        try{
            System.out.println(divide(10, 0));
        } catch(MyException e) {
            e.printStackTrace();
        }
    }
}
