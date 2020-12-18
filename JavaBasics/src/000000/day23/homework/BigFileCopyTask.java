package com.atguigu.javase.homework;


import org.junit.Test;

import java.io.IOException;

/**
 * 分别使用节点流：FileInputStream、FileOutputStream 和
 * 缓冲流：BufferedInputStream、BufferedOutputStream，实现文本文件/图片/视频文件的复制。
 * 并比较二者在数据复制方面的效率, 文件要足够大，至少几个G。
 */
public class BigFileCopyTask {

    @Test
    public void exer1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            //fis = new File

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
    }


    /**
     * 图片文件源：E:\TestFiles\Snipaste_2020-04-20_23-29-47.png
     * 文件数据源：E:\TestFiles\2020_大数据技术.pdf
     * 视频文件数据源：E:\TestFiles\20200420_092423HashMap.mp4
     * 大文件数据源：E:\TestFiles\CentOS-7-x86_64-DVD-1908.iso, 大小 4.5G。
     */
    public static void main(String[] args) throws IOException {

        //String src = "E:\\TestFiles\\2020_大数据技术.pdf";
        //String dest = "E:\\TestFiles\\2020_大数据技术.pdf.bak";
        String src = "E:\\TestFiles\\20200420_092423HashMap.mp4";
        String dest = "E:\\TestFiles\\20200420_092423HashMap.mp4.bak";
        //String src = "E:\\TestFiles\\CentOS-7-x86_64-DVD-1908.iso";
        //String dest = "E:\\TestFiles\\CentOS-7-x86_64-DVD-1908.iso.bak";


        // 开始计时
        long start1 = System.currentTimeMillis();
        // 使用字节流
        fIOsCopy(src, dest);
        // 结束计时
        long end1 = System.currentTimeMillis();

        // 开始计时
        long start2 = System.currentTimeMillis();
        // 使用缓冲流
        bIOsCopy(src, dest);
        // 结束计时
        long end2 = System.currentTimeMillis();

        // 当复制近200M的视频文件时
        // 使用字节流时耗时 2250 毫秒
        // 使用缓冲流是耗时 656 毫秒
        // 数据复制方面的效率：缓冲流大概是字节流的4倍
        System.out.println("fIOsCopy: " + (end1 - start1));
        System.out.println("bIOsCopy: " + (end2 - start2));
    }


    /**
     * 使用节点流：FileInputStream、FileOutputStream
     * @param src  输入数据源
     * @param dest 输出数据目的地
     * @throws IOException
     */
    private static void fIOsCopy(String src, String dest) throws IOException {
        // 指定输入数据源
        FileInputStream fis = new FileInputStream(src);
        // 指定输出数据目的地
        FileOutputStream fos = new FileOutputStream(dest);

        // 3 读数据
        byte[] buf = new byte[1024];
        int len = -1;
        while ((len = fis.read(buf)) != -1) {
            // 4 写数据
            fos.write(buf, 0, len);
        }
        // 5 关闭流
        fis.close();
        fos.close();
    }


    /**
     * 使用缓冲流：BufferedInputStream、BufferedOutputStream
     * @param src  指定输入数据源
     * @param dest 指定输出数据目的地
     * @throws IOException
     */
    private static void bIOsCopy(String src, String dest) throws IOException {
        // 1 指定输入数据源
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        // 2 指定输出数据目的地
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
        // 3 读数据
        byte[] buf = new byte[1024];
        int len = -1;
        while ((len = bis.read(buf)) != -1) {
            // 4 写数据
            bos.write(buf, 0, len);
        }
        // 5 关闭流
        bis.close();
        bos.close();
    }
}