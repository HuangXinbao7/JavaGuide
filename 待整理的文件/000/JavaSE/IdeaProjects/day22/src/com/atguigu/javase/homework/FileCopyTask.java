package com.atguigu.javase.homework;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * 作业：
 * 写一个类 FileCopy，在主方法中，把FileCopy.java 文件复制为FileCopy.java.bak 文件。
 * FileReader fileReader;   以读为主导。读一行，写一行
 * FileWriter fileWriter;
 *
 */
public class FileCopyTask {

    public static void main(String[] args) {

        // 创建字符输入流和字符输出流
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        // 源文件和目标文件的路径
        String inputFilePath = "src\\com\\atguigu\\javase\\homework\\FileCopy.java";
        String outputFilePath = "src\\com\\atguigu\\javase\\homework\\FileCopy.java.bak";

        try {
            // 创建输入流和输出流对象
            fileReader = new FileReader(inputFilePath);
            fileWriter = new FileWriter(outputFilePath);

            // 循环读取源文件中的内容，并将读到的内容写入目标文件中
            // 这是落后的方式
            /*int ch = 0;
            while ((ch = fileReader.read()) != -1) {
                fileWriter.write(ch);
            }*/

            // 使用缓冲区的方式复制文件






        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭输入流
            if(fileReader != null) {
                try{
                    fileReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // 关闭输出流
            if(fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
