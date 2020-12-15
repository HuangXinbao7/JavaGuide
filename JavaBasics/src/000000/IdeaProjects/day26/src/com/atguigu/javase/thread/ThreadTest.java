package com.atguigu.javase.thread;

import java.util.ArrayList;
import java.util.List;

class MyCall implements Callable<String> {

    /**
     * 实现Callable接口的具体类，其call()方法可以拥有返回值并可以抛出受检异常 Exception
     */
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 300; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
        return Thread.currentThread().getName();
    }
}


/**
 * 多线程的实例只能在 main 方法实现
 */
public class ThreadTest {

    /**
     * 创建线程池的多种方式，并结合集合数组保存多个线程
     */
    public static void main(String[] args) {
        MyCall myCall = new MyCall();
        // 自动缓冲的线程池，提交多少就创建多少
        //ExecutorService executorService = Executors.newCachedThreadPool();
        // 固定个数的线程池，不太好用
        //ExecutorService executorService = Executors.newFixedThreadPool(30);
        // 工作窃取线程池，最好用的
        ExecutorService executorService = Executors.newWorkStealingPool();


        // 使用集合存放线程，不需要一个一个手动创建
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 300; i++) {
            Future<String> task = executorService.submit(myCall);
            list.add(task);
        }
        // 线程提交结束
        executorService.shutdown();

        // 检测集合中的线程个数，直到个数为0才终止循环
        while (list.size() > 0) {
            System.out.println("list元素个数：" + list.size());
            for (int i = 0; i < list.size(); i++) {
                // 先判断此任务是否已经完成，提高观察效率
                if (list.get(i).isDone()) {
                    System.out.println(list.get(i) + " is done.");
                    try {
                        System.out.println("将来的值：" + list.get(i).get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    // 把已经完成任务的线程从集合中移除
                    list.remove(i);
                    break;  // 每次循环只处理一个线程，处理完之后就跳出当前for循环
                }
            }
        }
    }


    /**
     * 创建并启动线程的第四种方式：使用线程池
     */
    public static void main2(String[] args) {
        MyCall myCall = new MyCall();
        // 自动缓冲的线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 将三个线程提交到线程池中
        Future<String> task1 = executorService.submit(myCall);
        Future<String> task2 = executorService.submit(myCall);
        Future<String> task3 = executorService.submit(myCall);

        // 线程1
        try {
            System.out.println("将来的值：" + task1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 线程2
        try {
            System.out.println("将来的值：" + task2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 线程3
        try {
            System.out.println("将来的值：" + task3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    /**
     * 创建并启动线程的第三种方式：通过实现 Callable 接口
     */
    public static void main1(String[] args) {
        // MyCall类实现了 Callable 接口
        MyCall myCall = new MyCall();
        // FutureTask实现了FutureRunnable接口
        FutureTask<String> stringFutureTask = new FutureTask<String>(myCall);
        Thread thread = new Thread(stringFutureTask);
        thread.start();

        for(int i = 0; i < 300; i++) {
            System.out.println("main: " + i);
        }
        try {
            // 获取将来的返回值，此方法会引发当前线程阻塞，要等待子线程结束后才返回
            String s = stringFutureTask.get();
            System.out.println("获取到的将来的值：" + s);
        } catch (InterruptedException e) {  // 子线程被打断
            e.printStackTrace();
        } catch (ExecutionException e) {    // 如果在call方法中出现异常
            e.printStackTrace();
        }
    }
}
