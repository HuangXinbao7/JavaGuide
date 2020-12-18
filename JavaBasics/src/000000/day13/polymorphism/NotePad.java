package com.atguigu.javase.polymorphism;

public class NotePad extends Computer {

    private int sateLite;

    public NotePad() {}

    public NotePad(double cpu, int memory, int disk, double price, int sateLite) {
        super(cpu, memory, disk, price);
        this.sateLite = sateLite;
    }

    public int getSateLite(){
        return sateLite;
    }

    public void setSateLite(int sateLite) {
        this.sateLite = sateLite;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", 卫星：" + sateLite;
    }

    public void navigate(){
        System.out.println("使用平板导航");
    }
}
