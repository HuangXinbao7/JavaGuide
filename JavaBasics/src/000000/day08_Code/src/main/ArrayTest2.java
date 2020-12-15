package main;

public class ArrayTest2 {

    public static void main(String[] args){
        // 创建一个数组，保存生日和今天的日期
        int[] arr = new int[6];
        arr[0] = 1991;
        arr[1] = 9;
        arr[2] = 7;
        arr[3] = 2020;
        arr[4] = 3;
        arr[5] = 28;

        // 打印输出生日和今天的日期
        System.out.println("生日：" + arr[0] + "年" + arr[1] + "月" + arr[2] + "日");
        System.out.println("今天是：" + arr[3] + "年" + arr[4] + "月" + arr[5] + "日");
    }
}
