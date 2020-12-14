package com.atguigu.javase.threadsync;

/**
 * 编写一个线程程序（Counter类），声明实例变量counter，初值为200。
 * 在run方法中循环50次，每次对counter做减2操作（用-=实现），
 * 睡眠10毫秒，并打印counter值，然后继续下一次循环；
 * 在main方法中创建Counter实例，并用它创建和运行一个线程，观察counter值每次是否减去了2；
 * 用刚才的Counter实例再创建第二个线程，两个线程同时运行，观察counter值每次是否减去了2 。
 */
public class CounterRunnerTest {

    public static void main(String[] args) {

        Runnable counter = new Counter();

        Thread thread1 = new Thread(counter);
        thread1.setName("子线程1");
        thread1.start();

        Thread thread2 = new Thread(counter);
        thread2.setName("子线程2");
        thread2.start();


        //while (((Counter)runner).isLoopFlag()) {
        //    try {
        //        Thread.sleep(10);
        //        int n = ((Counter)runner).getCounter();
        //        System.out.println(n);
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //}
    }
}
