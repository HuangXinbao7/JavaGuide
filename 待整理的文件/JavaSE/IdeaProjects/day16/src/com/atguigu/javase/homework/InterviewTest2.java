package com.atguigu.javase.homework;

/**
 * 面试题2：排错
 */
interface Playable {
    void play();
}

interface Bounceable {
    void play();
}

interface Rollable extends Playable, Bounceable {
    Ball ball = new Ball("PingPang");       // 接口中定义的变量默认是 public static final 的
}


class Ball implements Rollable {
    private String name;
    private String getName() {
        return name;
    }

    public Ball(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        //ball = new Ball("Football");      // final变量不可重新赋值
        System.out.println(ball.getName());
    }
}


public class InterviewTest2 {}
