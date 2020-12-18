package com.atguigu.javase.thread;


public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        ExtendsThreadTest.MyThread myThread = new ExtendsThreadTest.MyThread();
        myThread.start();

        myThread.join();    // 这里是主线程阻塞，子线程继续。即：main阻塞，myThread继续，直到执行完毕
        for (int i = 0; i < 500; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}


/**
 * 以继承的方式
 * 继承方式的缺点：
 *      单继承
 *      共享数据不方便
 */
 class MyThread extends Thread {

    /**
     * 父类中的run方法是空的，子类必须重写
     */
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println(Thread.currentThread().getName() + "：" + i);
        }
        super.run();
    }
}