package com.atguigu.javase.thread;

public class Deposit implements Runnable{

    private Account account;

    public Deposit(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            synchronized("") {
                int money = (int)(Math.random() * 200);
                // 存入钱
                account.setBalance(account.getBalance() + money);
                "".notify();    // 锁对象的 nofity
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "存了[" + money + "]钱，账户：" + account);
            }   // 隐式放锁
            try {
                Thread.sleep(1000); // 让消费者更有机会获取锁，生产者不抢锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
