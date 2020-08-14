package com.atguigu.javase.wrapper;

/**
 * String 类
 */
public class StringClassTest {

    // 字符串对象操作
    public static void main(String[] args) {

        String s = "abc";
        String s2 = "abc";
        System.out.println(s.length());
        System.out.println(s.charAt(0));
        System.out.println(s.toCharArray());
        System.out.println(s.equals(s2));       // true
        System.out.println("abcabc".compareTo("aaa"));

    }

    // 判断
    public static void main2(String[] args) {
        String s1 = "atguigu";
        String s2 = "java";
        String s4 = "java";
        String s3 = new String("java");
        System.out.println(s2 == s3);		// false
        System.out.println(s2 == s4);		// ture
        System.out.println(s2.equals(s3));		// ture

        String s5 = "atguigujava";
        String s6 = (s1 + s2).intern();
        System.out.println(s5 == s6);           // true
        System.out.println(s5.equals(s6));      // true
    }

    // String类较为常用的构造方法
    public static void main1(String[] args) {

        String s1 = new String("111");
        char a = 'A';
        //String s2 = new String(char[] a);
    }
}
