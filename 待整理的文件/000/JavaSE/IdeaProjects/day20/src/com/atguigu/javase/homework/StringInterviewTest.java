package com.atguigu.javase.homework;

/**
 * 作业1：
 * 面试题，程序输出
 */
public class StringInterviewTest {

    public static void main(String[] args) {
        String str = null;
        // 无参构造初始容量为16
        StringBuffer sb = new StringBuffer();
        // 在 append 方法中：if(str == null) str = "null";
        // 即：调用append的时候参数是null，自动转成字符串处理
        // 所以此时 sb中存储的是字符串 "null"，长度也就等于4了
        sb.append(str);

        System.out.println(sb.length());    // 4
        System.out.println(sb);             // null

        // 报错: StringBuffer初始化 null，会报空指针异常
        // 风险在于：StringBuffer 构造器会调用 super(str.length() + 16);
        // 而 null 调用 length() 方法报错。触发空指针异常
        //StringBuffer sb1 = new StringBuffer(str);
        //System.out.println(sb1);
    }
}
