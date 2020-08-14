package com.atguigu.javase.thread;

/**
 * 观察者，用死循环不停的观察
 */
public class Observer implements Runnable{

    private Runnable runner;
    private Thread thread;

    public Observer(Runnable runner, Thread thread) {
        this.runner = runner;
        this.thread = thread;
    }

    public Runnable getRunner() {
        return runner;
    }

    public void setRunner(Runnable runner) {
        this.runner = runner;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        // 观察者
        while (((PrintRandomRunnerTest2.PrintRandomRunner)runner).isLoopFlag()) {
            try {
                // 每隔10毫秒判断一次loopFlag属性值
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        thread.interrupt();
    }
}
