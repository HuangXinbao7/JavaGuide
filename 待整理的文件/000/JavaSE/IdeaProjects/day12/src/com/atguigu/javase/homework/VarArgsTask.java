package com.atguigu.javase.homework;


/**
 * 作业三：
 * 写一个方法 public static int min()    // 使用可变参数. 调用此方法打印最小值
 */
public class VarArgsTask {

    public static int min(int... values){
        int minNum = values[0];    // 假设传入的参数中第一个是最小值
        for (int i = 0 ; i < values.length; i++){
            if(minNum > values[i]){
                minNum = values[i];
            }
            //System.out.print(values[i] + " ");
        }
        //System.out.println();
        System.out.println("最小值: " + minNum);
        return minNum;
    }


    public static void main(String[] args) {
        // 定义一个数组
        int[] arr = new int[]{100, 20, 33, 42, 51, 6};
        // 调用方法，以数组 arr 为参数
        min(arr);
    }
}
