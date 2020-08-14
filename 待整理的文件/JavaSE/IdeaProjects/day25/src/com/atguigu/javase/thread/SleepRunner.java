package com.atguigu.javase.thread;

/**
 *
 */
public class SleepRunner implements Runnable{

    private int count = 100;

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(ExtendsThreadTest.MyThread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(200);  // 睡眠 200 毫秒
            } catch (InterruptedException e) {
                System.out.println("在睡眠200毫秒时被打断");
            }
        }

        System.out.println("开始睡眠30秒，，，");
        try {
            // 睡眠 30 秒
            Thread.sleep( 30 * 1000);
        } catch (InterruptedException e) {
            System.out.println("在睡眠30秒时被打断。。。");
        }
        System.out.println("结束睡眠30秒，，，");
    }
}
