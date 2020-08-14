package com.atguigu.javase.threadsync;

/**
 * 银行有一个账户Account包含属性name, balance
 * 写一个普通 类Deposit实现Runnable, 在run方法中存钱
 * 有两个柜台(线程)分别同时向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。睡眠10毫秒
 */
public class Deposit implements Runnable{

    // 关联对象
    private Account account;

    // 必须通过构造器关联对象
    public Deposit(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            // 加上锁
            synchronized ("") {
                account.setBalance(account.getBalance() + 1000);
                System.out.println(Thread.currentThread().getName() + " 存入1000, " + account);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
