package loopexer;

public class LoopExer4 {
    public static void main(String[] args){
        // 练习：打印n*m的矩形
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
