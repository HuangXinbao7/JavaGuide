public class LoopTest3 {
    public static void main(String[] args) {

        l1: for (int i = 0; i < 10; i++) {
            l2: for (int j = 0; j < 4; j++) {
                System.out.println("j: " + j);
                if (j == 1) {
                    // break 中断的是最近的那层循环
                    //break l1;   // 中断标签指示的循环，实现跨循环中断
                    break;   // 中断标签指示的循环
                }
            }
            System.out.println("i:" +i);
        }
    }
}
