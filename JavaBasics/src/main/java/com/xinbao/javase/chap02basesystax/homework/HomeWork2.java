package com.xinbao.javase.chap02basesystax.homework;

/**
 * 编写程序：接收三个命令行字符串并转换为整数分别存入变量num1、num2、num3，
 * 对它们进行排序(使用 if-else if-else),并且从小到大输出。
 */
public class HomeWork2 {
    public static void main(String[] args){

        // 设置运行参数 Program arguments
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);

        if(num1 < num2){
            if(num2 < num3){        // 当 num3 最大时
                System.out.println("从小到大的顺序为：" + num1 + ", " + num2 + ", " + num3);
            }else if(num1 > num3){      // 当 num3 最小时
                System.out.println("从小到大的顺序为：" + num3 + ", " + num1 + ", " + num2);
            }else{      // num3 的大小位于 num1 和 num2 之间
                System.out.println("从小到大的顺序为：" + num1 + ", " + num3 + ", " + num2);
            }
        }else{  // num1 > num2
            if(num3 > num1){        // 当 num3 最大时
                System.out.println("从小到大的顺序为：" + num2 + ", " + num1 + ", " + num3);
            }else if(num3 < num2){      // 当 num3 最小时
                System.out.println("从小到大的顺序为：" + num3 + ", " + num2 + ", " + num1);
            }else{      // num3 的大小位于 num2 和 num1 之间
                System.out.println("从小到大的顺序为：" + num2 + ", " + num3 + ", " + num1);
            }
        }
    }
}


// 答案
class HomeWork2_2{
    public static void main(String[] args){
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);

        //
        if(num1 < num2){    // 1 < 2
            if(num2 < num3){        // 1 < 2, 2 < 3
                System.out.println("从小到大的顺序为：" + num1 + ", " + num2 + ", " + num3);
            }else if(num1 < num3){      // 1 < 2, 3 < 2, 1 < 3
                System.out.println("从小到大的顺序为：" + num1 + ", " + num3 + ", " + num2);
            }else{      // 1 < 2, 3 < 2, 3 < 1
                System.out.println("从小到大的顺序为：" + num3 + ", " + num1 + ", " + num2);
            }
        }else{  // 2 < 1
            if(num3 < num2){        // 2 < 1, 3 < 2
                System.out.println("从小到大的顺序为：" + num3 + ", " + num2 + ", " + num1);
            }else if(num1 < num3){      // 2 < 1, 2 < 3, 1 < 3
                System.out.println("从小到大的顺序为：" + num2 + ", " + num1 + ", " + num3);
            }else{      // 2 < 1, 2 < 3, 3 < 1
                System.out.println("从小到大的顺序为：" + num2 + ", " + num3 + ", " + num1);
            }
        }
    }
}


// 优化
class HomeWork2_3{
    public static void main(String[] args){
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);

        // 目标是左小右大, 如果左大右小，就交换
        if (num1 > num2) {
            int tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        // 此时num2中保存的是1和2中的较大值
        if (num2 > num3) {
            int tmp = num2;
            num2 = num3;
            num3 = tmp;
        }
        // 此时num3中保存的是2和3中的较大值，因为2中已经是1和2中的最大值，所以3中保存的1和2和3的最大值
        if (num1 > num2) {
            int tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        // 此时num2中保存的是1和2中的最大值，num2完成

        // 固定输出，先要保证num1中保存最小，num2中保存中值，num3中保存最大值
        System.out.println(num1 + "," + num2 + "," + num3);
    }
}
