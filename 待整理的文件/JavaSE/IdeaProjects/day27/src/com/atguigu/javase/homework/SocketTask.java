package com.atguigu.javase.homework;

import org.junit.Test;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 作业：
 * 从服务器给客户端发送一个文件。
 * 客户端保存在本地, 再回馈一个字符串"发送成功".
 */
public class SocketTask {

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket accept = serverSocket.accept();

        // 创建文件输入流，用于读取本地文件
        FileInputStream fis = new FileInputStream("./src/com/atguigu/javase/homework/girl.jpg");
        // 获取字节输出流，用户把文件数据写入流中
        OutputStream nos = accept.getOutputStream();
        // 获取字节输入流，并封装成缓冲字符输入流，用于接收客户端的消息
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));

        // 发送文件，以文件为准
        byte[] buf = new byte[8192];
        int len;
        while ((len = fis.read(buf)) != -1) {
            nos.write(buf, 0, len);
        }
        // 给客户端发送一个停止信号，告知数据发送已经结束
        // 不然客户端一直在等待套接字中的新数据
        accept.shutdownOutput();

        // 读取客户端发过来的消息
        String s = bufferedReader.readLine();
        System.out.println("来自客户端的消息：" + s);

        // 关闭资源
        bufferedReader.close();
        nos.close();
        fis.close();
        accept.close();
        serverSocket.close();
    }


    @Test
    public void client() throws IOException {
        // 创建套接字对象
        Socket socket = new Socket("localhost", 9999);

        // 获取字节输入流对象，用于从连接中读取服务端发过来的数据
        InputStream nis = socket.getInputStream();
        // 创建文件输出流对象，用于把数据写入到本地
        FileOutputStream fos = new FileOutputStream("./src/com/atguigu/javase/homework/girl2.jpg");
        // 从套接字获取字节输出流并封装成缓冲字符输出流，用于发送信息给服务端
        BufferedWriter nos = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        // 接收数据，以文件为准
        byte[] buf = new byte[8192];
        int len;
        while((len = nis.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }

        // 向服务端发信息
        nos.write("发送成功");
        nos.newLine();
        nos.flush();

        //socket.shutdownOutput();

        // 关闭资源
        nos.close();
        fos.close();
        nis.close();
        socket.close();
    }
}
