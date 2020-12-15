package com.atguigu.javase.homework;

/**
 * 作业2：创建一个拥有10个子数组的二维数组，
 * 每个子数组的长度的随机的[3~8]，
 * 子数组里面保存的数据是100以内的随机整数
 * 对其进行排序
 */
public class ArrayTask {

    public static void main(String[] args) {
        // 创建一个拥有10个子数组的二维数组
        int[][] arrArr = new int[10][];
        for (int i = 0; i < arrArr.length; i++){
            // 每个子数组的长度是随机的[3~8]
            arrArr[i] = new int[3 + (int)(Math.random() * 6)];
            // 使用for循环给子数组的每个元素赋值
            for(int j = 0; j < arrArr[i].length; j++){
                arrArr[i][j] = (int)(Math.random() * 100);  // 100以内的随机整数
            }
        }

        // 遍历
        for(int[] child: arrArr) {
            for(int tmp: child) {
                System.out.print(tmp + " ");
            }
            System.out.println();
        }
        System.out.println("************************");

        // 排序方法1：冒泡排序
        // 外层循环控制遍历一维数组
        // 分别对每个子数组排序
        //for(int i = 0; i < arrArr.length; i++){
        //    // 中层循环控制遍历子数组
        //    for(int j = 0; j < arrArr[i].length; j++){
        //        // 内层循环控制比较交换，次数随着子数组遍历趟数的增加而减少
        //        for(int k = 0; k < arrArr[i].length - 1 - j; k++){
        //            if(arrArr[i][k] > arrArr[i][k + 1]){
        //                int tmp = arrArr[i][k];
        //                arrArr[i][k] = arrArr[i][k + 1];
        //                arrArr[i][k + 1] = tmp;
        //            }
        //        }
        //    }
        //}

        // 排序方法2：选择排序：以位置为主导，让基准位置保存最小值
        // 对整个数组排序
        for (int i = 0; i < arrArr.length; i++) {
            for (int j = 0; j < arrArr[i].length; j++) {
                // 以[i][j] 为基准位置
                int minIndexI = i;
                int minIndexJ = j;
                // 从基准位置开始到后面所有数中找出最小值的下标来
                for (int k = i; k < arrArr.length; k++) {
                    int begin = j + 1;  // 默认还是从当前子数组开始找
                    if(k != i){         // 换了新子数组后, 必须从0开始找
                        begin = 0;
                    }
                    for (int l = begin; l < arrArr[k].length; l++) {
                        if (arrArr[k][l] < arrArr[minIndexI][minIndexJ]) {
                            minIndexI = k;
                            minIndexJ = l;
                        }
                    }
                }
                int tmp = arrArr[i][j];
                arrArr[i][j] = arrArr[minIndexI][minIndexJ];
                arrArr[minIndexI][minIndexJ] = tmp;
            }
        }

        // 输出排序后数组
        System.out.println("排序后：");
        for(int[] ints: arrArr){
            for(int nInt: ints){
                System.out.print(nInt + " ");
            }
            System.out.println();
        }
    }
}
