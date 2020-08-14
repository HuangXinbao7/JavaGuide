package com.atguigu.javase.thread;


/**
 * 通过继承的方式创建线程
 */
public class ExtendsThreadTest {

    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();     // 创建一个新栈
        myThread.setName("子线程 ");
        // 激活栈，并把 run 压入栈低，这里是子类的run，虚方法调用
        myThread.start();
        // 这里是主线程阻塞，子线程继续。即：main阻塞，myThread继续，直到执行完毕
        //myThread.join();

        for (int i = 0; i < 500; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }


    /**
     * 以继承的方式
     * 继承方式的缺点：
     *      单继承
     *      共享数据不方便
     */
    static class MyThread extends Thread {

        /**
         * 通过继承的方式创建的线程，因为其父类中的run方法是空的，子类必须重写run方法
         */
        @Override
        public void run() {
            for (int i = 0; i < 500; i++) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
            //super.run();
        }
    }
}


