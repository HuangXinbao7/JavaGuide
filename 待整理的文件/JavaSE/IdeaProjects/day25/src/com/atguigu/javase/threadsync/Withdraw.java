package com.atguigu.javase.threadsync;


/**
 * 扩展练习 :
 * 一个柜台Deposit存3000元, 每次存1000,存3次
 * 另一个柜台Withdraw取3000元, 每次取1000,取3次
 *
 * 【提示】
 * 1，明确哪些代码是多线程运行代码，须写入run()方法
 * 2，明确什么是共享数据。
 * 3，明确多线程运行代码中哪些语句是操作共享数据的。
 */
public class Withdraw implements Runnable{

    private Account account;

    public Withdraw(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            synchronized ("") {
                // 取出 Account 类中的余额，取出 1000。更新账户余额
                account.setBalance(account.getBalance() - 1000);
                System.out.println(Thread.currentThread().getName() + " 取出1000, " + account);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
