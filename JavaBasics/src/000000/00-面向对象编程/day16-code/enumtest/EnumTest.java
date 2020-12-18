package com.atguigu.javase.enumtest;

/**
 * 枚举 : 对象是固定的有限的,可数的一种特殊类型
 */
enum TrafficSignal {

    STOP(10), GO(20), CAUTION; // 这是3个全局常量对象的引用, 默认使用无参构造

    private int seconds;

    private TrafficSignal() {}

    private TrafficSignal(int seconds) {
        this.seconds = seconds;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return super.toString() + ", 秒 : " + seconds;
    }
}

public class EnumTest {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        //TrafficSignal ts = new TrafficSignal();
        TrafficSignal ts = TrafficSignal.CAUTION; // 直接获取对象
        System.out.println(ts);

        ts = TrafficSignal.valueOf("STOP"); // 根据参数给定的名字获取相应的对象, 大小写敏感
        System.out.println(ts);

        System.out.println("***********************************");

        TrafficSignal[] values = TrafficSignal.values(); // 获取所有对象的数组
        ts = values[n];

        System.out.println(ts); // ts引用指向枚举对象不确定.
        switch (ts) { // ts必须变量, 变量类型可以是非long整数, 字符串, 枚举
            case GO :
                System.out.println("绿灯行");
                break;
            case STOP :
                System.out.println("红灯停");
                break;
            case CAUTION :
                System.out.println("黄灯慢");
                break;
        }
    }
}
