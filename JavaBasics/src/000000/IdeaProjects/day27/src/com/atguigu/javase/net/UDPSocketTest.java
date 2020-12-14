package com.atguigu.javase.net;

import org.junit.Test;

import java.io.IOException;

/**
 *
 */
public class UDPSocketTest {

    /**
     * 发送端
     */
    @Test
    public void server01() throws IOException {
        // 创建数据报套接字对象
        DatagramSocket datagramSocket = new DatagramSocket();
        // 产生一些数据
        byte[] bytes = "hello, atguigu.com".getBytes();
        // 建立数据包，封装UDP数据报
        DatagramPacket datagramPacket = new DatagramPacket(
                bytes, 0, bytes.length,
                InetAddress.getByName("localhost"),
                9999);

        // 发送数据包
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }


    @Test
    public void client01() throws IOException {
        // 创建数据报套接字对象
        DatagramSocket ds = new DatagramSocket(9999);
        // 创建空的字节数组，用于接收数据
        byte[] by = new byte[1024];
        DatagramPacket dp = new DatagramPacket(by, by.length);
        ds.receive(dp);

        //String string = new String("f");
        System.out.println(dp);
    }
}
