package com.atguigu.javase.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 在main方法中创建并启动两个线程。
 * 第一个线程循环随机打印100以内的整数，直到第二个线程从键盘读取了“Q”命令。
 * 重点是理解对象关联的使用。
 */
public class PrintRandomRunnerTest1 {
    // 主线程需要做的事情很简单，就是创建并启动两个线程即可。
    public static void main(String[] args) {
        // 创建第一个线程
        Runnable runner1 = new PrintRandomRunner1();
        Thread thread1 = new Thread(runner1);
        thread1.setName("打印随机数线程");
        thread1.start();

        // 创建第二个线程，以第一个线程对象作为实参
        Runnable runner2 = new KeyListener(runner1);
        Thread thread2 = new Thread(runner2);
        thread2.setName("键盘监听器");
        thread2.start();
    }
}


/**
 * 第二个线程：从键盘读取了“Q”命令
 */
class KeyListener implements Runnable {

    // 关联另一个线程
    private Runnable runner1;

    // 要想使用关联，则必须使用构造器，并以关联对象作为参数
    public KeyListener(Runnable runner1) {
        this.runner1 = runner1;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        try {
            // 直接在高级流中关联新创建的匿名对象，这样只需要关闭高级流。
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equalsIgnoreCase("Q")) {
                    // 这里出现多态，需要造型
                    ((PrintRandomRunner1)runner1).setLoopFlag(false);
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


/**
 * 第一个线程：循环随机打印100以内的整数
 */
class PrintRandomRunner1 implements Runnable{

    private boolean loopFlag = true;    // 升级为属性

    public boolean isLoopFlag() {
        return loopFlag;
    }

    public void setLoopFlag(boolean loopFlag) {
        this.loopFlag = loopFlag;
    }

    @Override
    public void run() {

        // 第一个线程循环随机打印100以内的整数，直到 loopFlag 的值为 false
        while (loopFlag) {
            int n = (int)(Math.random() * 100);
            System.out.println(Thread.currentThread().getName() + ": " + n);

            // 让程序的运行速度变慢
            //try {
            //    Thread.sleep(100);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
        }
        System.out.println("我要准备停止了。");
    }
}
