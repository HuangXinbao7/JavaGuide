package com.atguigu.javase.polymorphism;

public class American extends Person {

    private boolean hasGun;

    public American(){}

    public American(String name, int age, String gender, boolean hasGun) {
        super(name, age, gender);
        this.hasGun = hasGun;
    }

    // boolean 属性的get方法，格式：isXXx();
    public boolean isHasGun(){
        return hasGun;
    }

    public void setHasGun(boolean hasGun) {
        this.hasGun = hasGun;
    }

    public void thanks() {
        System.out.println("Thank GOD");
    }

    @Override
    public String say() {
        return super.say() + ", 有枪：" + hasGun;
    }

    @Override
    public void sayHello() {
        System.out.println("Hey Man");
    }
}
