package com.atguigu.javase.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写程序，在main方法中创建两个线程。
 * 线程1每隔一定时间（200ms以内的随机时间）产生一个0-100之间的随机整数，打印后将该整数放到集合中；
 * 共产生100个整数，全部产生后，睡眠30秒；
 * 在线程2中，唤醒上述睡眠的线程1，并获取线程1中的集合并打印集合内容。
 */
public class HomeWork1 {

    public static void main(String[] args) {
        Runnable runner1 = new PrintRandomRunner1();
        Thread thread1 = new Thread(runner1);
        thread1.setName("打印随机数线程1");
        thread1.start();

        Runnable runner2 = new AwakenRunner2(runner1, thread1);
        Thread thread2 = new Thread(runner2);
        thread2.setName("子线程2");
        thread2.start();
    }
}



/**
 * 线程1：
 * 每隔一定时间（200ms以内的随机时间）产生一个0-100之间的随机整数，打印后将该整数放到集合中；
 * 共产生100个整数，全部产生后，睡眠30秒；
 */
class PrintRandomRunner1 implements Runnable {

    private List<Integer> list = new ArrayList<>();
    private boolean sleepFlag = false;

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public boolean isSleepFlag() {
        return sleepFlag;
    }

    public void setSleepFlag(boolean sleepFlag) {
        this.sleepFlag = sleepFlag;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            int n = (int)(Math.random() * 100); // 产生一个0-100之间的随机整数
            System.out.println(Thread.currentThread().getName() + ": " + n);              // 打印该数
            list.add(n);                        // 放到集合中

            // 时间间隔
            int sleepTime = (int)(Math.random() * 200);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println("在短睡眠中被打断");
            }
        }


        // 共产生100个整数，全部产生后，睡眠30秒
        try {
            sleepFlag = true;   // 进入长睡眠状态标志
            Thread.sleep(30 * 1000);
        } catch (InterruptedException e) {
            System.out.println("30秒睡眠中途被唤醒");
        }
    }
}


/**
 * 在线程2中，唤醒上述睡眠的线程1，并获取线程1中的集合并打印集合内容。
 */
class AwakenRunner2 implements Runnable {

    private Runnable runner1;
    private Thread thread;

    public AwakenRunner2(Runnable runner1, Thread thread) {
        this.runner1 = runner1;
        this.thread = thread;
    }

    @Override
    public void run() {

        while (!((PrintRandomRunner1)runner1).isSleepFlag()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        thread.interrupt();

        List<Integer> list = ((PrintRandomRunner1)runner1).getList();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Thread.currentThread().getName() + ": " + list.get(i));
        }
    }
}