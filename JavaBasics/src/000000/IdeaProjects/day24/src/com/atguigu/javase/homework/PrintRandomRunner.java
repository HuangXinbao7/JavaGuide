package com.atguigu.javase.homework;

/**
 *
 */
public class PrintRandomRunner implements Runnable {

    private boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (flag) {
            System.out.println(Thread.currentThread().getName() + ": " + (int)(Math.random() * 100));
        }
        System.out.println("我准备要停止了。");

    }
}
