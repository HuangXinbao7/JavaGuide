package com.atguigu.javase.threadsync;

/**
 * 银行有一个账户Account包含属性name, balance
 * 写一个普通 类Deposit实现Runnable, 在run方法中存钱
 * 有两个柜台(线程)分别同时向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。睡眠10毫秒
 */
public class AccountDepositTest {

    public static void main(String[] args) {

        Account account = new Account("张三", 10000);

        Runnable deposit = new Deposit(account);
        Runnable withdraw = new Withdraw(account);

        // 柜台1，存钱
        Thread thread1 = new Thread(deposit);
        thread1.setName("柜台1");
        thread1.start();

        // 柜台2，存钱
        Thread thread2 = new Thread(deposit);
        thread2.setName("柜台2");
        thread2.start();

        // 柜台3，取钱
        Thread thread3 = new Thread(withdraw);
        thread3.setName("柜台3");
        thread3.start();
    }
}
