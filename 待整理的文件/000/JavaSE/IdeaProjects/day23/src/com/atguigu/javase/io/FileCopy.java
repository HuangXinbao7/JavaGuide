package com.atguigu.javase.io;


import java.io.FileReader;
import java.io.FileWriter;

/**
 * 写一个类FileCopy，在主方法中，把FileCopy.java 文件复制为 FileCopy.java.bak
 */
public class FileCopy {

    // 只能复制文本文件
    public static void main(String[] args) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader("./src/com/atguigu/javase/io/FileCopy.java");
            fileWriter = new FileWriter("./src/com/atguigu/javase/io/FileCopy.java.bak");

            // 使用缓冲区的方式复制文件
            char[] buf = new char[1024];
            int n;
            while((n = fileReader.read(buf))  != -1) {
                fileWriter.write(buf, 0, n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭输入流
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // 关闭输出流
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}