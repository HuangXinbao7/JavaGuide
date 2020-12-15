package com.xinbao.javase.chap02_basesystax.homework;

// 答案
class HomeWork3{
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