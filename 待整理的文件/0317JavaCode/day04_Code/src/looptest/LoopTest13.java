package looptest;
/*
循环 : 在某些条件满足的情况下, 反复执行特定代码的功能.
组成部分 :
    1) 初始化语句 : 进行准备工作
    2) 循环条件语句 : 决定循环的生死, live or dead?
    3) 循环体 : 被多次执行的语句
    4) 迭代语句 : 使循环慢慢趋于结束. 如果没有迭代, 循环不能结束.
*/
public class LoopTest13 {

    public static void main(String[] args){
        // 打印100以内的所有质数
        boolean flag = true;    // flag 表示假定n是质数

        // 尝试证明n不是质数，只要在 2~n-1中找到一个数能整除n，那么这个数一定不是质数
        for (int i = 0; i < 100; i++){
            flag = true;    // 每次循环前，重置flag标志为true
            for (int j = 2; j < i; j++){
                if(i % j ==0){
                    flag = false;
                }
            }

            // 最后的结论肯定保存在flag中
            if(flag){
                System.out.println(i);
            }
        }
    }
}
