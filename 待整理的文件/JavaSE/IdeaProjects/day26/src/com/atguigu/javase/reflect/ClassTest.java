package com.atguigu.javase.reflect;

import org.junit.Test;

import java.lang.reflect.*;

/**
 *
 */
public class ClassTest {

    @Test
    public void test1() throws Exception {
        String name = "com.atguigu.javase.reflection.Person";
        Class clazz = null;
        clazz = Class.forName(name);

        Constructor con = clazz.getConstructor(String.class, Integer.class);

        Person p = (Person)con.newInstance("Peter", 20);
        System.out.println(p);
    }
}
