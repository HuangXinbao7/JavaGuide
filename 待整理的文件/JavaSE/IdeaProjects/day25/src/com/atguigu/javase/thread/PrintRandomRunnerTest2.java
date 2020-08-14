package com.atguigu.javase.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写程序，在main方法中创建一个线程。线程每隔一定时间（200ms以内的随机时间）
 *     产生一个0-100之间的随机整数，打印后将该整数放到集合中；
 *     共产生100个整数，全部产生后，睡眠30秒，然后将集合内容打印输出；
 *     在main线程中，唤醒上述睡眠的线程，使其尽快打印集合内容。
 */
public class PrintRandomRunnerTest2 {


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        int count = 100;
        boolean loopFlag = true;

        Runnable runner = new PrintRandomRunner(list, count, loopFlag);
        Thread thread = new Thread(runner);
        thread.setName("子线程");
        thread.start();

        /*try {
            Thread.sleep(18 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/



        //// 观察者
        //while (((PrintRandomRunner)runner).isLoopFlag()) {
        //    try {
        //        // 每隔10毫秒判断一次loopFlag属性值
        //        Thread.sleep(10);
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //}

        // 打断子线程
        thread.interrupt();
    }

    /**
     * 编写程序，在main方法中创建一个线程。
     * 线程每隔一定时间（200ms以内的随机时间）产生一个0-100之间的随机整数，打印后将该整数放到集合中；
     * 共产生100个整数，全部产生后，睡眠30秒，然后将集合内容打印输出；
     * 在main线程中，唤醒上述睡眠的线程，使其尽快打印集合内容。
     */
    public static class PrintRandomRunner implements Runnable{

        // 升级局部变量为类属性
        private List<Integer> list = new ArrayList<Integer>();     // 关联 List集合对象 list
        private int count = 100;
        private boolean loopFlag = true;    // 升级为属性
        // volatile 修饰的属性不会被优化，强制线程到主存中取值
        //private volatile boolean loopFlag = true;

        // 带形参为关联对象的构造器
        public PrintRandomRunner(List<Integer> list, int count, boolean loopFlag) {
            this.list = list;
            this.count = count;
            this.loopFlag = loopFlag;
        }

        public boolean isLoopFlag() {
            return loopFlag;
        }

        public void setLoopFlag(boolean loopFlag) {
            this.loopFlag = loopFlag;
        }

        public List<Integer> getList() {
            return list;
        }

        public void setList(List<Integer> list) {
            this.list = list;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public void run() {

            // 开始循环产生随机数
            System.out.println("开始循环产生随机数");
            for (int i = 0; i < count; i++) {
                int n = (int)(Math.random() * 100);
                System.out.println(Thread.currentThread().getName() + ": " + n);
                list.add(n);
                int randTime = (int)(Math.random() * 200);
                try {
                    Thread.sleep(randTime);
                } catch (InterruptedException e) {
                    System.out.println("在短睡[" + "]毫秒时被打断");
                }
            }
            loopFlag = false;
            System.out.println("结束循环产生随机数");

            System.out.println("开始睡眠30秒");
            try {
                Thread.sleep(30 * 1000);
                System.out.println("睡眠30秒完成");
            } catch (InterruptedException e) {
                //e.printStackTrace();
                System.out.println("睡眠30秒时被打断。。。");
            }
            System.out.println(list);
        }
    }
}
