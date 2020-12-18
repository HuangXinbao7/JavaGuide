package com.atguigu.javase.homework;

public class PrintTriangle {

    /**
     * 作业2：使用二维数组打印一个 10 行杨辉三角.
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3  1
     * 1 4 6  4  1
     * 1 5 10 10 5 1
     * 1 6 15 20 15 6 1
     *  ....
     * int[][] yanghui = new int[10][];
     *  for (int i = 0;  i < 10; i++) {
     *    yanghui[i] = new int[i + 1];
     * }
     * 【提示】
     *  1. 第一行有 1 个元素, 第 n 行有 n 个元素
     *  2. 每一行的第一个元素和最后一个元素都是 1
     *  3. 从第三行开始, 对于非第一个元素和最后一个元素的元素.
     *      yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j];
     */
    public static void main(String[] args) {

        // 初始化一个用于10个子数组的二维数组
        int[][] yangHui = new int[10][];
        // 外层循环控制行数
        for (int i = 0; i < 10; i++){
            // 创建第n行的子数组，长度为n
            yangHui[i] = new int[i + 1];
            // 内循环控制i+1行的数据
            for(int j = 0; j < yangHui[i].length; j++){
                // 第一行，是一个数字 1
                if(i == 0){
                    yangHui[i][j] = 1;
                }
                // 第二行，是两个数字 1 1
                if(i == 1){
                    yangHui[i][j] = 1;
                }
                // 第三行开始，对于非第一个元素和最后一个元素的元素
                // yangHui[i][j] = yangHui[i-1][j-1] + yangHui[i-1][j];
                else {
                    if (j == 0 || j == yangHui[i].length - 1) {
                        yangHui[i][j] = 1;
                    }else {
                        yangHui[i][j] = yangHui[i-1][j-1] + yangHui[i-1][j];
                    }
                }
            }
        }

        // 使用增强型 foreach 遍历
        for (int[] ints : yangHui) {
            for (int anInt : ints) {
                // 打印数据
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
