package com.atguigu.javase.test;


import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;

public class Demo {

    /**
     * 第一个人 10 岁，第2个比第1个人大2岁，以此类推，请用递归方式计算出第8个人多大？
     */

    static int sui(int n){
        if (n == 1) {
            return 10;
        } else {
            return sui(n-1) + 2;
        }
    }

    static long f(int n) {
        long sum = 0L;
        for(int i = n; i > 0; i--) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {

        int n = 8;  // 第8个人
        System.out.println(sui(n));
    }
}
