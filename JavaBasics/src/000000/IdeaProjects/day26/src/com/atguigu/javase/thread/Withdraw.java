package com.atguigu.javase.thread;

public class Withdraw implements Runnable {

    // 关联对象
    private Account account;

    public Withdraw(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            synchronized("") {
                int money = (int)(Math.random() * 500);
                // 当银行中的余额小于要取的钱，就循环等待
                while (account.getBalance() < money) {
                    System.out.println("要取[" + money + "]钱不够，要等待");
                    try {
                        // "" 是锁对象
                        "".wait();  // 释放锁，进入锁对象的等待池（是一个队列）
                        // 状态1：进入wait等待状态，一旦被 notify
                        // 状态2：进入等待状态，synchronized(""){}
                        // 只有再次重新获取锁以后才能继续执行
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 取钱，更新余额
                account.setBalance(account.getBalance() - money);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "取了[" + money + "]钱，账户：" + account);
            }
        }
    }
}
