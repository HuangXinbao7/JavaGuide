package com.test.javase.demo;

import java.util.ArrayList;
import java.util.List;

public class Counter implements Runnable{

    private int counter = 200;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            counter -= 2;
            try {
                Thread.sleep(10);
                System.out.println(counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
