package com.atguigu.team.service;

// 自定义异常：继承，构造器
public class TeamException extends Exception{

    public TeamException(String message) {
        super(message);
    }

    public TeamException(Throwable cause) {
        super(cause);
    }
}
