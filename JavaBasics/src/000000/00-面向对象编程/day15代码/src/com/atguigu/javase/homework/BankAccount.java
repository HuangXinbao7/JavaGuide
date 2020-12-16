package com.atguigu.javase.homework;


/*编写一个类实现银行账户的概念，
包含的属性有“帐号”、“密码”、“存款余额”、“利率”、“最小余额”，
定义封装这些属性的方法。账号要自动生成。
编写主类，使用银行账户类，输入、输出3个储户的上述信息。
考虑：哪些属性可以设计成static属性。 该数据能否共享???*/
public class BankAccount {

    private static double rate;
    private static double minBalance;
    private static long accountBase = 6222020200012345678L;

    public static void setRate(double rate) {
        BankAccount.rate = rate;
    }

    public static void setMinBalance(double minBalance) {
        BankAccount.minBalance = minBalance;
    }

    public static double getRate() {
        return rate;
    }

    public static double getMinBalance() {
        return minBalance;
    }

    /////////////////////////////////////////////////////////////////

    private long account;
    private String password;
    private double balance;

    public BankAccount() {
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override // 对象的详细信息.
    public String toString() {
        return "账号 ： " + account + ", 密码 ：" + password + ", 余额 ：" + balance;
    }

}
