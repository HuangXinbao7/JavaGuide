package com.atguigu.javase.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileTest {

    /**
     * 目录相关
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        File file = new File("aa/bb/cc/dd");
        //file.mkdir();
        //file.mkdirs();  // 创建多层目录

        File[] files = file.listFiles();   // 列出file对象代表的目录中的所有内容，包括子目录和子文件。
        for (File f: files) {
            if (f.isDirectory()) {
                System.out.println("目录：" + f);
            } else {
                System.out.println("文件：" + f);
            }

        }


    }


    /**
     * 文件相关
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        File file = new File("HashMap.java");
        System.out.println(file);

        // 常用方法
        System.out.println("file.length(): " + file.length());
        System.out.println("file.getAbsolutePath(): " + file.getAbsolutePath());
        System.out.println("file.canRead(): " + file.canRead());
        System.out.println("file.canWrite(): " + file.canWrite());
        //System.out.println("file.createNewFile(): " + file.createNewFile());
        System.out.println("file.exists(): " + file.exists());
        System.out.println("file.getFreeSpace(): " + file.getFreeSpace());
        System.out.println("file.getTotalSpace(): " + file.getTotalSpace());
        System.out.println("file.isDirectory(): " + file.isDirectory());
        System.out.println("file.isFile(): " + file.isFile());
        System.out.println("file.lastModified(): " + file.lastModified());
        //System.out.println("file.delete(): " + file.delete());
    }
}
