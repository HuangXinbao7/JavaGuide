package com.atguigu.javase.homework;

/**
 * 作业1：使用缓冲流实现文本文件的复制
 */
public class FileCopy {

    public static void main(String[] args) {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
            fis = new FileInputStream("src\\com\\atguigu\\javase\\homework\\缓冲流文本文件");
            bis = new BufferedInputStream(fis);
            fos = new FileOutputStream("src\\com\\atguigu\\javase\\homework\\缓冲流文本文件.bak");
            bos = new BufferedOutputStream(fos);
            int ch = -1;
            while ((ch = bis.read()) != -1) {
                //System.out.println((char)ch);
                bos.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭缓冲输入流
            if(bis != null) {
                try {
                    bis.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }

            // 关闭缓冲输出流
            if(bos != null) {
                try {
                    bos.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
