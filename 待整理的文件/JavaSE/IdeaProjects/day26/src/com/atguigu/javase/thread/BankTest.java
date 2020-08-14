package com.atguigu.javase.thread;

/**
 * 取钱类
 */
public class BankTest{

    public static void main(String[] args) {
        Account account = new Account("张三", 0);

        Withdraw runner1 = new Withdraw(account);
        Thread thread1 = new Thread(runner1);
        thread1.setName("取钱线程1");

        Deposit runner2 = new Deposit(account);
        Thread thread2 = new Thread(runner2);
        thread2.setName("取钱线程2");

        thread1.start();
        thread2.start();
    }
}
