package com.atguigu.javase.polymorphism;

public class Computer {

    private double cpu;
    private int memory;
    private int disk;
    private double price;

    public Computer() {

    }

    public Computer(double cpu, int memory, int disk, double price) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
        this.price = price;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public double getCpu() {
        return cpu;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getMemory() {
        return memory;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }

    public int getDisk() {
        return disk;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getDetails(){
        return "CPU：" + cpu + ", 内存：" + memory + ", 硬盘：" + disk + ", 价格：" + price;
    }
}
