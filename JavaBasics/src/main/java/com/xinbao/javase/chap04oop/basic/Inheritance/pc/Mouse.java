package com.xinbao.javase.chap04oop.basic.Inheritance.pc;

/**
 * 写一个类 Mouse，鼠标
 *      特有属性是 String color
 *      特有方法：void move()
 */
public class Mouse extends InputDevice {

    private String color;

    public Mouse(){}

    // 全参
    public Mouse(int id, String name, String factory, String color){
        // 不能调用间接父类构造，直接父类。。
        super(id, name, factory);
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    //@Override
    //public String say() {
    //    return super.say() + ", 颜色：" + color;
    //}


    public void move(){
        System.out.println(getName() + ", 正在移动...");
    }
}
