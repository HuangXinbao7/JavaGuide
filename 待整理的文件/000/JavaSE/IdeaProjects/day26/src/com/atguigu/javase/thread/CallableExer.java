package com.atguigu.javase.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用线程池：
 * 创建子线程，生产100个随机整数，打印并返回最大值
 * 主线程中创建子线程并运行，再获取结果打印输出
 */
public class CallableExer {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 1）写一个具体类实现Callable接口，并实现 call()方法
        // 这里使用匿名类创建对象
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int max = 0x80000000;
                // 生产100个随机整数，打印并返回最大值
                for (int i = 0; i < 100; i++) {
                    int rand = (int)(Math.random() * 1000);
                    System.out.println(Thread.currentThread().getName() + ": " + rand);
                    if (rand > max) {
                        max = rand;
                    }
                }
                return max;
            }
        };

        // 2）创建线程池，通过工具类 Executors.newXXx
        ExecutorService executorService = Executors.newFixedThreadPool(30);

        // 3）把具体的Callable对象提交给线程池，并获取相应的task对象，用于获取将来的值。
        // list保存所有 Future 对象
        List<Future<Integer>> list = new ArrayList<>();
        // 一次性提交过个任务
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = executorService.submit(callable);
            list.add(future);
        }

        // 4）调用线程池的shutdown方法
        // 发出通知，线程池不再添加新任务了，执行完当前所有任务后就结束
        executorService.shutdown();

        // 5）一次从task对象中获取到将来的值
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get());
        }

        /*
        while (list.size() > 0) {
            // 从当前任务列表中遍历，找出第一个已完成的。
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).isDone()) {
                    System.out.println("将来的值：" + list.get(i).get());
                    list.remove(i);     // 将当前已经完成任务的线程从列表中移除，更新列表长度
                    break;
                }
            }
        }
        */
    }
}
