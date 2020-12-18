package com.atguigu.javase.enumtest;

//声明Week枚举类，其中包含星期一至星期日的定义；
enum Week {
    MON, TUE, WED, THU, FRI, SAT, SUN
}
//在main方法中从命令行接收一个1-7的整数(使用Integer.parseInt方法转换)，
// 分别代表星期一至星期日，打印该值对应的枚举值，

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
        if (n < 1 || n > 7) {
            System.out.println("星期输入非法");
            return;
        }
        Week[] values = Week.values();
        Week week = values[n - 1];
        System.out.println(week);
        new WeekTest().printWeek(week);
    }
}
