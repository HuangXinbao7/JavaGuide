package com.atguigu.javase.interfacetest;

public class UDisk implements USB {

    @Override
    public void connect() {
        System.out.println("U盘连接, 识别容量....");
    }

    @Override
    public void work() {
        System.out.println("U盘数据复制中.....");
    }

    @Override
    public void disconnect() {
        System.out.println("U盘拔出..");
    }
}
