package looptest;

public class LoopTest11 {

    public static void main(String[] args){
        // 正斜率
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 2 * i + 3; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // 负斜率
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < -2 * i + 20; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
