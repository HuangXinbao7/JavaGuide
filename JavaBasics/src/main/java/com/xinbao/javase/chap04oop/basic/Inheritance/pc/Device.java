package com.xinbao.javase.chap04oop.basic.Inheritance.pc;

// 写一个类Device 设备, id, name, factory

/**
 * 写一个类 Device 设备
 *      id          设备id
 *      name        设备名称
 *      factory     厂家
 */
public class Device {

    private int id;
    private String name;
    private String factory;

    public Device(){}

    public Device(int id, String name, String factory){
        this.id = id;
        this.name = name;
        this.factory = factory;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getFactory() {
        return factory;
    }

    public String getDetails(){
        return "id: " + id + ", 名称: " + name + ", 厂家: " + factory;
    }
}
