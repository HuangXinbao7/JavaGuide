package com.xinbao.javase.chap02_basesystax.homework;

/**
 * 使用 switch 把小写类型的 char型转为大写。只转换 a, b, c, d, e. 其它的输出 “other”。
 * 提示: 接收命令行参数的字符方法
 * char ch = args[0].charAt(0);
 */
public class HomeWork4 {
    public static void main(String[] args){
        char ch = args[0].charAt(0);
        switch (ch){
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
                System.out.println((char)(ch - 32));
                break;
            default :
                System.out.println("other");
                break;
        }
    }
}


class HomeWork4_2 {
    public static void main(String[] args){

        char ch = args[0].charAt(0);
        String string = "other";    // 字符串中保存要打印的内容，在case中把内容备好

        switch (ch){
            case 'a' :
            case 'b' :
            case 'c' :
            case 'd' :
            case 'e' :
                string = "" + (char)(ch - 32);
        }
        System.out.println(string);
    }
}