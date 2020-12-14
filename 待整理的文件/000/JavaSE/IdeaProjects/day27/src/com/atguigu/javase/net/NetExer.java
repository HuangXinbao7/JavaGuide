package com.atguigu.javase.net;

import org.junit.Test;

import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


public class NetExer {


    /**
     * 练习4：客户端给服务端发送文本，服务端会将文本转成大写在返回给客户端。
     */
    @Test
    public void server04() throws IOException {
        // 创建服务器端套接字，绑定到指定端口上
        ServerSocket serverSocket = new ServerSocket(9904);
        // 调用 accept() 方法，监听连接请求，返回通信套接字对象
        Socket accept = serverSocket.accept();

        // 调用Socket对象的方法，获取输入流和输出流，开始网络数据的接收和发送
        InputStream nis = accept.getInputStream();
        OutputStream nos = accept.getOutputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(nis));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(nos));

        // 从客户端读取文本
        String str = bufferedReader.readLine();
        System.out.println(str);
        String upperCase = str.toUpperCase();
        System.out.println(upperCase);

        // 把处理后的文本写入连接中，发给客户端
        bufferedWriter.write(upperCase);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        accept.shutdownOutput();    // 写入结束通知
    }


    /**
     * 练习4：客户端给服务端发送文本，服务端会将文本转成大写在返回给客户端。
     */
    @Test
    public void client04() throws IOException {
        Socket socket = new Socket("localhost", 9904);

        OutputStream nos = socket.getOutputStream();
        InputStream nis = socket.getInputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(nos));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(nis));

        // 发送文本
        bufferedWriter.write("abcd");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        socket.shutdownOutput();    // 发送结束通知

        // 读取服务器返回的文本信息
        String s = bufferedReader.readLine();
        System.out.println(s);
    }



    /**
     * 让服务器给客户端发一段文本，最后加上当前时间
     * 进阶：使用线程处理服务器的发送消息
     */
    @Test
    public void server03() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9903);
        // 循环处理，让服务器不停监听并发送信息
        while (true) {
            Socket accept = serverSocket.accept();
            System.out.println(serverSocket.getLocalPort());
            System.out.println(accept);

            Callable callable = new Callable() {
                @Override
                public Object call() throws Exception {
                    BufferedWriter bufferedWriter = new BufferedWriter(
                            new OutputStreamWriter(accept.getOutputStream())
                    );

                    bufferedWriter.write("你好客户端，现在的时间是：" + LocalDateTime.now());
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    accept.close();

                    try{
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    return 0;
                }
            };
            new Thread(new FutureTask(callable)).start();
        }
    }


    /**
     * 让服务器给客户端发一段文本，最后加上当前时间
     */
    @Test
    public void client03() throws IOException {
        Socket socket = new Socket("localhost", 9903);

        InputStream nis = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(nis));

        String s = bufferedReader.readLine();
        System.out.println(s);
    }


    /**
     * 实例2：客户端发送内容给服务端，服务端给予反馈。
     */
    @Test
    public void server02() throws IOException {
        // 在本机绑定端口 9902
        ServerSocket serverSocket = new ServerSocket(9902);
        Socket accept = serverSocket.accept();// 开始监听
        System.out.println("服务端server02正在开始监听~~");
        //accept.setSoTimeout(20000);

        // 获取输入输出流
        InputStream nis = accept.getInputStream();
        OutputStream nos = accept.getOutputStream();

        // 从流中读取数据
        byte[] buf = new byte[8192];    // 设置缓冲区
        int len = nis.read(buf);
        String str = new String(buf, 0, len);
        System.out.println(accept.getInetAddress().toString() + ": " + str);

        // 写入数据到流
        nos.write("服务端发送的消息".getBytes());

        // 关闭资源
        nos.close();
        nis.close();
        accept.close();
        serverSocket.close();
    }


    /**
     * 实例2：客户端发送内容给服务端，服务端给予反馈。
     */
    @Test
    public void client02() throws IOException {
        // 绑定服务器端口
        Socket socket = new Socket("localhost", 9902);

        //
        OutputStream nos = socket.getOutputStream();
        InputStream nis = socket.getInputStream();

        //
        nos.write("client02 发送的消息".getBytes());
        byte[] buf = new byte[8192];
        int len = nis.read(buf);
        String str = new String(buf, 0, len);
        System.out.println("from ServerSocket: " + str);

        socket.close();
    }


    /**
     * 实例1：客户端发送内容给服务端，服务端将内容打印到控制台上。
     */
    @Test
    public void server01() throws IOException {
        // 在本机绑定端口 9901
        ServerSocket serverSocket = new ServerSocket(9901);
        System.out.println("服务端test01正在开始~");
        // 接收请求，准备接受客户端请求，此方法会阻塞
        Socket accept = serverSocket.accept();
        //accept.setSoTimeout(20000);

        InputStream inputStream = accept.getInputStream();
        byte[] buf = new byte[8192];
        int readNum = inputStream.read(buf);
        String str = new String(buf, 0, readNum);
        System.out.println(accept.getInetAddress().toString() + ": " + str);

        accept.close();
        serverSocket.close();
    }


    /**
     * 实例1：客户端发送内容给服务端，服务端将内容打印到控制台上。
     */
    @Test
    public void client01() throws IOException {
        // 绑定服务器端口 9901
        Socket socket = new Socket("localhost", 9901);
        System.out.println(socket);

        OutputStream outputStream = socket.getOutputStream();
        // 将默认的字节流封装成字符流
        // 要想处理文本，必须使用转换流和缓冲流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("你好服务器，我是客户端。。。");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        bufferedWriter.close();
        socket.close();
    }
}
