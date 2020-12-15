package com.xinbao.javase.chap02basesystax.homework;

/**
 * 接收命令行参数年、月、日，判断这一天是当年的第几天
 * 注：判断一年是否是闰年的标准：
 *  1）可以被4整除，但不可被100整除
 *  2）可以被400整除
 */
public class HomeWork5 {
    public static void main(String[] args) {
        // 2020, 2, 23
        int year = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);
        int day = Integer.parseInt(args[2]);

        int days = 0;
        switch (month) {
            case 2 :
                days += 31;
                break;
            case 3 :
                days += 31 + 28;
                break;
            case 4 :
                days += 31 + 28 + 31;
                break;
            case 5 :
                days += 31 + 28 + 31 + 30;
                break;
            case 6 :
                days += 31 + 28 + 31 + 30 + 31;
                break;
            case 7 :
                days += 31 + 28 + 31 + 30 + 31 + 30;
                break;
            case 8 :
                days += 31 + 28 + 31 + 30 + 31 + 30 + 31;
                break;
            case 9 :
                days += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
                break;
            case 10 :
                days += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
                break;
            case 11 :
                days += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
                break;
            case 12 :
                days += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
                break;
        }

        days += day;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            if (month > 2) {
                days += 1;
            }
        }
        System.out.println("是当年的第" + days + "天");
    }
}



class HomeWork5_2 {
    public static void main(String[] args){

        int year = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);
        int day = Integer.parseInt(args[2]);
        int days = day; // 变量的初始值的选择，尽量更有意义

        switch (month){
            case 12 :
                days += 30;
            case 11 :
                days += 31;
            case 10 :
                days += 30;
            case 9 :
                days += 31;
            case 8 :
                days += 31;
            case 7 :
                days += 30;
            case 6 :
                days += 31;
            case 5 :
                days += 30;
            case 4 :
                days += 31;
            case 3 :
                days += 28; // 有前设很重要，直接当成平年来看
                if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
                    days++;
                }
            case 2 :
                days += 31;
        }
        System.out.println(""+ days);
    }
}

