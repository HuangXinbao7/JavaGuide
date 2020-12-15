package com.xinbao.javase.chap02_basesystax.homework;

/**
 * 第三题：
 * 打印100~200之间的所有质数, 要求, 循环因子的变量名换一下
 */
public class HomeWork7 {
    public static void main(String[] args){
        for(int j = 100; j <= 200; j++){
            for(int k = 2; k < j; k++){
                if(j % k == 0) {
                    break;
                }
                System.out.println(j);
                break;
            }
        }
    }
}


// 答案
class HomeWork7_2 {

    public static void main(String[] args){

        for(int i = 100; i <= 200; i++){
            // 判断i是否是质数，假设i是质数
            boolean flag = true;
            // 尝试推翻假设，从2~n-1中随便找到一个数可以整除i
            for (int j = 2; j < i; j++){
                if (i % j == 0) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println(i + "是质数");
            }
        }
    }
}


// 求质数的方法
class HomeWork7_3 {
    public static void main(String[] args){

        int n = 97;
        boolean flag = true;    // n是质数，只能被1和自身整除的数

        // 只需要找到一个反例，推翻假设，从2~n-1中随机找到一个数可以整除n，就推翻
        for (int i = 2; i < n; i++){    // 循环中，循环因子就是从2开始到n-1的
            if (n % i == 0) {           // 如果n被某个i整除了，说明n肯定不是质数
                flag = false;   // 推翻假设
            }
        }

        // 本质上是统计运算，必须在循环以后出结果
        // 如果循环结果以后，flag仍没有被刷过值，说明没有找到反例
        if (flag) {
            System.out.println(n + "是质数");
        }
    }
}