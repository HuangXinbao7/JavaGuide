package com.atguigu.javase.reflect;

import org.junit.Test;

import java.io.InputStream;

/**
 * 类加载器实例
 */
public class ClassLoaderTest {

    @Test
    public void test1() throws ClassNotFoundException {
        // 1、获取一个系统类加载器
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);    // sun.misc.Launcher$AppClassLoader@18b4aac2
        // 2、获取系统类加载器的父类加载器，即扩展加载器
        classLoader = classLoader.getParent();
        System.out.println(classLoader);    // sun.misc.Launcher$ExtClassLoader@677327b6
        // 3、获取扩展类加载器的父类加载器，即引导类加载器
        classLoader = classLoader.getParent();
        System.out.println(classLoader);    // null
        // 4、测试当前类由哪个类加载器进行加载
        classLoader = Class.forName("com.atguigu.javase.reflect.ClassLoaderTest").getClassLoader();
        System.out.println(classLoader);    // sun.misc.Launcher$AppClassLoader@18b4aac2
        // 5、测试JDK提供的Object类由哪个类加载器加载
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);    // null
        // 6、关于类加载器的一个主要方法:
        // getResourceAsStream(String srt)：获取类路径下的指定文件的输入流。
        InputStream is = null;
        is = this.getClass()
                .getClassLoader()
                .getResourceAsStream("com/atguigu/javase/reflect/ClassLoaderTest/testFile");
    }
}
