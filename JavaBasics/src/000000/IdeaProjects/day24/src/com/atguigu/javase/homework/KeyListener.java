package com.atguigu.javase.homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyListener implements Runnable {

    // 对象关联
    private Runnable runner1;

    public KeyListener(Runnable runner1) {
        this.runner1 = runner1;
    }

    @Override
    public void run() {

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String line;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }
}
