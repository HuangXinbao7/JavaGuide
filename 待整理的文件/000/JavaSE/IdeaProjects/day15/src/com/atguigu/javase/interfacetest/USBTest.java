package com.atguigu.javase.interfacetest;

public class USBTest {

    public static void main(String[] args) {
        USB usb = new UDisk();
        usb.connect();
        usb.work();
        usb.disconnect();
    }
}
