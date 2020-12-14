package com.atguigu.javase.inheritance;

public class Device {

    private int id;
    private String name;
    private String factory;

    public Device() {
    }

    public Device(int id, String name, String factory) {
        this.id = id;
        this.name = name;
        this.factory = factory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String say() {
        return "ID : " + id + ", 名称 : " + name + ", 厂家 : " + factory;
    }
}
