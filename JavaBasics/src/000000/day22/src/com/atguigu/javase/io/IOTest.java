package com.atguigu.javase.io;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 流：数据从一个节点到另一个节点的流动
 * 按方向分类：输入流、输出流
 * 按流中数据单位：字节流、字符流
 * 字节输入流：InputStream
 * 字节输出流：OutputStream
 * 字符输入流：Reader
 * 字符输出流：Writer
 *
 * 文件流：File前缀
 *      FileReader 读文本文件
 *      FileWriter 写文本文件
 *
 *      FileInputStream 读二进制文件
 *      FileOutputStream 写二进制文件
 *
 * 文件读写步骤：
 *      1）创建流对象建立通道
 *      2）通过通道处理数据
 *      3）关闭流对象
 */
public class IOTest {

    /**
     * IO字符输出流完整步骤
     */
    @Test
    public void test3() {
        // 1）声明引用，赋值为 null
        FileWriter fileWriter = null;
        // 2）try catch finally
        try {
            // 5）在try中创建对象
            fileWriter = new FileWriter("写一个文本文件.txt");
            // 6）处理数据
            fileWriter.write("中国");     // write() 方法不换行
            fileWriter.write("一行中文字");
            fileWriter.write(13);   // 回车键，提升兼容性
            fileWriter.write(10);   // 换行
            fileWriter.write("第二行的文本数据");
            fileWriter.write('\r');
            fileWriter.write('\n');
            fileWriter.write("第三行的文本数据");
        } catch (Exception e) {
            // 4）异常处理
            e.printStackTrace();
        } finally {
            // 3）在finally中关闭流
            if(fileWriter != null) {
                try{
                    fileWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * IO字符输入流的完整步骤
     */
    @Test
    public void test2() {
        // 1 声明引用，赋值为null
        FileReader fileReader = null;
        // 2 try catch finally
        try {
            // 5 在try中创建流对象
            fileReader = new FileReader("文本文件名");
            // 6 处理数据
            int ch = 0;
            while ((ch = fileReader.read()) != -1) {
                System.out.println((char)ch);
            }
        } catch (IOException e) {
            // 4 在 catch中处理异常
            e.printStackTrace();
        } finally {
            // 3）在finally中关闭流
            if(fileReader != null) {
                try{
                    fileReader.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 读文件步骤
     */
    @Test
    public void test1() throws IOException {
        // 1）创建流对象建立管子
        FileReader fr = new FileReader("文本文件名");    // 当前项目根目录创建文本文件

        // 2）
        int ch;
        while((ch = fr.read()) != -1) {
            System.out.print((char)ch);     // 处理数据
        }
        // 3）关闭流对象
        fr.close();
    }
}
