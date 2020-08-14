package com.atguigu.javase.inheritance;

public class Keyboard extends InputDevice {

    private int keyCount;

    public Keyboard() {}

    public Keyboard(int id, String name, String factory, int keyCount){
        super(id, name, factory);
        this.keyCount = keyCount;
    }

    public int getKeyCount() {
        return keyCount;
    }

    public void setKeyCount(int keyCount) {
        this.keyCount = keyCount;
    }

    @Override
    public String say() {
        return super.say() + ", 按键：" + keyCount;
    }

    public void type() {
        System.out.println("键盘在敲击。。。");
    }
}
