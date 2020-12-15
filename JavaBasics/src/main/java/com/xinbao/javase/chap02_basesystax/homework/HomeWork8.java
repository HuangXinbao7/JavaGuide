package com.xinbao.javase.chap02_basesystax.homework;

/**
 * 第四题：
 * 求1000以内所有质数的平均值
 */
public class HomeWork8 {
    public static void main(String[] args){

        int total = 0;
        int count = 0;

        for(int j = 1; j <= 1000; j++){
            for(int k = 2; k <= j; k++){
                if(j % k == 0) {
                    break;
                }
                total += j;
                count++;
                break;
            }
        }

        double avg = (double) total / count;
        System.out.println(avg);
    }
}



// 答案
class HomeWork44 {
    public static void main(String[] args){

        int sum = 0;
        int count = 0;
        boolean flag = true;

        for(int j = 2; j <= 1000; j++){
            flag = true;    // 假定j是质数

            for(int i = 2; i < j; i++){
                if(j % i == 0) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println(j + "是质数");
                sum += j;
                count++;
            }
        }
        System.out.println("sum: " + sum);
        System.out.println("count: " + count);


        int avg = sum / count;
        System.out.println("avg: " + avg);
    }
}
