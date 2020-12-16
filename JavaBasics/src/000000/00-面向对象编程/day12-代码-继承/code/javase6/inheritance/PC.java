package com.atguigu.javase.inheritance;

public class PC extends Computer {

    String keyboard;

    public PC() {
        super(3.8, 16, 500);
    }

    public PC(double cpu, int memery, int disk, String keyboard) {
        super(cpu, memery, disk);
        this.keyboard = keyboard;
    }

    public void code() {
        System.out.println("使用PC写代码, 内存 : " + getMemory());
    }

    @Override
    public String getDetails() {
        //return "CPU : " + getCpu() + "GHz, 内存 : " + getMemory() + "G, 硬盘 : " + getDisk() + "G" + ", 键盘 : " + keyboard;
        return super.getDetails() + ", 键盘 : " + keyboard;
    }
}
