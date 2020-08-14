package com.atguigu.javase.net;

import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 网络编程实例
 */
public class NetTest {


    /**
     * 实例：上传文件
     * 从客户端发送文件给服务端，服务端接收文件并保存到本地。
     * 并返回“接收成功”给客户端，并关闭相应的连接。
     * File1 --(fis)--> Client --(nos, nis)--> Server --(fos)--> File2
     *                  Client <--(nos, nis)-- Server
     */
    @Test
    public void server2() throws IOException {
        ServerSocket serverSocket = new ServerSocket(7777);
        Socket accept = serverSocket.accept();

        // 获取字节输入流，用于接收客户端发送过来的消息
        InputStream nis = accept.getInputStream();
        // 创建文件输出流对象，用于向本地写入文件
        FileOutputStream fos = new FileOutputStream("2020-04-25-copy.png");
        // 获取字节输出流并封装成缓冲字符输出流，用于给客户端发送消息
        BufferedWriter nos = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));

        byte[] buf = new byte[8192];    // 创建数组缓冲区
        int len;
        // 从 nis 中每次读取buf大小的数据，最后一次有可能读不满buf
        while ((len = nis.read(buf)) != -1) {
            // 将读到的文件写入本地
            fos.write(buf, 0, len);
        }

        // 向客户端发送消息
        nos.write("接收成功");
        nos.newLine();
        nos.flush();

        // 关闭所有资源
        nos.close();
        fos.close();
        nis.close();
        accept.close();
        serverSocket.close();
    }


    /**
     * 实例：上传文件
     */
    @Test
    public void client2() throws IOException {
        // 创建套接字
        Socket socket2 = new Socket("localhost", 7777);
        // 创建文件输入流，用于读取本地文件
        FileInputStream fis = new FileInputStream("2020-04-25.png");
        // 从套接字获取字节输出流，用于向流中写入数据
        OutputStream nos = socket2.getOutputStream();
        // 获取字节输入流并封装成缓冲字符输入流，用于接收服务端传回的反馈消息
        BufferedReader nis = new BufferedReader(new InputStreamReader(socket2.getInputStream()));

        // 发送文件，以文件为准
        byte[] buf = new byte[8192];
        int len;
        // 从文件输入流中读取buf大小的数据
        while((len = fis.read(buf)) != -1) {
            // 向字节输出流中写入数据
            nos.write(buf, 0, len);
        }
        // 给服务器一个停止信号
        socket2.shutdownOutput();

        String s = nis.readLine();
        System.out.println(s);

        nis.close();
        nos.close();
        fis.close();
        socket2.close();
    }


    @Test
    public void server() throws IOException {
        // 在本机绑定端口 6666
        ServerSocket server = new ServerSocket(6666);
        // 监听客户端的请求
        Socket socket1 = server.accept();
        System.out.println(socket1);

        // 获取字节输入流
        InputStream inputStream = socket1.getInputStream();
        // 将字节输入流封装成缓冲字符输入流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        // 从流中读取数据
        String s = bufferedReader.readLine();
        System.out.println(s);

        bufferedReader.close();
        socket1.close();
        server.close();
    }


    /**
     *
     * @throws IOException
     */
    @Test
    public void client() throws IOException {
        Socket socket2 = new Socket("localhost", 6666);
        System.out.println(socket2);

        // 获取字节输出流
        OutputStream outputStream = socket2.getOutputStream();
        // 将字节输出流封装成缓冲字符输出流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        // 向流中写入数据
        bufferedWriter.write("你好，服务器，我是客户端。。。");
        bufferedWriter.newLine();   // 写入新行
        bufferedWriter.flush();     // 把数据刷入网线
        bufferedWriter.close();
        socket2.close();
    }


    @Test
    public void test01() throws UnknownHostException {
        InetAddress address1 = InetAddress.getByName("www.atguigu.com");

        System.out.println(address1);
        // 获取 InetAddress对象所含的域名
        System.out.println(address1.getHostName());
        // 获取 InetAddress对象所含的IP地址
        System.out.println(address1.getHostAddress());

        // 获取本机的域名和IP地址
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        // 获取本机的域名和回环地址
        InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
        System.out.println(loopbackAddress);
    }
}
