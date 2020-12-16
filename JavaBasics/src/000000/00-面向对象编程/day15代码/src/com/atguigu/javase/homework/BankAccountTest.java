package com.atguigu.javase.homework;

public class BankAccountTest {

    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("123456", 5000000);
        BankAccount bankAccount2 = new BankAccount("888888", 50);
        BankAccount bankAccount3 = new BankAccount("012345", 300);

        System.out.println(bankAccount1);
        System.out.println(bankAccount2);
        System.out.println(bankAccount3);

        // 静态成员要用静态方式处理. 不要通过对象.
        BankAccount.setMinBalance(10);
        BankAccount.setRate(0.05);

        System.out.println("利率 : " + BankAccount.getRate());
        System.out.println("最小余额 : " + BankAccount.getMinBalance());
    }
}
