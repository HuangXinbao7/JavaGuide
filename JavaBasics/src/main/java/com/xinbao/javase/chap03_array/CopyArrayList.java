package com.xinbao.javase.chap03_array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by XinB on 2020/8/19 7:10
 *
 * Copy ArrayList的四种方式
 */
public class CopyArrayList {

    /**
     * 使用构造函数
     */
    @Test
    public void withConstructor() {
        ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList("a", "b", "c"));
        ArrayList<String> copyList = new ArrayList<>(stringArrayList);

        copyList.set(0, "D");

        System.out.println(stringArrayList.toString());

        System.out.println(copyList.toString());
    }

}
