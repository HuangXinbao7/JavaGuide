package com.atguigu.javase.string;

import org.junit.Test;

/**
 * StringBuffer: 字符串
 *      内容可以改变的 Unicode 字符序列，内部仍然使用 char[] 保存字符序列，可以添加和删除的
 *      对它的修改不会产生新对象
 *
 * StringBuilder 是最新的替代 StringBuffer，速度更快，线程不安全。
 * StringBuffer 是老的 API，速度慢，线程安全。
 *
 */
public class StringTest {

    /**
     * 练习：
     * 声明3个字符串，以第1个字符串为实参创建 StringBuffer对象
     * 把第2个串串接到后面
     * 把第3个串插入到最前面
     */
    @Test
    public void test() {

        // 声明3个字符串
        String s1 = "123";
        String s2 = "abc";
        String s3 = "AAA";

        // 用 StringBuilder替代StringBuffer
        // 以第1个字符串为实参创建 StringBuffer对象。这里创建 StringBuilder
        StringBuilder sb = new StringBuilder(s1);
        //// 把第2个串串接到后面
        //sb.append(s2);
        //// 把第3个串插入到最前面
        //sb.insert(0, s3);

        // 使用链式操作
        sb.append(s2).insert(0, s3);

        // 输出
        System.out.println(sb);
    }
}
