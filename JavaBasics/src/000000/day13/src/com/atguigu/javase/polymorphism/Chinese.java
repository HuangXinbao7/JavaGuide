package com.atguigu.javase.polymorphism;

public class Chinese extends Person {

    // 特有属性：属相
    private String shuxiang;

    public Chinese() {}

    public Chinese(String name, int age, String gender, String shuxiang) {
        super(name, age, gender);
        this.shuxiang = shuxiang;
    }

    public String getShuxiang() {
        return shuxiang;
    }

    public void setShuxiang(String shuxiang) {
        this.shuxiang = shuxiang;
    }

    // 特有方法：过春节
    public void spring() {
        System.out.println("过大年，真高兴，放鞭炮");
    }

    @Override
    public String say() {
        return super.say() + ", 属相：" + shuxiang;
    }

    @Override
    public void sayHello() {
        System.out.println("你好，吃了吗");
    }
}
