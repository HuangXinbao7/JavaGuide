package com.xinbao.javase.array;

public class ArrayTest {

    // 翻转数组：循环数组长度的一半，首尾交换
    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 20);
        }

        // 遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        // 0  1 2 3 4  5 6 7
        // 11 4 6 9 18 5 9 16
        // 反转, 头变尾,
        // 翻转数组：循环数组长度的一半，首尾交换
        for (int i = 0; i < arr.length / 2; i++){
            // 交换i位置和arr.length - 1 - i 位置的值
            int tmp = arr[i];   // 临时变量必须使用数组元素类型
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }

        // 遍历
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    // 找最大值 : 找最大值的位置(下标)
    // 使用下标的方式找出最小值
    public static void main7(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 20);
        }

        // 遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 0 1 2 3 4 5  6  7
        // 1 3 5 7 9 11 13 15
        // 找最大值：通过最大值的下标
        int maxIndex = 0;   // 假设下标为0的元素的值最大
        int minIndex = 0;   // 假设下标为0的元素的值最大
        for (int i = 0; i < arr.length; i++){
            if(arr[i] > arr[maxIndex]){     // 如果i位置的元素值大于maxIndex位置的元素值
                maxIndex = i;
            }
            if(arr[i] < arr[minIndex]){     // 如果i位置的元素值小于minIndex位置的元素值
                minIndex = i;
            }
        }
        System.out.println("最大值：" + arr[maxIndex]);
        System.out.println("最小值：" + arr[minIndex]);
    }


    // 能被7整除的数的最大值
    // 能被7整除的数的最小值
    public static void main6(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 20);
        }

        // 遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        //  0 1  2  3 4 5 6  7
        // 13 16 13 5 1 2 19 2
        // 找最大值
        int max = 0x80000000 ; // 1000 0000 0000 0000 0000 0000 0000 0000 // 无法直接获取某个元素的值.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("max = " + max);
        // 最小值
        int min = 0x7FFFFFFF;// 0111 1111 ....;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("min = " + min);

        // 0 1 2 3 4 5  6  7
        // 1 3 5 7 9 11 13 15
        // 能被7整除的数的最大值
        int max7 = 0x80000000;   // 让它的值最小，这样只要是整数就一定会比它大，从而刷新它的值
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % 7 == 0){
                if (arr[i] > max7){
                    max7 = arr[i];
                }
            }
        }
        if (max7 == 0x80000000){
            System.out.println("没有能被7整除的数");
        }else{
            System.out.println("能被7整除的最大值：" + max7);
        }

        // 能被7整除的数的最小值
        int min7 = 0x7FFFFFFF;   // 让它的值最大，这样只要是整数就一定会比它小，从而刷新它的值
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % 7 == 0){
                if (arr[i] < min7){
                    min7 = arr[i];
                }
            }
        }
        if (min7 == 0x7FFFFFFF){
            System.out.println("没有能被7整除的数");
        }else{
            System.out.println("能被7整除的最小值：" + min7);
        }
    }

    // 找最大值和最小值
    public static void main5(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 20);
        }

        // 遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 0 1 2 3 4 5  6  7
        // 1 3 5 7 9 11 13 15
        // 找最大值
        int max = arr[0];   // 先假设第一个元素的值最大
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("max = " + max);

        // 找最小值
        int min = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println("min = " + min);
    }

    // 求所有能被7整除的数的平均值
    // 求能被5整除的数的平均值
    public static void main4(String[] args) {

        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 20);
        }

        // 遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 0 1 2 3  4 5  6  7
        // 7 1 8 18 3 17 10 6
        // 求所有能被7整除的数的平均值
        int sum = 0;
        int count = 0;  // 计数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 7 == 0) {
                sum += arr[i];
                count++;
            }
        }
        if (count == 0) {
            System.out.println("没有能被7整除的数");
        }else{
            int avg = sum / count;
            System.out.println("avg: " + avg);
        }

        // 求能被5整除的数的平均值
        sum = 0;
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 5 == 0) {
                sum += arr[i];
                count++;
            }
        }
        if (count == 0){
            System.out.println("没有能被5整除的数");
        }else{
            int avg = sum / count;
            System.out.println("avg: " + avg);
        }
    }

    // 求平均值，先求和
    public static void main3(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * 20);
        }

        // 遍历
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        // 0  1  2  3  4  5 6 7
        // 13 18 16 15 19 9 8 14
        // 求平均值，先求和
        double sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        double avg = sum / arr.length;
        System.out.println("avg: " + avg);
    }

    // 随机数
    public static void main2(String[] args) {
        // 随机数
        double random1 = Math.random(); // [0~1) 随机浮点数
        System.out.println(random1);

        // 100以内的随机浮点数
        double random2 = Math.random() * 100;
        System.out.println(random2);

        // 100以内的随机整数
        int random3 = (int)(Math.random() * 100);
        System.out.println(random3);

        // 练习：产生一个随机的 [30, 70) 之间的整数
        // 思路：30 加上40以内的随机整数
        //int random4 = 30 + (int)(Math.random() * 40);
        int random4 = (int)(Math.random() * 40 + 30);
        System.out.println(random4);
    }

    // 数组的声明和创建
    public static void main1(String[] args) {
        // 数组的声明和创建，元素类型[] 数组名 = new 元素数据类型[长度];
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 2 * i + 1;
        }

        // 遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 求和
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("sum: " + sum);

        // 求平均值
        int avg = sum / arr.length;
        System.out.println("avg: " + avg);
    }
}
