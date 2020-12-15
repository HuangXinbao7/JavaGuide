package com.atguigu.javase.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 在main方法中创建并启动两个线程。
 * 第一个线程循环随机打印100以内的整数，直到第二个线程从键盘读取了“Q”命令。
 */
public class TwoThreadTask {

    private boolean printFlag;

    public boolean isPrintFlag() {
        return printFlag;
    }

    public void setPrintFlag(boolean printFlag) {
        this.printFlag = printFlag;
    }

    public static void main(String[] args) {
        Runnable printRunner = new PrintRandomRunner2();
        StopRunner stopRunner = new StopRunner();


        Thread thread1 = new Thread(printRunner);
        thread1.setName("子线程1");
        thread1.start();

        Thread thread2 = new Thread(stopRunner);
        thread2.setName("子线程2");
        thread2.start();
    }
}


/**
 *
 */
class PrintRandomRunner2 implements Runnable {

    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag(){
        return flag;
    }

    @Override
    public void run() {
        while (flag) {
            System.out.println((int)(Math.random() * 100));
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


/**
 *
 */
class StopRunner implements Runnable {

    public PrintRandomRunner2 printRandomRunner;

    InputStream in = System.in;
    InputStreamReader isr = null;
    BufferedReader bufferedReader = null;

    @Override
    public void run() {


        try {
            isr = new InputStreamReader(in);
            bufferedReader = new BufferedReader(isr);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equalsIgnoreCase("Q")) {
                    ((PrintRandomRunner2)printRandomRunner).setFlag(false);
                    break; // 自我了结
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}