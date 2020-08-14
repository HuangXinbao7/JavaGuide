package com.test;

/**
 * @author XinB
 * @create 2020-05-03-18:44
 */
public class Demo01 {

    /**
     * 列出1-1000内不包含4的数字
     */
    public static void main(String[] args) {
        for (int i = 1; i < 1000; i++) {
            if(!hasFour(i)) {
                System.out.println(i);
            }
        }
    }


    public static boolean hasFour(int num) {
        return String.valueOf(num).contains("4");
    }
}
