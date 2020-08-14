package com.atguigu.javase.io;


import java.io.*;

/**
 * 写一个类FileCopy，在主方法中，把FileCopy.java 文件复制为 FileCopy.java.bak
 */
public class FileCopy2 {

    // 处理任意文件的复制
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("./src/com/atguigu/javase/io/大风起兮 - LuckyMaxx.flac");
            fos = new FileOutputStream("./src/com/atguigu/javase/io/大风起兮-LuckyMaxx.flac.bak");

            // 处理数据
            byte[] buf = new byte[8192];    // 8k效率最高
            int n;
            while ((n = fis.read(buf)) != -1) {
                fos.write(buf, 0, n);
            };
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }










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