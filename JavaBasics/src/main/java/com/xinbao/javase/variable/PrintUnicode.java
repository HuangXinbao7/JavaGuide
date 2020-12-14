package org.example.javabasics.variable;

public class PrintUnicode {

    public static void main(String[] args) {

        char c1 = '中';
        char c2 = '文';
        char c3 = '字';

        System.out.println((int)c1);
        System.out.println((int)c2);
        System.out.println((int)c3);

        c1 = (char)(c1+1);
        System.out.println(c1);
    }
}
