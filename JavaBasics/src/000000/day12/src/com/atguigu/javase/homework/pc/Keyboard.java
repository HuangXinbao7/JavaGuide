package com.atguigu.javase.homework.pc;

/**
 * 写一个子类 Keyboard
 *      特有属性是 int keyCount, 按键个数
 *      特有方法：void type()，敲击
 */
public class Keyboard extends InputDevice {

    private int keyCount;

    public Keyboard(){}

    public Keyboard(int keyCount){
        this.keyCount = keyCount;
    }

    public void setKeyCount(int keyCount) {
        this.keyCount = keyCount;
    }

    public int getKeyCount() {
        return keyCount;
    }

    public void type(){
        System.out.println(getName()+" 正在被敲击...");
    }

}
