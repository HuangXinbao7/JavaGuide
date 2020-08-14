package com.atguigu.javase.homework;

/**
 * 在Week枚举中添加一个属性, String color. 添加两个构造器, 在声明常量对象时使用有参构造
 */
// 声明 Week 枚举类，其中包含星期一到星期日的定义
enum Week {
    // 显式调用有参构造方法
    MON("灰色"),
    TUE("黄色"),
    WED("白色"),
    THU("颜色4"),
    FRI("红色"),
    SAT("颜色6"),
    SUN("颜色7");

    private String color;

    // 构造器必须封装
    private Week() {}

    private Week(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}


public class WeekTest {

    //在TestWeek类中声明方法void printWeek(Week week)，根据参数值打印相应的中文星期字符串。
    //然后以第2步中的枚举值调用printWeek方法，输出中文星期。
    public void printWeek(Week week) {
        switch (week) {
            case MON :
                System.out.println("星期一");
                break;
            case TUE :
                System.out.println("星期二");
                break;
            case WED:
                System.out.println("星期三");
                break;
            case THU:
                System.out.println("星期四");
                break;
            case FRI:
                System.out.println("星期五");
                break;
            case SAT:
                System.out.println("星期六");
                break;
            case SUN:
                System.out.println("星期日");
                break;
        }
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if(n < 1 || n > 7) {
            System.out.println("星期输入错误");
            return;
        }
        Week[] values = Week.values();
        Week week = values[n - 1];
        System.out.println(week);
        new WeekTest().printWeek(week);

        //
        Week ws = Week.MON;
        System.out.println(ws);
    }
}
