package com.atguigu.javase.array;

// 二维数组：数组的数组，它的元素是子数组
public class ArrayArrayTest {

    public static void main(String[] args) {
        // 创建了拥有4个子数组的数组，子数组还没有产生
        int[][] arrArr = new int[4][];
        arrArr[0] = new int[3];
        arrArr[1] = new int[4];
        arrArr[2] = new int[2];
        arrArr[3] = new int[5];

        // 循环给子数组中的元素赋值，子数组中的元素默认值全是 0
        // arrArr.length是子数组个数
        for (int i = 0; i < arrArr.length; i++){
            int[] child = arrArr[i];
            for(int j = 0; j < child.length; j++){
                child[j] = (int)(Math.random() * 50);   // [0~50)
            }
        }

        // 遍历数组的数组
        for (int[] child: arrArr){
            for(int tmp: child){
                System.out.print(tmp + " ");
            }
            System.out.println();
        }

        // 求平均值
        int sum = 0;
        int count = 0;
        for(int[] child: arrArr){
            for(int tmp: child){
                sum += tmp;
                count++;
            }
        }
        int avg = sum / count;
        System.out.println("avg: " + avg);


    }

    // 二维数组的声明和初始化
    public static void main1(String[] args) {
        // 这种定义方法更灵活，可以是声明和初始化分开
        int[][] arrArr1 = new int[][] {{1,2,3,4}, {9,2}, {8}};
        // 这种定义方法只适用于声明和初始化在同一条语句上
        int[][] arrArr2 = {{9,2}, {1,8,7}, {5,4,3,2,1}, {0}, {100}, {200}};
        //arrArr2 = {{1,2}};    报错
        arrArr2 = new int[][]{{1,2}, {3,4}};
    }

}
