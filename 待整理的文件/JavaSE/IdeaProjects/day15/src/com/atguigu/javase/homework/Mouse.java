package com.atguigu.javase.homework;


public class Mouse extends Device implements USB {

    public Mouse() {
    }

    public Mouse(int ID, String name) {
        super(ID, name);
    }

    @Override
    public void startup() {
        System.out.println("开机~");
    }

    @Override
    public void shutdown() {
        System.out.println("关机~");
    }

    @Override
    public void connect() {
        System.out.println("U盘正在连接");
    }

    @Override
    public void work() {
        System.out.println("U盘已连接，正在工作中");
    }

    @Override
    public void disconnect() {
        System.out.println("断开U盘连接");
    }
}