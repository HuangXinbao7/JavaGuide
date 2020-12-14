package com.atguigu.javase.test;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Class类模板对象, 获取类模板对象4种
 *  1) 类.class
 *  2) 对象.getClass()
 *  3) Class.forName("全限定类名");
 *  4) 类加载器对象.loadClass("类名");
 */
public class ReflectTest {

    private int id;
    private String name;

    @Override
    public String toString() {
        return "ReflectTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void hello() {
        System.out.println("hello");
    }

    public void hello2(int n, double d, boolean b, String s) {
        System.out.println("参数:" + n + d + b + s);
    }


    @Test
    public void test1() throws Exception {

        // 最简单，最直接，最高效，最安全，创建对象直接是本态
        Class<ReflectTest> clazz1 = ReflectTest.class;
        ReflectTest reflectTest1 = clazz1.newInstance();

        // 比较简单，并且可以直接赵兴
        Class<? extends ReflectTest> clazz2 = new ReflectTest().getClass();
        ReflectTest reflectTest2 = clazz2.newInstance();

        // 最灵活，类完全是变化的
        Class<?> clazz3 = Class.forName("com.atguigu.javase.test.ReflectTest");
        Object obj3 = clazz3.newInstance();

        // 获取属性定义
        //Field id = clazz3.getField("id");
        Field id = clazz3.getDeclaredField("id");
        id.set(obj3, 100);
        System.out.println(this.id);
        System.out.println(obj3);

        // 获取类方法
        Method hello = clazz3.getMethod("hello");
        hello.invoke(obj3);

        // 获取父类
        Class<?> superclass = clazz3.getSuperclass();
        System.out.println("父类：" + superclass);

        // Class对象表示类型，只要是java中的类型，只要是java中的类型，一定会有一个Class对象和它对应。
        Method hello2 = clazz3.getMethod("hello2", int.class, double.class, boolean.class, String.class);
        hello2.invoke(obj3, 10, 2.3, false, "abc");
    }
}
