package com.atguigu.javase.homework;

/**
 *
 */
public class ExerRandomRunnerTest {

    public static void main(String[] args) {
        Runnable runner1 = new PrintRandomRunner2();
        Thread thread1 = new Thread(runner1);
        thread1.setName("打印随机线程数");
        thread1.start();

        // 以对象 runner1 作为实参创建 KeyListener 的对象 runner2
        Runnable runner2 = new KeyListener(runner1);
        Thread thread2 = new Thread(runner2);
        thread2.setName("键盘监听器");
        thread2.start();
    }
}
