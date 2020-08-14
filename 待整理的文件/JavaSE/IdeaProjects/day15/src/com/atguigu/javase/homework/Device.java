package com.atguigu.javase.homework;

/**
 * 作业：
 * 写一个抽象类 Device
 * 包含属性 ID, name和抽象方法 startup, shutdown
 * 再写一个类 Mouse,继承Device抽象父类并实现USB接口
 * 并实现其中的所有方法
 * 写测试类,创建对象,使用本态和多态调用抽象类中的和接口中的所有方法
 */
public abstract class Device {

    private int ID;
    private String name;

    public Device() {
    }

    public Device(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 抽象方法 startup
    public abstract void startup();

    // 抽象方法 shutdown
    public abstract void shutdown();

    @Override
    public String toString() {
        return "ID: " + ID + ", name: " + name;
    }
}
