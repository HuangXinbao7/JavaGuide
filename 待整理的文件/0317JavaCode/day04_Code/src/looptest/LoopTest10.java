package looptest;

public class LoopTest10 {

    public static void main(String[] args){
        // 循环嵌套
        for (int i = 0; i < 3; i++){        // 外循环控制行
            for (int j = 0; j < 4; j++){    // 内循环控制列
                System.out.print("j: " + j + " ");    // 3 * 4 = 12次
            }
            System.out.println();   // 控制换行
        }
    }
}
