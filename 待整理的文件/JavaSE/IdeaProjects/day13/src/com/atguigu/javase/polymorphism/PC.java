package com.atguigu.javase.polymorphism;

public class PC extends Computer {

    private String keyboard;

    public PC() {}

    public PC(double cpu, int memory, int disk, double price, String keyboard) {
        super(cpu, memory, disk, price);
        this.keyboard = keyboard;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public void code(){
        System.out.println("使用PC写代码");
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", 键盘：" + keyboard;
    }
}
