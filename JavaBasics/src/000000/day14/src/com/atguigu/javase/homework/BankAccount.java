package com.atguigu.javase.homework;

/**
 * 作业2：
 * 编写一个类实现银行账户的概念，包含的属性有“帐号”、“密码”、“存款余额”、“利率”、“最小余额”，定义封装这些属性的方法。账号要自动生成。
 * 编写主类，使用银行账户类，输入、输出3个储户的上述信息。
 *
 * 考虑：哪些属性可以设计成static属性。
 */
public class BankAccount {

    private static double rate = 3.0;       // 利率可以设计成 static 属性，默认缺省值是0
    private static double minMoney = 50;    // 最小余额可设置成 static 属性，默认缺省值是0
    private static long accountBase = 6222020200012345678L;          // 账号account的初始值

    public static void setRate(double rate) {
        BankAccount.rate = rate;
    }

    public static void setMinMoney(double minMoney) {
        BankAccount.minMoney = minMoney;
    }

    public static double getRate() {
        return rate;
    }

    public static double getMinMoney() {
        return minMoney;
    }

    /////////////////////////////////////////////////////////////////

    // 这里的账号指卡号，使用long型
    private long account;
    private String password;
    private double balance;

    public BankAccount() {}

    public BankAccount(String password, double balance) {
        this.account = accountBase++;
        this.password = password;
        this.balance = balance;
    }


    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


    // 对象的详细信息
    @Override
    public String toString() {
        // 不用返回静态成员变量 利率等，因为这里要的是对象的信息，而不是类的信息
        return "账号：" + account + ", 密码：" + password + ", 余额：" + balance;
    }
}
