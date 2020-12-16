package com.atguigu.javase.inheritance;

public class Computer {

    private double cpu;
    private int memory;
    private int disk;

    public Computer(double cpu, int memory, int disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getDisk() {
        return disk;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }

    public String getDetails() {
        return "CPU : " + cpu + "GHz, 内存 : " + memory + "G, 硬盘 : " + disk + "G";
    }
}
