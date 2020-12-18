package com.atguigu.javase.exception;

/**
 * 自定义异常：第一步：继承自 Exception; 第二部：提供2个构造器
 */
public class MyException extends Exception {

    public MyException() {}

    public MyException(String message) {
        super(message);
    }

    public MyException(Throwable cause) {
        super(cause);
    }
}
