package com.atguigu.javase.inheritance;

public class NotePad extends Computer {

    int satelite;

    public NotePad() {
        super(2.2, 4, 32);
    }

    public NotePad(double cpu, int memory, int disk, int satelite) {
        super(cpu, memory, disk);
        this.satelite = satelite;
    }

    public void navigate() {
        System.out.println("使用平板在导航, CPU : " + getCpu());
    }

    @Override
    public String getDetails() {
        //return "CPU : " + getCpu() + "GHz, 内存 : " + getMemory() + "G, 硬盘 : " + getDisk() + "G" + ", 卫星 : " + satelite;
        return super.getDetails() + ", 卫星 : " + satelite;
    }
}
