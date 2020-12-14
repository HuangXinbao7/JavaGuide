package com.xinbao.javase.chap02_basesystax.exer;

import org.junit.Test;
import java.util.Scanner;


public class SwitchCaseExer {

    /**
     * 编写程序：从键盘上输入2019年的“month”和“day”，要求通过程序输出输入的日期为2019年的第几天。
     *
     * 2  15:  31 + 15
     *
     * 5 7: 31 + 28 + 31 + 30 + 7
     *
     * ....
     *
     * 说明:break在switch-case中是可选的
     */
    @Test
    public void test1() {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入2019年的month：");
        int month = scan.nextInt();
        System.out.println("请输入2019年的day：");
        int day = scan.nextInt();


        //定义一个变量来保存总天数
        int sumDays = 0;

        //方式一：冗余
		/*

		if(month == 1){
			sumDays = day;
		}else if(month == 2){
			sumDays = 31 + day;
		}else if(month == 3){
			sumDays = 31 + 28 + day;
		}else if(month == 4){
			sumDays = 31 + 28 + 31 + day;
		}
		//...
		else{//month == 12
			//sumDays = ..... + day;
		}

		*/

        //方式二：冗余
		/*
		switch(month){
		case 1:
			sumDays = day;
			break;
		case 2:
			sumDays = 31 + day;
			break;
		case 3:
			sumDays = 31 + 28 + day;
			break;
		...
		}
		*/

        switch(month){
            case 12:
                sumDays += 30;
            case 11:
                sumDays += 31;
            case 10:
                sumDays += 30;
            case 9:
                sumDays += 31;
            case 8:
                sumDays += 31;
            case 7:
                sumDays += 30;
            case 6:
                sumDays += 31;
            case 5:
                sumDays += 30;
            case 4:
                sumDays += 31;
            case 3:
                sumDays += 28;
            case 2:
                sumDays += 31;
            case 1:
                sumDays += day;
        }

        System.out.println("2019年" + month + "月" + day + "日是当年的第" + sumDays + "天");
    }


    /**
     * 例题：对学生成绩大于60分的，输出“合格”。低于60分的，输出“不合格”。
     *
     * 说明：如果switch-case结构中的多个case的执行语句相同，则可以考虑进行合并。
     */
    @Test
    public void test2() {
        /*
		int score = 78;
		switch(score){
		case 0:

		case 1:

		case 2:

			...
		case 100:

		}
		*/

		/*
		int score = 78;
		if(score >= 60){

		}else{

		}
		*/

        int score = 78;
        switch(score / 10){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("不及格");
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                System.out.println("及格");
                break;
        }

        //更优的解决方案：
        switch(score / 60){
            case 0:
                System.out.println("不及格");
                break;
            case 1:
                System.out.println("及格");
                break;
        }
    }


    /**
     * 从键盘分别输入年、月、日，判断这一天是当年的第几天
     *
     *    注：判断一年是否是闰年的标准：
     *        1）可以被4整除，但不可被100整除
     * 	或
     *        2）可以被400整除
     *
     *
     * 说明：
     * 1. 凡是可以使用switch-case的结构，都可以转换为if-else。反之，不成立。
     * 2. 我们写分支结构时，当发现既可以使用switch-case,（同时，switch中表达式的取值情况不太多），
     *   又可以使用if-else时，我们优先选择使用switch-case。原因：switch-case执行效率稍高。
     */
    @Test
    public void test3() {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入year：");
        int year = scan.nextInt();
        System.out.println("请输入month：");
        int month = scan.nextInt();
        System.out.println("请输入day：");
        int day = scan.nextInt();


        //定义一个变量来保存总天数
        int sumDays = 0;

        switch(month){
            case 12:
                sumDays += 30;
            case 11:
                sumDays += 31;
            case 10:
                sumDays += 30;
            case 9:
                sumDays += 31;
            case 8:
                sumDays += 31;
            case 7:
                sumDays += 30;
            case 6:
                sumDays += 31;
            case 5:
                sumDays += 30;
            case 4:
                sumDays += 31;
            case 3:
                //sumDays += 28;
                //判断year是否是闰年
                if((year % 4 == 0 && year % 100 != 0 ) || year % 400 == 0){
                    sumDays += 29;
                }else{
                    sumDays += 28;
                }

            case 2:
                sumDays += 31;
            case 1:
                sumDays += day;
        }

        System.out.println(year + "年" + month + "月" + day + "日是当年的第" + sumDays + "天");

    }
}
