package com.atguigu.javase.threadsync;

/**
 * 编写一个线程程序（Counter类），声明实例变量counter，初值为200。
 * 在run方法中循环50次，每次对counter做减2操作（用-=实现），
 * 睡眠10毫秒，并打印counter值，然后继续下一次循环；
 * 在main方法中创建Counter实例，并用它创建和运行一个线程，观察counter值每次是否减去了2；
 * 用刚才的Counter实例再创建第二个线程，两个线程同时运行，观察counter值每次是否减去了2 。
 */
public class Counter implements Runnable{

    private int counter = 200;
    private boolean loopFlag = true;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public boolean isLoopFlag() {
        return loopFlag;
    }

    public void setLoopFlag(boolean loopFlag) {
        this.loopFlag = loopFlag;
    }

    @Override
    //public synchronized void run() {  锁的力度太大，不适合交互
    public void run() {
        // synchronized（this），锁的力度太大，不适合交互
        for (int i = 0; i < 50; i++) {
            // 加锁：要想进入这段代码的线程必须先持有锁才能及惹怒
            // 锁对象：互斥锁
            synchronized (this) {
                // 被锁的代码具有原子性
                counter -= 2;
                try {
                    Thread.sleep(100);
                    //System.out.println(counter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": " + counter);
            }   // 隐形的释放锁操作
        }
        loopFlag = false;
    }
}
