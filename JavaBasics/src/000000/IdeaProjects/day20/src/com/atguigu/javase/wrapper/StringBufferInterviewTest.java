package com.atguigu.javase.wrapper;

/**
 * 面试题
 */
public class StringBufferInterviewTest {

    public static void main(String[] args) {

        String a = "123";
        String b = "123";
        String c = new String("123");
        String d = new String("123");

        System.out.println(a.equals(b));    // true
        System.out.println(a == b);         // true
        System.out.println(c.equals(d));    // true
        System.out.println(c == d);         // false
        System.out.println(a.equals(c));    // true
        System.out.println(a == c);         // false
    }

    // 程序输出
    public static void main1(String[] args) {

        String str = null;
        StringBuffer sb = new StringBuffer();   // 无参构造初始容量为16
        sb.append(str);     // 等价于：sb.append((String) null);

        System.out.println(sb.length());    // 4
        System.out.println(sb);             // null

        //StringBuffer sb1 = new StringBuffer(str);   // 报错
        //System.out.println(sb1);    //
    }
}
