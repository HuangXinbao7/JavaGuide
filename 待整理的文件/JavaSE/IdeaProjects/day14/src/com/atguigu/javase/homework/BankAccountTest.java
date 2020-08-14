package com.atguigu.javase.homework;

// 编写主类，使用银行账户类，输入、输出3个储户的上述信息。
public class BankAccountTest {

    public static void main(String[] args) {
        BankAccount b1 = new BankAccount("123456", 1000000);
        BankAccount b2 = new BankAccount("123456", 50000);
        BankAccount b3 = new BankAccount("123456", 150000);

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        // 静态成员要用静态方式处理. 不要通过对象.
        BankAccount.setRate(0.05);
        BankAccount.setMinMoney(100);

        System.out.println("利率: " + BankAccount.getRate());
        System.out.println("最小余额: " + BankAccount.getMinMoney());
    }
}
