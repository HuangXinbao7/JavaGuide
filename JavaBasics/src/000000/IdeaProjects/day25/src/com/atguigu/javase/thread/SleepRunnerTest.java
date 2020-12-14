package com.atguigu.javase.thread;

/**
 *
 */
public class SleepRunnerTest {

    public static void main(String[] args) throws InterruptedException {
        Runnable runner = new SleepRunner();
        Thread thread = new Thread(runner);
        thread.setName("子线程");
        thread.start();

        // 主线程睡眠 21 秒，等待子线程执行完for循环
        Thread.sleep(21 * 1000);
        // 打断子线程
        thread.interrupt();
    }
}
