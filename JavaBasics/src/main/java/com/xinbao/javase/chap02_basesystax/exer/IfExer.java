package com.xinbao.javase.chap02_basesystax.exer;

import org.junit.Test;

import java.util.Scanner;

public class IfExer {

    /**
     * 编写程序：由键盘输入三个整数分别存入变量num1、num2、num3，
     * 对它们进行排序(使用 if-else if-else),并且从小到大输出。
     *
     * 说明：
     * 1. if-else结构是可以相互嵌套的。
     * 2. 如果if-else结构中的执行语句只有一行时，对应的一对{}可以省略的。但是，不建议大家省略。
     */
    @Test
    public void IfExer1() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入第一个整数：");
        int num1 = scanner.nextInt();
        System.out.println("请输入第二个整数：");
        int num2 = scanner.nextInt();
        System.out.println("请输入第三个整数：");
        int num3 = scanner.nextInt();

        if(num1 >= num2){
            if(num3 >= num1)
                System.out.println(num2 + "," + num1 + "," + num3);
            else if(num3 <= num2)
                System.out.println(num3 + "," + num2 + "," + num1);
            else
                System.out.println(num2 + "," + num3 + "," + num1);
        }else{
            if(num3 >= num2)
                System.out.println(num1 + "," + num2 + "," + num3);
            else if(num3 <= num1)
                System.out.println(num3 + "," + num1 + "," + num2);
            else
                System.out.println(num1 + "," + num3 + "," + num2);
        }
    }


    /**
     * 岳小鹏参加Java考试，他和父亲岳不群达成承诺：
     * 如果：
     * 	成绩为100分时，奖励一辆BMW；
     * 	成绩为(80，99]时，奖励一台iphone xs max；
     * 	当成绩为[60,80]时，奖励一个 iPad；
     * 	其它时，什么奖励也没有。
     * 请从键盘输入岳小鹏的期末成绩，并加以判断
     *
     * 说明：
     * 1. else 结构是可选的。
     * 2. 针对于条件表达式：
     *    > 如果多个条件表达式之间是“互斥”关系(或没有交集的关系),哪个判断和执行语句声明在上面还是下面，无所谓。
     *    > 如果多个条件表达式之间有交集的关系，需要根据实际情况，考虑清楚应该将哪个结构声明在上面。
     *    > 如果多个条件表达式之间有包含的关系，通常情况下，需要将范围小的声明在范围大的上面。否则，范围小的就没机会执行了。
     */
    @Test
    public void IfExer2() {
        Scanner scan = new Scanner(System.in);

        System.out.print("请输入岳小鹏期末成绩(0-100)：");
        int score = scan.nextInt();

        if(score == 100){
            System.out.println("奖励一辆BMW");
        }else if(score > 80 &&  score <= 99){
            System.out.println("奖励一台iphone xs max");
        }else if(score >= 60 && score <= 80){
            System.out.println("奖励一个 iPad");
        }else{
            System.out.println("什么奖励也没有");
        }
    }


    /**
     * 大家都知道，男大当婚，女大当嫁。那么女方家长要嫁女儿，当然要提出一定的条件：
     * 高：180cm以上；富：财富1千万以上；帅：是。
     * 如果这三个条件同时满足，则：“我一定要嫁给他!!!”
     * 如果三个条件有为真的情况，则：“嫁吧，比上不足，比下有余。”
     * 如果三个条件都不满足，则：“不嫁！”
     */
    @Test
    public void IfExer3() {
        Scanner scan = new Scanner(System.in);

        System.out.println("请输入你的身高：(cm)");
        int height = scan.nextInt();
        System.out.println("请输入你的财富：(千万)");
        double wealth = scan.nextDouble();

		/*
		方式一：
		System.out.println("请输入你是否帅：(true/false)");
		boolean isHandsome = scan.nextBoolean();

		if(height >= 180 && wealth >= 1 && isHandsome){
			System.out.println("我一定要嫁给他!!!");
		}else if(height >= 180 || wealth >= 1 || isHandsome){
			System.out.println("嫁吧，比上不足，比下有余。");
		}else{
			System.out.println("不嫁！");
		}
		*/

        //方式二：
        System.out.println("请输入你是否帅：(是/否)");
        String isHandsome = scan.next();


        if(height >= 180 && wealth >= 1 && isHandsome.equals("是")){
            System.out.println("我一定要嫁给他!!!");
        }else if(height >= 180 || wealth >= 1 || isHandsome.equals("是")){
            System.out.println("嫁吧，比上不足，比下有余。");
        }else{
            System.out.println("不嫁！");
        }
    }
}
