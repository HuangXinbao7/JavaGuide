package test;

// 写一个Phone类, 包含属性os, screen.
public class Phone {

    private String os;
    private double screen;

    public Phone() {}

    public Phone(String os, double screen) {
        this.os = os;
        this.screen = screen;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOs() {
        return os;
    }

    public void setScreen(double screen) {
        this.screen = screen;
    }

    public double getScreen() {
        return screen;
    }

    public String say() {
        return "操作系统：" + os + ", 屏幕：" + screen;
    }
}
