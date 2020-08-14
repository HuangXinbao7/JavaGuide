package com.atguigu.javase.stringbuffer;

import org.junit.Test;

public class StringBufferTest {

    @Test
    public void test1() {

        String s = new String("我喜欢学习");     // 实体不可再改变
        StringBuffer buffer = new StringBuffer("我喜欢学习");    // 实体可以改变

        buffer.append("数学");

    }
}
